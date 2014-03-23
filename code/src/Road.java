
public class Road extends Tile{
	
	Road nextRoad;
	
	public Road() {
		nextRoad = new Road();
	}
	
	public void requestDestination(Enemy e) {
		Writer.entry();
		
		Writer.asynchronexit();
	}
}
