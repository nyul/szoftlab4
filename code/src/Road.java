
public class Road extends Tile{
	
	Enemy enemy;
	
	public Road() {
		enemy = null;
	}
	
	public void createObject() {
		enemy = new Human();
	}
	
	public void requestDestination(Enemy e) {
		Writer.entry();
		enemy.setRoad(this);
		Writer.asynchronexit();
	}
}
