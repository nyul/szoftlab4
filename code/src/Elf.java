
public class Elf extends Enemy{

	public Elf() {
		super();
	}
	
	public Elf(Position pos) {
		super(pos);
	}
	
	@Override
	public void lifePowerReduce(Tower t) {
		this.lifePower = this.lifePower - t.getDamagePowerElf();
	}
}
