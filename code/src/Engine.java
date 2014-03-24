
public class Engine extends Thread{
 	
	Player player;
	Fellowship fellowship;
	Tower tower;
	Enemy enemy;
	
	
	public Engine() {
		player = null;
		fellowship = null;
		tower = null;	
		enemy = null;
	}
	
	public void createObject() {
		player = new Player();
		fellowship = new Fellowship();
		tower = new Tower();
		enemy = new Human();
	}
	
	public void attackHandler() {
		Writer.entry();
		enemy = tower.attack(fellowship.getActiveEnemies());
		if(!Writer.kerdes("Megsebzett enemy aktiv-e?")) {
			fellowship.killEnemy(enemy);
		}
		Writer.asynchronexit();
	}
	
	public void stepHandler() {
		Writer.entry();
		fellowship.moveAllActiveEnemy();
		Writer.asynchronexit();
	}
	
	public void takeToArea() {
		Writer.entry();
		fellowship.startWave(0);
		Writer.asynchronexit();
	}
	
	public void run() {
		Writer.entry();
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
