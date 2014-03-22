import java.util.ArrayList;


public class PlayingArea {
	
	ArrayList<Source> source;
	ArrayList<Tower> tower;
	ArrayList<Obstacle> obstacle;
	Mountain mountain;
	
	public PlayingArea() {
		
	}

	public void initialize() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public ArrayList<Source> getSourceList() {
		Writer.entry();
		Writer.synchronexit();
		return source;
	}
	
	public ArrayList<Obstacle> getObstacleList() {
		Writer.entry();
		Writer.synchronexit();
		return obstacle;
	}
	
	public ArrayList<Tower> getTowerList() {
		Writer.entry();
		Writer.synchronexit();
		return tower;
	}
	
	public Mountain getMountain() {
		Writer.entry();
		Writer.synchronexit();
		return mountain;
	}
		
	public void addTower(Tower t) {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public void addObstacle(Obstacle o) {
		Writer.entry();
		Writer.asynchronexit();
	}
	
}
