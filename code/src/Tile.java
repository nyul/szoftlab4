
public class Tile {
	
	Tower tower;
	Obstacle obstacle;
	Position pos;
	
	public Tile() {
		tower = null;
		obstacle = null;
		pos = null;
	}
	
	public void createObject() {
		obstacle = new Obstacle();
		pos = new Position();
	}
	
	public Tower buildTower(Player p) {
		Writer.entry();
		if(Writer.kerdes("Van elég varázserõ a toronyépítéshez?")){
			tower = new Tower();
			tower.setPos(pos);
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
			obstacle.setPos(pos);
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
	
	public void setPos(Position pos){
		Writer.entry();
		Writer.asynchronexit();
	};
}
