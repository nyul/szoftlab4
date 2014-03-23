
public class Road extends Tile{
	
	Road nextRoad;
	
	public Road() {
		nextRoad = null;
	}
	
	public void createObject() {
		nextRoad = new Road();
	}
	
	public void requestDestination(Enemy e) {
		Writer.entry();
		e.setRoad(nextRoad);
		Writer.asynchronexit();
	}
}
