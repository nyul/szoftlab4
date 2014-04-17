
public class Elf extends Enemy{

	public Elf() {
		super();
	}
	
	public Elf(Position pos) {
		super(pos);
	}
	
	@Override
	public void lifePowerReduce(Tower t) {
		Writer.entry();	
		Writer.asynchronexit();
	}
}
