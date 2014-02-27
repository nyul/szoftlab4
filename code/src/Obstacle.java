
public class Obstacle extends Tile{
	
	private int slowingFactor;
	
	public Obstacle(char c, Position p, int slow) {
		super(c, p);
		slowingFactor = slow;
		// TODO Auto-generated constructor stub
	}
	
	public int getSlowingFactor() {
		return slowingFactor;
	}
	
	public void setSlowingFactor(int number) {
		slowingFactor = number;
	}
}
