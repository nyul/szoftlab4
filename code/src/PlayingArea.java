import java.util.ArrayList;


/**
 * A jatekteret reprezentalo objektum. A palyat felepito elemtipusok csoportjait tartalmazza. 
 * 
 * Felelossege: A palya inicializalasa.
 * Felelos azert, hogy informaciot szolgaltasson a terkep egyes mezoinek tulajdonsagairol,
 * ilyen informaciaszolgaltatas peldaul a jatekos informalasa a mezo beepithetosegrol 
 * vagy az ellenseg informalasa az ut következo mezojerol.
 */
public class PlayingArea {
	
	private ArrayList<Source> source;
	private ArrayList<Tower> tower;
	private ArrayList<Obstacle> obstacle;
	private ArrayList<Road> road;
	private Mountain mountain;
	private Geometry geometry;
	
	public PlayingArea() {
		source = new ArrayList<Source>();
		tower = new ArrayList<Tower>();
		obstacle = new ArrayList<Obstacle>();
		mountain = null;
		geometry = new Geometry();
	}
	
	
	
	public ArrayList<Source> getSource() {
		return source;
	}



	public void setSource(ArrayList<Source> source) {
		this.source = source;
	}



	public ArrayList<Tower> getTower() {
		return tower;
	}



	public void setTower(ArrayList<Tower> tower) {
		this.tower = tower;
	}



	public ArrayList<Obstacle> getObstacle() {
		return obstacle;
	}



	public void setObstacle(ArrayList<Obstacle> obstacle) {
		this.obstacle = obstacle;
	}

	

	public ArrayList<Road> getRoad() {
		return road;
	}



	public void setRoad(ArrayList<Road> road) {
		this.road = road;
	}



	public Mountain getMountain() {
		return mountain;
	}



	public void setMountain(Mountain mountain) {
		this.mountain = mountain;
	}



	public Geometry getGeometry() {
		return geometry;
	}



	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}



	/**
	 * A palyat inicializalja.
	 * 
	 * Az ut / utak betotese amin az ellensegek haladnak.
	 * Hegy koordinatajanak megadasa, forras(ok) megadasa.
	 */
	public void initialize() {
		// loadMap kell ide
	}
	
	/**
	 * Hozzaad egy tornyot a tornyok listajahoz.
	 * @param t - a hozzaadni kivant torony referenciaja
	 */
	public void addTower(Tower t) {
		this.tower.add(t);
	}
	
	/**
	 * Hozzaad egy akadalyt az akadalyok listajahoz.
	 * @param o - a hozzaadni kivant akadaly referenciaja
	 */	
	public void addObstacle(Obstacle o) {
		this.obstacle.add(o);
	}
	
	/**
	 * Megadja, hogy aktualis tickben van-e ellenseg a hegyen.
	 * Ha igen akkor a parameterul kapott engine referencian meghivja a defeat() metodust tehat a jatek veget er.
	 * @param e - az engine osztaly referenciaja
	 */
	public void isOnMountain(Engine engine){
		for(int i = 0; i < engine.getFellowship().getActive().size(); i++) {
			if(engine.getFellowship().getActive().get(i).getRoad().equals(mountain)) {
				engine.defeat();
			}
		}						
	}
}
