
public class Tile {
	
	private Position pos;
	private Tower tower;
	private Obstacle obstacle;
	
	public Tile(Position pos) {
		this.pos = pos;
	}
	
	public Tower buildTower(Player p) {
		Writer.entry();
		tower = new Tower(this.pos);
		Writer.synchronexit();
		return tower;
	}

	public Obstacle buildObstacle(Player p) {
		Writer.entry();
		obstacle = new Obstacle(this.pos);
		Writer.synchronexit();
		return obstacle;
	}

	public Position getPos() {
		Writer.entry();
		Writer.synchronexit();
		return pos;
	}

	public void setPos(Position p1) {
		Writer.entry();
		pos = p1;
		Writer.asynchronexit();
	}

	public double distance(Position p1, Position p2) {
		Writer.entry();
		Writer.asynchronexit();
		return 0.0f;
	}
}
