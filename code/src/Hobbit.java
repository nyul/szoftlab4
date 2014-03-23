
public class Hobbit extends Enemy{

	public Hobbit(int l, int s, Position p1, Position p2) {
		super(l, s);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void lifePowerReduce(Tower t) {
		Writer.entry();	
		Writer.asynchronexit();
	}
}
