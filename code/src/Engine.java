
public class Engine extends Thread{
	
	private Player player;
	private Fellowship fellowship;
	
	public Engine() {
		player = new Player(100);
		fellowship = new Fellowship();
	}
	
	
	
	public Player getPlayer() {
		return player;
	}



	public void setPlayer(Player player) {
		this.player = player;
	}



	public Fellowship getFellowship() {
		return fellowship;
	}



	public void setFellowship(Fellowship fellowship) {
		this.fellowship = fellowship;
	}



	public void attackHandler() {
		Enemy enemy = player.getArea().getTower()attack(fellowship.getActiveEnemies());
		if(!Writer.question("Megsebzett enemy aktiv-e?")) {
			fellowship.killEnemy(enemy);
		}
	}
	
	public void stepHandler() {
		fellowship.moveAllActiveEnemy();
	}
	
	public void takeToArea() {
		fellowship.startWave(0);
	}
	
	public void run() {
		stepHandler();
		attackHandler();
		try {
			Thread.sleep(100);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void defeat() {
		
	}
	
	public void victory() {
		
	}
}
