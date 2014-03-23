
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
		createObject();
		if(Writer.kerdes("Van elég varázserõ a akadályépítéshez?")){
			Writer.synchronexit();
			return tower;
		}
		else 
			return null;
		
	}

	public Obstacle buildObstacle(Player p) {
		Writer.entry();
		createObject();
		if(Writer.kerdes("Van elég varázserõ a akadályépítéshez?")){
			setPos();
			Writer.synchronexit();
			return obstacle;
		}
		else 
			return null;
		
	}

	public double distance(Position p1, Position p2) {
		Writer.entry();
		Writer.asynchronexit();
		return 0.0f;
	}
}
