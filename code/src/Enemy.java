
public abstract class Enemy {

	Source source;
	Road road;
	Obstacle obstacle;
	
	public Enemy() {
		source = null;
		road = null;
		obstacle = null;
	}
	
	public void createObject() {
		source = new Source();
		road = new Road();
		obstacle = new Obstacle();
	}

	public void move() {
		Writer.entry();	
		road.requestDestination(this);
		Writer.asynchronexit();
	}
	


	/**
	 * A param�terlist�n kapott toronyt�l leolvasott,
	 * erre az ellens�g t�pusra vonatkoz� sebz�s �rt�ket
	 * levonja az aktu�lis �leter�b�l.
	 * 
	 * @param t A torony amelyik �ppen l� erre az ellens�gre
	 */
	
	public abstract void lifePowerReduce(Tower t);

	public void goToSource(int pause){
		Writer.entry();
		source.requestDestination(this);
		Writer.asynchronexit();
	}


	public void increasePause(int slowingFactor){
		Writer.entry();
		Writer.asynchronexit();
	}		


	public int hit(Tower t){
		Writer.entry();
		Writer.synchronexit();
		return 0;
	}
	
	public void setActivity(boolean a) {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public void setRoad(Road r) {
		Writer.entry();
		if(Writer.kerdes("Kovetkezo ut-csempe akadaly-e?")) {
			obstacle.slowMe(this);
		}
		Writer.asynchronexit();
	}

}
