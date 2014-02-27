
public class Tower extends Tile{
	private int shootPeriod;
	private int distance;
	private int damagePower;
	
	public Tower(char c, Position p) {
		super(c, p);
		shootPeriod = 1000;
		distance = 1;
		damagePower = 20;
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
	
	public int getDamagePower() {
		return damagePower;
	}
	
	public void setDamagePower(int number) {
		damagePower = number;
	}
}
