
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
		Enemy enemy = null;
		for(int i = 0; i < player.getArea().getTower().size(); i++) {
			enemy = player.getArea().getTower().get(i).attack(fellowship.getActiveEnemies(), player.getArea().getGeometry());
			if(enemy.isActive() == false) {
				fellowship.killEnemy(enemy);
			}
			if(enemy.isDuplicated() == true) {
				fellowship.addToActiveEnemyList(enemy);
				enemy.setDuplicated(false);
			}
		}
	}
	
	public void stepHandler() {
		fellowship.moveAllActiveEnemy();
	}
	
	public void takeToArea() {
		fellowship.startWave(5,player.getArea().getSource());
	}
	
	public void run() {
		stepHandler();
		attackHandler();
		if(fellowship.getNumber() == 0) victory();
		player.getArea().isOnMountain(this);
		try {
			Thread.sleep(100);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void defeat() {
		fellowship.getActive().clear();
		fellowship.getPassive().clear();
		player.getArea().getObstacle().clear();
		player.getArea().getRoad().clear();
		player.getArea().getSource().clear();
		player.getArea().getTower().clear();
		System.out.println("Defeat! :(");
	}
	
	public void victory() {
		fellowship.getActive().clear();
		fellowship.getPassive().clear();
		player.getArea().getObstacle().clear();
		player.getArea().getRoad().clear();
		player.getArea().getSource().clear();
		player.getArea().getTower().clear();
		System.out.println("Victory! :)");
	}
}
