
public class Elf extends Enemy{

	public Elf(int l, int s, Position p1, Position p2) {
		super(l, s);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void lifePowerReduce(Tower t) {
		Writer.entry();	
		Writer.asynchronexit();
	}
}
