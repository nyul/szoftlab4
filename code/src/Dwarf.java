
public class Dwarf extends Enemy{

	public Dwarf() {
		super();
	}
	
	public Dwarf(Position pos) {
		super(pos);
	}
	
	@Override
	public void lifePowerReduce(Tower t) {
		this.lifePower = this.lifePower - t.getDamagePowerDwarf();
	}
}
