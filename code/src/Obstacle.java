
public class Obstacle extends Tile{
	
	private int slowingFactor;
	private int magicRockNumber;
	
	public Obstacle(char c, Position p) {
		super(c, p);
		price = 10;
		slowingFactor = 2;
		magicRockNumber = 0;
		// TODO Auto-generated constructor stub
	}
	
	public int getSlowingFactor() {
		return slowingFactor;
	}
	
	public void setSlowingFactor(int number) {
		slowingFactor = number;
	}
	
	public int getMagicRockNumber() {
		return magicRockNumber;
	}
	
	public void setMagicRockNumber(int number) {
		magicRockNumber = number;
	}
}
