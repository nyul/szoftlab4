import java.util.ArrayList;
import java.util.Observable;

/**
 * A jatekos altal elhelyezhet tornyot reprezentalo objektum. Tarolja a lovesre
vonatkozo parametereket es a varazsko hasznalata eseten noveli is a
hatekonysagukat. Tarolja meg a rahelyezheto varazskovek atkualis szamat. Felelos
tovabba a kod le- es felszallasaert.
 *
 */
public class Tower extends Tile implements Defense{
	
	private ArrayList<TowerDraw> observers;
	private boolean fogOn;
	private boolean fogOff;
	public static int id = 0;  // azonosito generalashoz szukseges
	private int myId;  // azonosito
	private int shootPeriod;  // tuzelesi gayakorisag
	private int range;  // hatotavolsag
	private int fogRange;  // kod leereszkedese elotti hatotavolsagot tarolja
	private int damagePowerDwarf;  // Dwarf elleni sebzesi hatekonysag
	private int damagePowerElf; // Elf elleni sebzesi hatekonysag
	private int damagePowerHobbit; // Hobbit elleni sebzesi hatekonysag
	private int damagePowerHuman; // Human elleni sebzesi hatekonysag
	private ArrayList<MagicRock> magicRock;  // toronyra helyezheto varazskovek
	private int magicRockNumber;  // tornyon levo varazskovek szama
	public static final int price = 10;  // torony epitesi ara (globalis valtozo)
	protected boolean random;  // random mod allitasa
	protected boolean split;  // split mod, ha be van kapcsolva, akkor a megsebzett ellenseget mindig kettelovi
	private int happened;
	
	/**
	 * Tower konstruktor
	 * @param pos - az a pozicio ahova a tornyot epiteni kivanjuk
	 */
	public Tower(Position pos) {
		super(pos);
		observers = new ArrayList<TowerDraw>();
		fogOn = false;
		fogOff = false;
		myId=id;
		id++;
		shootPeriod = 10;
		range = 2;
		fogRange = range;
		damagePowerDwarf = 10;
		damagePowerElf = 10;
		damagePowerHobbit = 10;
		damagePowerHuman = 10;
		magicRock = new ArrayList<MagicRock>();
		for(int i = 0; i < 6; i++) {
			MagicRock rock = new MagicRock(i);
			magicRock.add(rock);
		}
		magicRockNumber = 0;
		this.type = 1;
		random = false;
		split = false;
		happened = 0;
	}
	
	public ArrayList<TowerDraw> getObservers() {
		return observers;
	}

	public boolean isFogOn() {
		return fogOn;
	}

	public void setFogOn(boolean fogOn) {
		this.fogOn = fogOn;
	}

	public boolean isFogOff() {
		return fogOff;
	}

	public void setFogOff(boolean fogOff) {
		this.fogOff = fogOff;
	}

	public int getMyId() {
		return myId;
	}

	public int getShootPeriod() {
		return shootPeriod;
	}

