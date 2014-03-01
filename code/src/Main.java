
public class Main {
	
	public static void main(String[] args) {  // sorrend fontos
		Engine engine = new Engine(new Player(100), new Fellowship(2, 6));
		engine.getPlayer().startGame();
		
		Tower t = engine.getPlayer().buildTower(new Tile('0', new Position(1, 2)));
		t.setType('2');
		engine.getPlayer().getPlayingArea().addTower(t);
		
		engine.getPlayer().buyMagicRock(t, 0);
		
		Obstacle o = engine.getPlayer().buildObstacle(new Tile('1', new Position(0, 2)));
		o.setType('2');
		engine.getPlayer().getPlayingArea().addObstacle(o);
		
		engine.run();
	}
}
