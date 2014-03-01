import java.util.ArrayList;


public class Wave {
	private ArrayList<Enemy> passive;
	private ArrayList<Enemy> active;
	private int number;
	
	public Wave(int n) {
		passive = new ArrayList<Enemy>();
		active = new ArrayList<Enemy>();
		number = n;
	}
	
	public void addPassiveEnemy(Enemy e) {
		if(isAddPassiveEnemy()) {
			passive.add(e);
			number++;
		}
	}
	
	public boolean isAddPassiveEnemy() {
		if(passive.size() <= number) return true;
		else return false;
	}
	
	public void removePassiveEnemy(Enemy e) {
		passive.remove(e);
		number--;
	}
	
	public void addActiveEnemy(Enemy e) {
		if(e.isActive) {
			removePassiveEnemy(e);
			active.add(e);
		}
	}
	
	public void removeActiveEnemy(Enemy e) {
		active.remove(e);
	}
	
	public int getNumber() {
		return number;
	}
}