	public void setShootPeriod(int shootPeriod) {
		this.shootPeriod = shootPeriod;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getFogRange() {
		return fogRange;
	}

	public int getDamagePowerDwarf() {
		return damagePowerDwarf;
	}

	public void setDamagePowerDwarf(int damagePowerDwarf) {
		this.damagePowerDwarf = damagePowerDwarf;
	}

	public int getDamagePowerElf() {
		return damagePowerElf;
	}

	public void setDamagePowerElf(int damagePowerElf) {
		this.damagePowerElf = damagePowerElf;
	}
	
	public int getDamagePowerHobbit() {
		return damagePowerHobbit;
	}

	public void setDamagePowerHobbit(int damagePowerHobbit) {
		this.damagePowerHobbit = damagePowerHobbit;
	}

	public int getDamagePowerHuman() {
		return damagePowerHuman;
	}

	public void setDamagePowerHuman(int damagePowerHuman) {
		this.damagePowerHuman = damagePowerHuman;
	}

	public ArrayList<MagicRock> getMagicRock() {
		return magicRock;
	}

	public int getMagicRockNumber() {
		return magicRockNumber;
	}

	public void increaseMagicRockNumber(int number) {
		this.magicRockNumber += number;
	}

	/**
	 * A parameterul kapott enemy listara meghivja a tavolsag vizsgalatot, 
	 * majd az enemy hit metodusat, ami csokkenti az enemy erejet
	 */
	public Enemy attack(ArrayList<Enemy> enemies, Geometry geometry) {
		boolean isRange = false; // van-e hatotavon beluli ellenseg
		for(int i = 0; i < enemies.size(); i++) {
			if(geometry.isInRange(enemies.get(i),this)) { // ha hatotavolsagon belul van az ellenseg
				isRange = true;
				System.out.println("shoot");
				if(enemies.get(i).hit(this) <= 0) { // ha a megsebzett ellensegnek az elete 0-ra vagy az ala csokken
					enemies.get(i).setActivity(false); // jelezzuk az engine-nek, hogy ot deaktivalni kell
				}
				int duplicate = (int)(Math.random()*enemies.size()); // megnezzuk random modon kell-e kivalasztanunk, hogy kettevaljon az ellenseg sebzodes utan
				if(duplicate == 3) { // pseudo random modon "veletlenszeruen" kivalasztott eset amikor duplazodik az ellenseg
					System.out.println("HelloDuplicate");
					enemies.get(i).setDuplicated(true);
					enemies.get(i).setLifePower((int)(enemies.get(i).getLifePower() / 2));
				}
				return enemies.get(i);
			}
		}	
		if(isRange == false) { // ha hatotavolsagon kivul van az ellenseg
			Writer.writeText.add("Nincs hatotavon beluli ellenseg.");
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see Defense#wantToUpgrade(Player)
	 */
	public void wantToUpgrade(Player player){
		player.chooseUpgrade(magicRock, this);	
	}	
	
	/*
	 * (non-Javadoc)
	 * @see Defense#upgrade(MagicRock)
	 */
	public void upgrade(MagicRock magicRock){
		System.out.println("Upragedelem");
		if(magicRock.getType() == 0) { // hatotavolsag novelo varazsko
			this.range = this.range + 1;
		}
		else if(magicRock.getType() == 1) { // lovesi gyakorisagot novelo varazsko
			this.shootPeriod = this.shootPeriod - 3;
		}
		if(magicRock.getType() == 2) { // ember elleni sebzest novelo varazsko
			this.damagePowerHuman = this.damagePowerHuman + 10;
		}
		else if(magicRock.getType() == 3) { // hobbit elleni sebzest novelo varazsko
			this.damagePowerHobbit = this.damagePowerHobbit + 10;
		}
		if(magicRock.getType() == 4) { // torpe elleni sebzest novelo varazsko
			this.damagePowerDwarf = this.damagePowerDwarf + 10;
		}
		else if(magicRock.getType() == 5) { // elf elleni sebzest novelo varazsko
			this.damagePowerElf = this.damagePowerElf + 10;
		}
	}
	
	/**
	 * A kod bekapcsolasa a toronyra
	 */
	public void fogOn() {
		if(happened == 0) {
			this.fogRange = this.range; // elmenti a hatotavolsagot kod leereszkedesekor, hogy miutan elmult visszakapjuk az eredeti erteket
			this.range--;
			fogOn = true;
			happened = 1;
			setChanged();
			notifyObservers(this);
			Writer.writeText.add("[Fog has been set on]");
		}
	}
	
	/**
	 * Kod kikapcsolasa a tornyon
	 */
	public void fogOff() {
		if(happened == 1) {
			this.range = this.fogRange; // visszaallitja a kod elotti allapotra a hatotavolsagot
			fogOff = true;
			happened = 0;
			setChanged();
			notifyObservers(this);
			Writer.writeText.add("[Fog has been set off]");
		}
	}
	
	public void notifyObservers(Observable observable) {
		for(TowerDraw ob : observers) {
			if(fogOn == true) {
				System.out.println("Hellonotify");
				ob.update(observable, this.range);
			}
			else if(fogOff == true) {
				ob.update(observable, this.range);
			}
		}
	}
	
	/**
	 * Beregisztrálunk egy observert erre az osztályra
	 * @param observer
	 */
	public void registerObserver(TowerDraw draw) {
		observers.add(draw);
	}
	/**
	 * Töröljük az adott observer-t a listából: már nem kell értesülnie a model állapot változásairól
	 * @param observer
	 */
	public void removeObserver(TowerDraw draw) {
		observers.remove(draw);
	}
}

