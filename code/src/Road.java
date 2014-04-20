import java.util.ArrayList;


public class Road extends Tile{

	protected ArrayList<Road> nextRoad;	// referencia a kovetkezo ut-csempe valamelyikere
	
	public Road(Position pos1) {
		super(pos1);
		nextRoad = new ArrayList<Road>();
		this.type = 2;
	}

	public void addRoad(Road r) {
		nextRoad.add(r);
		System.out.println("addRoad:" + nextRoad.size());
	}
	
	/**
	 * Atadja a hivonak az ut kovetkezo poziciojat (ahova lepnie kell)
	 * @param e A lepni kivano enemy referenciaja
	 */
	public void requestDestination(Enemy enemy) {
		//System.out.println("Hello");
		int randValue = (int)(Math.random()*nextRoad.size());
		System.out.println(nextRoad.size());
		enemy.setRoad(nextRoad.get(randValue));
	}
}
