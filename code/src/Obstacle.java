
public class Obstacle extends Tile{
	
	private int slowingFactor;
	
	public Obstacle(char c, Position p) {
		super(c, p);
		slowingFactor = 2;
		// TODO Auto-generated constructor stub
	}
	
	public int getSlowingFactor() {
		return slowingFactor;
	}
	
	public void setSlowingFactor(int number) {
		slowingFactor = number;
	}
}
