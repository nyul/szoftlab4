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
	
	TowerDraw towerDraw;
	private ArrayList<Source> source;
	private ArrayList<Tower> tower;
	private ArrayList<Obstacle> obstacle;
	private ArrayList<Road> road;
	private Mountain mountain;
	private Geometry geometry;
	
	/**
	 * PlayingArea konstruktor
	 */
	public PlayingArea() {
		towerDraw = new TowerDraw();
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

	public ArrayList<Tower> getTower() {
		return tower;
	}

	public ArrayList<Obstacle> getObstacle() {
		return obstacle;
	}

	public ArrayList<Road> getRoad() {
		return road;
	}

	/**
	 * Visszaadja a hegy objektumot
	 * @return - hegy objektum
	 */
	public Mountain getMountain() {
		return mountain;
	}

	/**
	 * Beallithatjuk a hegy poziciojat
	 * @param mountain - egy Mountain peldany
	 */
	public void setMountain(Mountain mountain) {
		this.mountain = mountain;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	/**
	 * A palyat inicializalja.
	 * 
	 * Az ut / utak betotese amin az ellensegek haladnak.
	 * Hegy koordinatajanak megadasa, forras(ok) megadasa.
	 */
	public void initialize() {
		geometry.createAllTile(10, 10);
	}
	
	public void addRoad(Road r) {
		this.road.add(r);
	}
	
	public void removeRoad(int index) {
		if(this.road.size() > 0) {
			this.road.remove(index);
		}
	}
	
	public void addSource(Source s) {
		this.source.add(s);
	}
	
	public void removeSource(Source s) {
		if(this.source.size() > 0) {
			this.source.remove(s);
		}
	}
	
	/**
	 * Hozzaad egy tornyot a tornyok listajahoz.
	 * @param t - a hozzaadni kivant torony referenciaja
	 */
	public void addTower(Tower t) {
		this.tower.add(t);
	}
	
	public void removeTower(Tower t) {
		if(tower.size() > 0) {
			tower.remove(t);
		}
	}
	
	/**
	 * Hozzaad egy akadalyt az akadalyok listajahoz.
	 * @param o - a hozzaadni kivant akadaly referenciaja
	 */	
	public void addObstacle(Obstacle o) {
		this.obstacle.add(o);
	}
	
	public void removeObstacle(Obstacle o) {
		if(obstacle.size() > 0) {
			obstacle.remove(o);
		}
	}
	
	/**
	 * Megadja, hogy aktualis tickben van-e ellenseg a hegyen.
	 * Ha igen akkor a parameterul kapott engine referencian meghivja a defeat() metodust tehat a jatek veget er.
	 * @param e - az engine osztaly referenciaja
	 */
	public void isOnMountain(Engine engine){
		for(int i = 0; i < engine.getFellowship().getActive().size(); i++) { //vegigiteral az aktiv ellensegek listajan
			if(engine.getFellowship().getActive().get(i).getRoad().equals(mountain)) { // ha barmelyiknek megegyezik a pozicioja a heggyel
				engine.defeat(); // vege a jateknak, elvesztettuk
			}
		}						
	}
	
	public void changeReferenceTo(Position pos1, Position pos2) {
		// if pos1 is road
		for(int i = 0; i < road.size(); i++) {
			if(road.get(i).getPos().getX() == pos1.getX() && road.get(i).getPos().getY() == pos1.getY()) {
				// road to obstacle
				for(int j = 0; j < obstacle.size(); j++) {
					if(obstacle.get(j).getPos().getX() == pos2.getX() && obstacle.get(j).getPos().getY() == pos2.getY()) {
						// csak road-hoz kapcsolodhatott
						for(int k = 0; k < road.get(i).getNextRoad().size(); k++) {
							if(road.get(i).getNextRoad().get(k).getPos().getX() == obstacle.get(j).getPos().getX() && road.get(i).getNextRoad().get(k).getPos().getY() == obstacle.get(j).getPos().getY()) {
								road.get(i).getNextRoad().remove(k);
							}
						}
						road.get(i).addRoad(obstacle.get(j));
					}
				}
			}
		}
		// if pos1 is obstacle
				for(int i = 0; i < obstacle.size(); i++) {
					if(obstacle.get(i).getPos().getX() == pos1.getX() && obstacle.get(i).getPos().getY() == pos1.getY()) {
						// obstacle to obstacle
						for(int j = 0; j < obstacle.size(); j++) {
							if(obstacle.get(j).getPos().getX() == pos2.getX() && obstacle.get(j).getPos().getY() == pos2.getY()) {
								for(int k = 0; k < obstacle.get(i).getNextRoad().size(); k++) {
									if(obstacle.get(i).getNextRoad().get(k).getPos().getX() == obstacle.get(j).getPos().getX() && obstacle.get(i).getNextRoad().get(k).getPos().getY() == obstacle.get(j).getPos().getY()) {
										obstacle.get(i).getNextRoad().remove(k);
									}
								}
								obstacle.get(i).addRoad(obstacle.get(j));
							}
						}
					}
				}
	}
	
	public void changeReferenceFrom(Position pos1, ArrayList<Road> target) {
		// pos1 is Obstacle
		for(int i = 0; i < obstacle.size(); i++) {
			if(obstacle.get(i).getPos().getX() == pos1.getX() && obstacle.get(i).getPos().getY() == pos1.getY()) {
				for(int j = 0; j < target.size(); j++) {
					obstacle.get(i).getNextRoad().add(target.get(j));
				}
			}
		}
	}
	
	
	/**
	 * Ellenseg lepese a pos1-rol a pos2-re
	 * Annak fuggvenyeben, hogy mi a forras-cel csempe
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
						road.get(i).addRoad(road.get(j));
					}
				}
				// road to obstacle
				for(int j = 0; j < obstacle.size(); j++) {
					if(obstacle.get(j).getPos().getX() == pos2.getX() && obstacle.get(j).getPos().getY() == pos2.getY()) {
						road.get(i).addRoad(obstacle.get(j));
					}
				}
				// road to mountain
				if(mountain.getPos().getX() == pos2.getX() && mountain.getPos().getY() == pos2.getY()) {
					road.get(i).addRoad(mountain);
				}
			}
		}
		//if pos1 is obstacle
		for(int i = 0 ; i < obstacle.size(); i++) {
			if(obstacle.get(i).getPos().getX() == pos1.getX() && obstacle.get(i).getPos().getY() == pos1.getY()) {
				// obstacle to road
				for(int j = 0; j < road.size(); j++) {
					if(road.get(j).getPos().getX() == pos2.getX() && road.get(j).getPos().getY() == pos2.getY()) {
						obstacle.get(i).addRoad(road.get(j));
					}
				}
				// obstacle to obstacle
				for(int j = 0; j < obstacle.size(); j++) {
					if(obstacle.get(j).getPos().getX() == pos2.getX() && obstacle.get(j).getPos().getY() == pos2.getY()) {
						obstacle.get(i).addRoad(obstacle.get(j));
					}
				}
				// obstacle to mountain
				if(mountain.getPos().getX() == pos2.getX() && mountain.getPos().getY() == pos2.getY()) {
					obstacle.get(i).addRoad(mountain);
				}
			}
		}
		
		//if pos1 is source
		for(int i = 0 ; i < source.size(); i++) {
			if(source.get(i).getPos().getX() == pos1.getX() && source.get(i).getPos().getY() == pos1.getY()) {
				// source to road
				for(int j = 0; j < road.size(); j++) {
					if(road.get(j).getPos().getX() == pos2.getX() && road.get(j).getPos().getY() == pos2.getY()) {
						source.get(i).addRoad(road.get(j));
					}
				}
				// source to obstacle
				for(int j = 0; j < obstacle.size(); j++) {
					if(obstacle.get(j).getPos().getX() == pos2.getX() && obstacle.get(j).getPos().getY() == pos2.getY()) {
						source.get(i).addRoad(obstacle.get(j));
					}
				}
			}
		}
	}
	
	public void isBuildable(Tile tile) {
		if(tile instanceof Road && !(tile instanceof Obstacle) && !(tile instanceof Source) && !(tile instanceof Mountain)) {
			Road r = (Road) tile;
			for(int i = 0; i < geometry.getTiles().size(); i++) {
				for(int j = 0; j < geometry.getTiles().get(i).size(); j++) {
					// megkeressuk ezt a csempet a tiles listaban
					if(geometry.getTiles().get(i).get(j).getPos().getX() == r.getPos().getX() && geometry.getTiles().get(i).get(j).getPos().getY() == r.getPos().getY()) {
						if(geometry.getTiles().get(i).get(j).getType() == 0) { // ha ures ez a csempe
							addRoad(r);
							geometry.setTile(i, j, r);
						}
						else {
							Writer.writeText.add("Load map is unsuccessful.");
							Writer.writeText.add("Error: (" + r.getPos().getX() + "," + r.getPos().getY() + ") tile is unbuildable for a Road.");
						}
					}
				}
			}
		}
		else if(tile instanceof Source) {
			Source s = (Source) tile;
			for(int i = 0; i < geometry.getTiles().size(); i++) {
				for(int j = 0; j < geometry.getTiles().get(i).size(); j++) {
					if(geometry.getTiles().get(i).get(j).getPos().getX() == s.getPos().getX() && geometry.getTiles().get(i).get(j).getPos().getY() == s.getPos().getY()) {
						if(geometry.getTiles().get(i).get(j).getType() == 0) {
							addSource(s);
							geometry.setTile(i, j, s);
						}
						else {
							Writer.writeText.add("Load map is unsuccessful.");
							Writer.writeText.add("Error: (" + s.getPos().getX() + "," + s.getPos().getY() + ") tile is unbuildable for a Source.");
						}
					}
				}
			}
		}
		else if(tile instanceof Mountain) {
			Mountain m = (Mountain) tile;
			for(int i = 0; i < geometry.getTiles().size(); i++) {
				for(int j = 0; j < geometry.getTiles().get(i).size(); j++) {
					if(geometry.getTiles().get(i).get(j).getPos().getX() == m.getPos().getX() && geometry.getTiles().get(i).get(j).getPos().getY() == m.getPos().getY()) {
						if(geometry.getTiles().get(i).get(j).getType() == 0) {
							mountain = m;
							geometry.setTile(i, j, m);
						}
						else {
							Writer.writeText.add("Load map is unsuccessful.");
							Writer.writeText.add("Error: (" + m.getPos().getX() + "," + m.getPos().getY() + ") tile is unbuildable for a Mountain.");
						}
					}
				}
			}
		}
		else if(tile instanceof Obstacle) {
			Obstacle o = (Obstacle) tile;
			for(int i = 0; i < geometry.getTiles().size(); i++) {
				for(int j = 0; j < geometry.getTiles().get(i).size(); j++) {
					if(geometry.getTiles().get(i).get(j).getPos().getX() == o.getPos().getX() && geometry.getTiles().get(i).get(j).getPos().getY() == o.getPos().getY()) {
						if(geometry.getTiles().get(i).get(j).getType() == 2) {
							
							addObstacle(o);
							for(int k = 0; k < road.size(); k++) {
								if(road.get(k) == geometry.getTiles().get(i).get(j)) {
									removeRoad(k);
								}
							}
							geometry.setTile(i, j, o);
						}
						else {
							Writer.writeText.add("Load map is unsuccessful.");
							Writer.writeText.add("Error: (" + o.getPos().getX() + "," + o.getPos().getY() + ") tile is unbuildable for an Obstacle.");
						}
					}
				}
			}
		}
		else if(tile instanceof Tower) {
			Tower t = (Tower) tile;
			for(int i = 0; i < geometry.getTiles().size(); i++) {
				for(int j = 0; j < geometry.getTiles().get(i).size(); j++) {
					if(geometry.getTiles().get(i).get(j).getPos().getX() == t.getPos().getX() && geometry.getTiles().get(i).get(j).getPos().getY() == t.getPos().getY()) {
						if(geometry.getTiles().get(i).get(j).getType() == 0) {
							addTower(t);
							t.registerObserver(towerDraw);
							geometry.setTile(i, j, t);
						}
						else {
							Writer.writeText.add("Load map is unsuccessful.");
							Writer.writeText.add("Error: (" + t.getPos().getX() + "," + t.getPos().getY() + ") tile is unbuildable for a Tower.");
						}
					}
				}
			}
		}
	}
}
