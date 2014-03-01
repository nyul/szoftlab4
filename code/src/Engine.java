
public class Engine extends Thread{
	private Player player;
	private Fellowship fellowship;
	
	public Engine(Player p, Fellowship f) {
		player = p;
		fellowship = f;
		//human = new Human(100, 10, new Position(0, 4), new Position(0, 3));
	}
 	
	public void stepHandler() {
		
	}
	public void towerHandler() {
		
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Fellowship getFellowShip() {
		return fellowship;
	}
	
	public void run() {
		while(true) {
			stepHandler();
			towerHandler();
			//human.move();
			System.out.println("Hello");
		
			try {
				Thread.sleep(100);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
