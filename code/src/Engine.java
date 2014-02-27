
public class Engine extends Thread{
	private Player player;
	private Enemy enemy;
	
	public Engine(Player p) {
		player = p;
		enemy = new Enemy(100, 10, new Position(0, 4), new Position(0, 3));
	}
	
	public void stepHandler() {
		
	}
	public void towerHandler() {
		
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void run() {
		while(true) {
			stepHandler();
			towerHandler();
			enemy.move();
			System.out.println("Hello");
		
			try {
				Thread.sleep(100);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
