
public class Hobbit extends Enemy{

	public Hobbit() {
		super();
	}
	
	public Hobbit(Position pos) {
		super(pos);
	}
	
	@Override
	public void lifePowerReduce(Tower t) {
		Writer.entry();	
		Writer.asynchronexit();
	}
}
