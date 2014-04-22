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
<<<<<<< HEAD
		System.out.println("[" + enemy.getMyId() + ":" + enemy.getClass().getName() + "] has moved to " + nextRoad.get(randValue).getClass().getName() +  "(" + nextRoad.get(randValue).getPos().getX() + "," + nextRoad.get(randValue).getPos().getY() + ")");
=======
		System.out.println("[" + enemy.getId() + ":" + enemy.getClass() + "] has moved to Road(" + nextRoad.get(randValue).getPos().getX() + "," + nextRoad.get(randValue).getPos().getY() + ")");
		//System.out.println(nextRoad.size());
>>>>>>> 66296f8bd5d09119ced204fcfba61b042db70f22
		enemy.setRoad(nextRoad.get(randValue));
	}
}
