
public class Road extends Tile{
	
	Enemy enemy;
	Road nextRoad;
	
	public Road() {
		enemy = null;
		nextRoad = null;
	}
	
	public void createObject() {
		enemy = new Human();
		nextRoad = new Road();
	}
	
	/**
	 * Atadja a hivonak az ut kovetkezo poziciojat (ahova lepnie kell)
	 * @param e A lepni kivano enemy referenciaja
	 */
	public void requestDestination(Enemy e) {
		Writer.entry();
		enemy.setRoad(nextRoad);
		Writer.asynchronexit();
	}
	
	public Road getNextRoad() {
		Writer.entry();
		Writer.synchronexit();
		return nextRoad;
	}
}
