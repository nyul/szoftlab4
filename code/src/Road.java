
public class Road extends Tile{
	
	
	public Road(Position pos) {
		super(pos);
		System.out.println("Road() constructor");
	}
	
	public void requestDestination() {
		System.out.println("requestDestination(enemy)");
	}
}
