import java.util.ArrayList;


public class Fellowship {	
	
	ArrayList<Enemy> passive;
	ArrayList<Enemy> active;
	private int number;
	
	
	public Fellowship(int number) {
		passive = new ArrayList<Enemy>();
		active = new ArrayList<Enemy>();
		this.number = number;
	}

	public void produceAllEnemy(){
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public void startWave(int number){
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public int getNumber(){
		Writer.entry();
		Writer.synchronexit();
		return number;
	}
	
	public void killEnemy(Enemy enemy){
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public ArrayList<Enemy> getActiveEnemies(){
		Writer.entry();
		Writer.synchronexit();
		return active;
	}

	public ArrayList<Enemy> moveAllActiveEnemy(){
		Writer.entry();
		Writer.synchronexit();
		return active;
	}	

}
