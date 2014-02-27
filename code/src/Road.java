
public class Road extends Tile{
	private Position nextRoad;
	
	public Road(char c, Position p1, Position p2) {
		super(c, p1);
		nextRoad = p2;
	}
	
	public Position getNextRoad() {
		return nextRoad;
	}
}
