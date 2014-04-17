
public class Human extends Enemy{

	public Human() {
		super();
	}
	
	public Human(Position pos) {
		super(pos);
	}
	
	@Override
	public void lifePowerReduce(Tower t) {
		Writer.entry();	
		Writer.asynchronexit();
	}
}
