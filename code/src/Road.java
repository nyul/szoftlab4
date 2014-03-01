
public class Road extends Tile{
	private Position nextRoadPos;
	
	public Road(char c, Position p1, Position p2) {
		super(c, p1);
		this.price = 0;
		nextRoadPos = p2;
	}
	
	public Position getNextRoadPos() {
		return nextRoadPos;
	}
}
