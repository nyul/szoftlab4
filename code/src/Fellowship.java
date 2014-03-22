import java.util.ArrayList;


public class Fellowship {	
	
	ArrayList<Enemy> passive;
	ArrayList<Enemy> active;
	private int number;
	
	
	public Fellowship() {
		
	}

	public void produceAllEnemy(){
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public void startWave(int number){
		
	}
	
	public int getNumber(){
		return number;
	}
	
	public void killEnemy(Enemy enemy){
		
	}
	
	public ArrayList<Enemy> getActiveEnemies(){
		return active;
	}

	public ArrayList<Enemy> moveAllActiveEnemy(){
		return active;
	}	

}
