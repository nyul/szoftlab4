import java.util.ArrayList;

/**
 * A jatekos altal elhelyezhet tornyot reprezentalo objektum. Tarolja a lovesre
vonatkozo parametereket es a varazsko hasznalata eseten noveli is a
hatekonysagukat. Tarolja meg a rahelyezheto varazskovek atkualis szamat. Felelos
tovabba a kod le- es felszallasaert.
 *
 */
public class Tower extends Tile implements Defense{
	
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
	
	/**
	 * Tower konstruktor
	 * @param pos - az a pozicio ahova a tornyot epiteni kivanjuk
	 */
	public Tower(Position pos) {
		super(pos);
		myId=id;
		id++;
		shootPeriod = 10;
		range = 2;
		fogRange = range;
		damagePowerDwarf = 10;
		damagePowerElf = 10;
		damagePowerHobbit = 50;
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
				if(enemies.get(i).hit(this) <= 0) { // ha a megsebzett ellensegnek az elete 0-ra vagy az ala csokken
					enemies.get(i).setActivity(false); // jelezzuk az engine-nek, hogy ot deaktivalni kell
				}
				int duplicate = random == true ? (int)(Math.random()*enemies.size()) : 1; // megnezzuk random modon kell-e kivalasztanunk, hogy kettevaljon az ellenseg sebzodes utan
				duplicate = split == true ? 3 : duplicate;
				if(duplicate == 3) { // pseudo random modon "veletlenszeruen" kivalasztott eset amikor duplazodik az ellenseg
					enemies.get(i).setDuplicated(true);
					enemies.get(i).setLifePower((int)(enemies.get(i).getLifePower() / 2));
				}
				System.out.println("Lottem");
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
		this.fogRange = this.range; // elmenti a hatotavolsagot kod leereszkedesekor, hogy miutan elmult visszakapjuk az eredeti erteket
		this.range--;
		Writer.writeText.add("[Fog has been set on]");
	}
	
	/**
	 * Kod kikapcsolasa a tornyon
	 */
	public void fogOff() {
		this.range = this.fogRange; // visszaallitja a kod elotti allapotra a hatotavolsagot
		Writer.writeText.add("[Fog has been set off]");
	}
}

