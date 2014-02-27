
public class Enemy {
	protected int lifePower;
	protected int stepTime;
	protected int counter;
	protected Position currentPos;
	protected Position nextPos;
	protected boolean isActive;
	protected boolean isSlowed;
	
	public Enemy(int l, int s, Position p1, Position p2) {
		lifePower = l;
		stepTime = s;
		currentPos = p1;
		nextPos = p2;
		isActive = false;
		stepTime = 10;
		counter = 0;
	}
	
	public void move() {
		if(counter >= stepTime) {
			// lepes
			System.out.println("Enemy lep egyet elore.");
			counter = 0;
		}
		else {
			counter = counter + 1;
		}
		
	}
	
	public void lifePowerReduce() {
		
	}
	
	/*public boolean stepCheck() {
		
	}
	
	public boolean getIsSlowed() {
		
	}*/
	
	public void kill() {
		
	}
}
