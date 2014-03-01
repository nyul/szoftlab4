
public abstract class Enemy {
	protected int lifePower;
	protected int stepTime;
	protected int counter;
	protected Position currentPos;
	protected boolean isActive;
	protected boolean isSlowed;
	
	public Enemy(int l, int stepT) { // start = 0, akkor 0.source, start = 1, akkor 1.source
		lifePower = l;
		stepTime = stepT;
		isActive = false;
		stepTime = 10;
		counter = 0;
	}
	
	// ellenseg forrasra helyezese
	public void firstStep(Position p) {
		if(isActive == false) {
			isActive = true;
			currentPos = p;
		}
		else System.out.println("Mar a palyan van az ellenseg.");
	}
	
	public void move(Position p) {
		if(counter >= stepTime) {
			currentPos = p;
			System.out.println("Enemy lep egyet elore.");
			counter = 0;
		}
		else {
			counter = counter + 1;
		}
		
	}
	
	public abstract void lifePowerReduce(Tower t);
	
	public boolean getIsSlowed() {
		return isSlowed;
	}
}
