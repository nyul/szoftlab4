
public class Road extends Tile{
	
	Obstacle nextroad;
	
	/**
	 * Atadja a hivonak az ut kovetkezo poziciojat (ahova lepnie kell)
	 * @param e A lepni kivano enemy referenciaja
	 */
	public void requestDestination(Enemy e) {
		Writer.entry();
		e.setRoad(nextroad);
		Writer.asynchronexit();
	}
}
