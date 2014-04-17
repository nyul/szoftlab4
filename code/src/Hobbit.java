
public class Hobbit extends Enemy{

	public Hobbit() {
		super();
	}
	
	public Hobbit(Position pos) {
		super(pos);
	}
	
	@Override
	public void lifePowerReduce(Tower t) {
		this.lifePower = this.lifePower - t.getDamagePowerHobbit();
	}
}
