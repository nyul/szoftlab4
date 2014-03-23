
public class Tile {
	Position pos;
	
	public Tile() {
		pos = null;
	}
	
	public void createObject() {
		pos = new Position();		
	}
	
	public Tower buildTower(Player p) {
		Writer.entry();
		createObject();
		Tower twr = new Tower(); 
		twr.setPos(pos);
		p.reduceMagicPower(0);
		Writer.synchronexit();
		return twr;			
		
	}

	public Obstacle buildObstacle(Player p) {
		Writer.entry();
		createObject();
		Obstacle obstacle = new Obstacle();
		obstacle.setPos(pos);
		p.reduceMagicPower(0);
		Writer.synchronexit();
		return obstacle;	
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
