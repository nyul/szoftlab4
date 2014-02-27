
public class Player {
	private int magicPower;
	private PlayingArea area;
	
	public Player(int number) {
		magicPower = number;
	}
	
	public Tower buildTower(char c, Tile t, int shoot, int distance, int damage) {
		if(isBuildTower(t)) {
			return new Tower(c, t.getPos(), shoot, distance, damage);
		}
		else return null;
	}
	
	public Obstacle buildObstacle(char c, Tile t, int slow) {
		if(isBuildObstacle(t)) {
			return new Obstacle(c, t.getPos(), slow);
		}
		else return null;
	}
	
	public boolean isBuildTower(Tile t) {
		if(t.getBeepitheto() == 0) return true;
		else return false;
	}
	
	public boolean isBuildObstacle(Tile t) {
		if(t.getBeepitheto() == 1) return true;
		else return false;
	}
	
	public void startGame() {
		area = new PlayingArea();
		area.initialize();
	}
	
	public int getMagicPower() {
		return magicPower;
	}
	
	public void setMagicPower(int number) {
		magicPower = number;
	}
	
	public PlayingArea getPlayingArea() {
		return area;
	}
}
