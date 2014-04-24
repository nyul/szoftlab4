import java.util.ArrayList;

/**
 * A jatekos altal elhelyezhet tornyot reprezentalo objektum. Tarolja a lovesre
vonatkozo parametereket es a varazsko hasznalata eseten noveli is a
hatekonysagukat. Tarolja meg a rahelyezheto varazskovek atkualis szamat. Felelos
tovabba a kod le- es felszallasaert.
 *
 */
public class Tower extends Tile implements Defense{
	
	public static int id = 0;
	private int myId;
	private int shootPeriod;
	private int range;
	private int fogRange;
	private int damagePowerDwarf;
	private int damagePowerElf;
	private int damagePowerHobbit;
	private int damagePowerHuman;
	private ArrayList<MagicRock> magicRock;
	private int magicRockNumber;
	private static int price = 10;
	protected boolean random = false;
	protected boolean split = false;
	
	/**
	 * Tower konstruktor
	 * @param pos - az a pozicio ahova a tornyot epiteni kivanjuk
	 */
	public Tower(Position pos) {
		super(pos);
		myId=id;
		id++;
		shootPeriod = 10;
		range = 3;
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
		this.type = 1;
	}

	public int getMyId() {
		return myId;
	}

	public static void setPrice(int price) {
		Tower.price = price;
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

	public void setFogRange(int fogRange) {
		this.fogRange = fogRange;
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

	public void setMagicRock(ArrayList<MagicRock> magicRock) {
		this.magicRock = magicRock;
	}

	public int getMagicRockNumber() {
		return magicRockNumber;
	}

	public void setMagicRockNumber(int magicRockNumber) {
		this.magicRockNumber = magicRockNumber;
	}

	public static int getPrice() {
		return price;
	}

	/**
	 * A parameterul kapott enemy listara meghivja a tavolsag vizsgalatot, 
	 * majd az enemy hit metodusat, ami csokkenti az enemy erejet
	 */
	public Enemy attack(ArrayList<Enemy> enemies, Geometry geometry) {
		boolean isRange = false;
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
				return enemies.get(i);
			}
		}	
		if(isRange == false) { // ha hatotavolsagon kivul van az ellenseg
			Writer.writeText.add("Nincs hatotavon beluli ellenseg.");
			System.out.println("Nincs hatotavon beluli ellenseg.");
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
		this.range = this.range - 1;
		Writer.writeText.add("[Fog has been set on]");
		System.out.println("[Fog has been set on]");
	}
	
	/**
	 * Kod kikapcsolasa a tornyon
	 */
	public void fogOff() {
		this.range = this.fogRange; // visszaallitja a kod elotti allapotra a hatotavolsagot
		Writer.writeText.add("[Fog has been set off]");
		System.out.println("[Fog has been set off]");
	}
}

