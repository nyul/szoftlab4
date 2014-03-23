
public class Tile {
	
	Tower tower;
	Obstacle obstacle;
	
	public Tile() {
		tower = null;
		obstacle = null;
	}
	
	public void createObject() {
		tower = new Tower();
		obstacle = new Obstacle();
	}
	
	public Tower buildTower(Player p) {
		Writer.entry();
		Writer.synchronexit();
		return tower;
	}

	public Obstacle buildObstacle(Player p) {
		Writer.entry();
		Writer.synchronexit();
		return obstacle;
	}

	public double distance(Position p1, Position p2) {
		Writer.entry();
		Writer.asynchronexit();
		return 0.0f;
	}
}
