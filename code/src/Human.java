
public class Human extends Enemy{

	public Human() {
		super();
	}
	
	public Human(Position pos) {
		super(pos);
	}
	
	@Override
	public void lifePowerReduce(Tower t) {
		this.lifePower = this.lifePower - t.getDamagePowerHuman();
	}
}
