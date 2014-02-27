
public class Main {
	
	public static void main(String[] args) {
		Player player = new Player(100);
		player.startGame();
		Tower t = player.buildTower('2', new Tile('2', new Position(1, 2)), 1000, 1, 20);
		player.getPlayingArea().addTower(t);
	}
}
