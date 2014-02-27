import java.util.ArrayList;


public class PlayingArea {
	private ArrayList<Tile> tile;
	private ArrayList<Source> source;
	private ArrayList<Road> roadOne;
	private ArrayList<Road> roadTwo;
	private ArrayList<Tower> tower;
	private ArrayList<Obstacle> obstacle;
	private Mountain mountain;
	
	public PlayingArea() {
		tile = new ArrayList<Tile>();
		source = new ArrayList<Source>();
		roadOne = new ArrayList<Road>();
		roadTwo = new ArrayList<Road>();
		tower = new ArrayList<Tower>();
		obstacle = new ArrayList<Obstacle>();
	}
	
	public void initialize() {
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				tile.add(new Tile('0', new Position(i, j)));
			}
		}
		
		source.add(new Source('2', new Position(0, 4), new Position(0, 3)));
		source.add(new Source('2', new Position(3, 4), new Position(3, 3)));
		
		mountain = new Mountain('2', new Position(2, 0), null);
		
		roadOne.add(new Road('1', new Position(0, 3), new Position(0, 2)));
		roadOne.add(new Road('1', new Position(0, 2), new Position(0, 1)));
		roadOne.add(new Road('1', new Position(0, 1), new Position(1, 1)));
		roadOne.add(new Road('1', new Position(1, 1), new Position(1, 0)));
		roadOne.add(new Road('1', new Position(1, 0), new Position(2, 0)));
		
		roadTwo.add(new Road('1', new Position(3, 3), new Position(3, 2)));
		roadTwo.add(new Road('1', new Position(3, 2), new Position(3, 1)));
		roadTwo.add(new Road('1', new Position(3, 1), new Position(3, 0)));
		roadTwo.add(new Road('1', new Position(3, 0), new Position(2, 0)));
	}
	
	public boolean isSource(Tile t) {
		for(int i = 0; i < source.size(); i++) {
			if(source.get(i).getPos().equals(source.get(i).getPos(), t.getPos())) return true;
		}
		return false;
	}
	
	public boolean isMountain(Tile t) {
		if(mountain.getPos().equals(mountain.getPos(), t.getPos())) return true;
		return false;
	}
	
	public boolean isRoadOne(Tile t) {
		for(int i = 0; i < roadOne.size(); i++) {
			if(roadOne.get(i).getPos().equals(roadOne.get(i).getPos(), t.getPos())) return true;
		}
		return false;
	}
	
	public boolean isRoadTwo(Tile t) {
		for(int i = 0; i < roadTwo.size(); i++) {
			if(roadTwo.get(i).getPos().equals(roadTwo.get(i).getPos(), t.getPos())) return true;
		}
		return false;
	}
	
	public void addTower(Tower t) {
		tower.add(t);
	}
	
	public void addObstacle(Obstacle o) {
		obstacle.add(o);
	}
	
	public ArrayList<Tile> getTileList() {
		return tile;
	}
	
	public Tile getTile(Position p) {
		for(int i = 0; i < tile.size(); i++) {
			if(tile.get(i).getPos() == p) return tile.get(i);
		}
		return null;
	}
}
