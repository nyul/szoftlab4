import java.util.ArrayList;


public class Tower extends Tile implements Defense{
	
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
	
	/**
	 * Tower konstruktor
	 */
	
	public Tower(Position pos) {
		super(pos);
		shootPeriod = 10;
		range = 1;
		fogRange = range;
		damagePowerDwarf = 10;
		damagePowerElf = 10;
		damagePowerHobbit = 10;
		damagePowerHuman = 10;
		magicRock = new ArrayList<MagicRock>();
		this.type = 1;
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
	 * majd az enemy hit metodusat
	 * ami csokkenti az enemy erejet
	 */
	
	public Enemy attack(ArrayList<Enemy> enemies) {
		geometry.isInRange(enemy,this);
		enemy.hit(this);
		if(!Writer.question("Enemy eletereje nagyobb-e nullanal sebzes utan?")) {
			enemy.setActivity(false);
		}	
		return enemy;
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
		if(magicRock.getType() == 0) {
			this.range = this.range + 1;
		}
		else if(magicRock.getType() == 1) {
			this.shootPeriod = this.shootPeriod + 1;
		}
		if(magicRock.getType() == 2) {
			this.damagePowerHuman = this.damagePowerHuman + 10;
		}
		else if(magicRock.getType() == 3) {
			this.damagePowerHobbit = this.damagePowerHobbit + 10;
		}
		if(magicRock.getType() == 4) {
			this.damagePowerDwarf = this.damagePowerDwarf + 10;
		}
		else if(magicRock.getType() == 5) {
			this.damagePowerElf = this.damagePowerElf + 10;
		}
	}
	
	public void fogOn() {
		
	}
	
	public void fogOff() {
		
	}
}

