
public class Human extends Enemy{

	public Human(int l, int s, Position p1, Position p2) {
		super(l, s);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void lifePowerReduce(Tower t) {
		// TODO Auto-generated method stub
		lifePower = lifePower - t.getDamagePowerHuman();
	}
}
