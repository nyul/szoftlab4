
public class Player {
	private int magicPower;
	private PlayingArea area;
	
	public Player(int number) {
		magicPower = number;
	}
	
	public Tower buildTower(Tile t) {
		if(isBuildTower(t)) {
			magicPower = magicPower - 10;
			if(magicPower > 0) {
				System.out.println("The tower has successfully been putting off.");
				return new Tower(t.getBeepitheto(), t.getPos());
			}
			else {
				System.out.println("No more magicPower.");
				return null;
			}
		}
		System.out.println("This tile can not be built.");
		return null;
	}
	
	public Obstacle buildObstacle(Tile t) {
		if(isBuildObstacle(t)) {
			return new Obstacle(t.getBeepitheto(), t.getPos());
		}
		else return null;
	}
	
	public boolean isBuildTower(Tile t) {
		if(t.getBeepitheto() == '0') return true;
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
