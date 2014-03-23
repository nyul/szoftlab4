
public class Engine extends Thread{
 	
	Player player;
	Fellowship fellowship;
	Tower tower;
	Obstacle obsctacle;
	
	public Engine() {
		player = null;
		fellowship = null;
		tower = null;
		obsctacle = null;
	}
	
	public void createObject() {
		player = new Player();
		fellowship = new Fellowship();
		tower = new Tower();
		obsctacle = new Obstacle();
	}
	
	public void attackHandler() {
		Writer.entry();
		tower.attack(fellowship.getActiveEnemies());
		Writer.asynchronexit();
	}
	
	public void stepHandler() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public void takeToArea() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public void run() {
		Writer.entry();
		attackHandler();
		stepHandler();
		takeToArea();
		Writer.asynchronexit();
	}
	
	public void defeat() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public void victory() {
		Writer.entry();
		Writer.asynchronexit();
	}
}
