
public class Road extends Tile{

	Road nextRoad;	// referencia a kovetkezo ut-csempere
	
	public Road() {
		nextRoad = null;
	}
	
	public void createObject() {
		nextRoad = new Road();
	}
	
	/**
	 * Atadja a hivonak az ut kovetkezo poziciojat (ahova lepnie kell)
	 * @param e A lepni kivano enemy referenciaja
	 */
	public void requestDestination(Enemy e) {
		Writer.entry();
		e.setRoad(nextRoad);
		Writer.asynchronexit();
	}
}
