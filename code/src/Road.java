
public class Road extends Tile{

	protected Road nextRoad;	// referencia a kovetkezo ut-csempere
	
	public Road(Position pos1) {
		super(pos1);
		//nextRoad = new Road(pos1);
		this.type = 2;
	}

	public void setNextRoad(Road nextRoad) {
		this.nextRoad = nextRoad;
	}



	/**
	 * Atadja a hivonak az ut kovetkezo poziciojat (ahova lepnie kell)
	 * @param e A lepni kivano enemy referenciaja
	 */
	public void requestDestination(Enemy e) {
		e.setRoad(nextRoad);
	}
}
