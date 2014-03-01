
public class Tower extends Tile{
	private int shootPeriod;
	private int distance;
	private int damagePowerHuman;
	private int damagePowerHobbit;
	private int damagePowerDwarf;
	private int damagePowerElf;
	private int magicRockNumber;
	
	
	public Tower(char c, Position p) {
		super(c, p);
		price = 20;
		shootPeriod = 1;
		distance = 1;
		damagePowerHuman = 20;
		damagePowerHobbit = 20;
		damagePowerDwarf = 20;
		damagePowerElf = 20;
		magicRockNumber = 0;
		// TODO Auto-generated constructor stub
	}
	
	public int getShootPeriod() {
		return shootPeriod;
	}
	
	public void setShootPeriod(int number) {
		shootPeriod = number;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int number) {
		distance = number;
	}
	
	public int getDamagePowerHuman() {
		return damagePowerHuman;
	}
	
	public void setDamagePowerHuman(int number) {
		damagePowerHuman = number;
	}
	
	public int getDamagePowerHobbit() {
		return damagePowerHobbit;
	}
	
	public void setDamagePowerHobbit(int number) {
		damagePowerHobbit = number;
	}
	
	public int getDamagePowerDwarf() {
		return damagePowerDwarf;
	}
	
	public void setDamagePowerDwarf(int number) {
		damagePowerDwarf = number;
	}
	
	public int getDamagePowerElf() {
		return damagePowerElf;
	}
	
	public void setDamagePowerElf(int number) {
		damagePowerElf = number;
	}
	
	public int getMagicRockNumber() {
		return magicRockNumber;
	}
	
	public void setMagicRockNumber(int number) {
		magicRockNumber = number;
	}
}
