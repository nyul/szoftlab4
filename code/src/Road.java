import java.util.ArrayList;

public class Road extends Tile{

	protected ArrayList<Road> nextRoad;	// referencia a kovetkezo ut-csempe valamelyikere
	protected boolean random = false;	// az utvonalvalasztasnal megadja, hogy veletlenszeruen valasszon az enemy utat vagy fixen
	
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
		int randValue = random == true ? (int)(Math.random()*nextRoad.size()) : 0;
		Writer.writeText.add("[" + enemy.getMyId() + ":" + enemy.getClass().getName() + "] has moved to " + nextRoad.get(randValue).getClass().getName() +  "(" + nextRoad.get(randValue).getPos().getX() + "," + nextRoad.get(randValue).getPos().getY() + ")");
		System.out.println("[" + enemy.getMyId() + ":" + enemy.getClass().getName() + "] has moved to " + nextRoad.get(randValue).getClass().getName() +  "(" + nextRoad.get(randValue).getPos().getX() + "," + nextRoad.get(randValue).getPos().getY() + ")");
		enemy.setRoad(nextRoad.get(randValue));
	}
}
