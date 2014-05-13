import java.util.ArrayList;

public class Road extends Tile{

	/**
	 * referencia a kovetkezo ut-csempe valamelyikere
	 * az utvonalvalasztasnal megadja, hogy veletlenszeruen valasszon az enemy utat vagy fixen
	 */
	protected ArrayList<Road> nextRoad;
	protected ArrayList<Road> previousRoad;
	protected boolean random;
	
	/**
	 * Road konstruktor
	 * @param pos - Annak a csempenek a pozicioja amelyikre el szeretnenk helyezni ezt az Ut elemet.
	 */
	public Road(Position pos) {
		super(pos);
		nextRoad = new ArrayList<Road>();
		previousRoad = new ArrayList<Road>();
		this.type = 2;
		random = false;
	}
	
	public boolean isRandom() {
		return random;
	}

	public void setRandom(boolean random) {
		this.random = random;
	}

	public ArrayList<Road> getNextRoad() {
		return nextRoad;
	}
	
	public ArrayList<Road> getPreviousRoad() {
		return previousRoad;
	}
	
	/**
	 * nextRoad listahoz hozzaadunk egy uj Road elemet
	 * @param road
	 */
	public void addRoad(Road road) {
		nextRoad.add(road);
	}

	/**
	 * Atadja a hivonak az ut kovetkezo poziciojat (ahova lepnie kell).
	 * Attol fuggoen fog eldolni, hogy tobb lehetseges ut eseten melyik elsz a kovetkezo csempe, hogy a bemeneti nyelvben volt-e RANDOM_ON hivas. 
	 * Ha volt, akkor veletlenszeruen dont az enemy a lehetseges mezok kozul, ha nem volt akkor pedig fixen a 0. indexure fog lepni.
	 * @param e - A lepni kivano enemy referenciaja
	 */
	public void requestDestination(Enemy enemy) {
		int randValue = (int)(Math.random()*nextRoad.size());
		Writer.writeText.add("[" + enemy.getMyId() + ":" + enemy.getClass().getName() + "] has moved to " + nextRoad.get(randValue).getClass().getName() +  "(" + nextRoad.get(randValue).getPos().getX() + "," + nextRoad.get(randValue).getPos().getY() + ")");
		enemy.setRoad(nextRoad.get(randValue));
	}
}
