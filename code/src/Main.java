
public class Main {
	
	public static void main(String[] args) {  // sorrend fontos
		Engine engine = new Engine(new Player(100));
		engine.getPlayer().startGame();
		engine.run();
		
		Tower t = engine.getPlayer().buildTower(new Tile('0', new Position(1, 2)));
		t.setBeepitheto('2');
		engine.getPlayer().getPlayingArea().addTower(t);
		//Obstacle o = engine.getPlayer().buildObstacle(new Tile('0', new Position(0, 2)));
		//o.setBeepitheto('0');
		//engine.getPlayer().getPlayingArea().addObstacle(o);
	}
}
