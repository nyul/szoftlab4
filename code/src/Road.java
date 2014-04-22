import java.util.ArrayList;

public class Road extends Tile{

	protected ArrayList<Road> nextRoad;	// referencia a kovetkezo ut-csempe valamelyikere
	protected boolean random = false;	// az utvonalvalasztasnal megadja, hogy veletlenszeruen valasszon az enemy utat vagy fixen
	
	/**
	 * Road konstruktor
	 * @param pos - Annak a csempenek a pozicioja amelyikre el szeretnenk helyezni ezt az Ut elemet.
	 */
	public Road(Position pos) {
		super(pos);
		nextRoad = new ArrayList<Road>();
		this.type = 2;
	}
	
	/**
	 * Atadja a hivonak az ut kovetkezo poziciojat (ahova lepnie kell).
	 * Attol fuggoen fog eldolni, hogy tobb lehetseges ut eseten melyik elsz a kovetkezo csempe, hogy a bemeneti nyelvben volt-e RANDOM_ON hivas. 
	 * Ha volt, akkor veletlenszeruen dont az enemy a lehetseges mezok kozul, ha nem volt akkor pedig fixen a 0. indexure fog lepni.
	 * @param e - A lepni kivano enemy referenciaja
	 */
	public void requestDestination(Enemy enemy) {
		int randValue = random == true ? (int)(Math.random()*nextRoad.size()) : 0;
		Writer.writeText.add("[" + enemy.getMyId() + ":" + enemy.getClass().getName() + "] has moved to " + nextRoad.get(randValue).getClass().getName() +  "(" + nextRoad.get(randValue).getPos().getX() + "," + nextRoad.get(randValue).getPos().getY() + ")");
		enemy.setRoad(nextRoad.get(randValue));
	}
}
