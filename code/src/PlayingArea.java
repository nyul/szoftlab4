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
		road = new ArrayList<Road>();
		mountain = new Mountain(new Position(-1, -1));
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
		geometry.createAllTile(6, 6);
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
	/**
	 * Ellenseg lepese a pos1-rol a pos2-re
	 * @param pos1 - start pos
	 * @param pos2 - end pos
	 */
	public void addReference(Position pos1, Position pos2) {
		// if pos1 is road
		for(int i = 0; i < road.size(); i++) {
			if(road.get(i).getPos().getX() == pos1.getX() && road.get(i).getPos().getY() == pos1.getY()) {
				// road to road
				for(int j = 0; j < road.size(); j++) {
					if(road.get(j).getPos().getX() == pos2.getX() && road.get(j).getPos().getY() == pos2.getY()) {
						road.get(i).nextRoad.add(road.get(j));
					}
				}
				// road to obstacle
				for(int j = 0; j < obstacle.size(); j++) {
					if(obstacle.get(j).getPos().getX() == pos2.getX() && obstacle.get(j).getPos().getY() == pos2.getY()) {
						road.get(i).nextRoad.add(obstacle.get(j));
					}
				}
				// road to mountain
				if(mountain.getPos().getX() == pos2.getX() && mountain.getPos().getY() == pos2.getY()) {
					road.get(i).nextRoad.add(mountain);
				}
			}
		}
		//if pos1 is obstacle
		for(int i = 0 ; i < obstacle.size(); i++) {
			if(obstacle.get(i).getPos().getX() == pos1.getX() && obstacle.get(i).getPos().getY() == pos1.getY()) {
				// obstacle to road
				for(int j = 0; j < road.size(); j++) {
					if(road.get(j).getPos().getX() == pos2.getX() && road.get(j).getPos().getY() == pos2.getY()) {
						obstacle.get(i).nextRoad.add(road.get(j));
					}
				}
				// obstacle to obstacle
				for(int j = 0; j < obstacle.size(); j++) {
					if(obstacle.get(j).getPos().getX() == pos2.getX() && obstacle.get(j).getPos().getY() == pos2.getY()) {
						obstacle.get(i).nextRoad.add(obstacle.get(j));
					}
				}
				// obstacle to mountain
				if(mountain.getPos().getX() == pos2.getX() && mountain.getPos().getY() == pos2.getY()) {
					obstacle.get(i).nextRoad.add(mountain);
				}
			}
		}
		
		//if pos1 is source
		for(int i = 0 ; i < source.size(); i++) {
			if(source.get(i).getPos().getX() == pos1.getX() && source.get(i).getPos().getY() == pos1.getY()) {
				// source to road
				for(int j = 0; j < road.size(); j++) {
					if(road.get(j).getPos().getX() == pos2.getX() && road.get(j).getPos().getY() == pos2.getY()) {
						source.get(i).nextRoad.add(road.get(j));
					}
				}
				// source to obstacle
				for(int j = 0; j < obstacle.size(); j++) {
					if(obstacle.get(j).getPos().getX() == pos2.getX() && obstacle.get(j).getPos().getY() == pos2.getY()) {
						source.get(i).nextRoad.add(obstacle.get(j));
					}
				}
				// source to mountain
				if(mountain.getPos().getX() == pos2.getX() && mountain.getPos().getY() == pos2.getY()) {
					source.get(i).nextRoad.add(mountain);
				}
			}
		}
	}
}
