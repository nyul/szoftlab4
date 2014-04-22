import java.util.ArrayList;


public class Road extends Tile{

	protected ArrayList<Road> nextRoad;	// referencia a kovetkezo ut-csempe valamelyikere
	
	public Road(Position pos) {
		super(pos);
		nextRoad = new ArrayList<Road>();
		this.type = 2;
	}
	
	/**
	 * Atadja a hivonak az ut kovetkezo poziciojat (ahova lepnie kell)
	 * @param e A lepni kivano enemy referenciaja
	 */
	public void requestDestination(Enemy enemy) {
		int randValue = (int)(Math.random()*nextRoad.size());
		System.out.println("[" + enemy.getId() + ":" + enemy.getClass() + "] has moved to Road(" + nextRoad.get(randValue).getPos().getX() + "," + nextRoad.get(randValue).getPos().getY() + ")");
		//System.out.println(nextRoad.size());
		enemy.setRoad(nextRoad.get(randValue));
	}
}
