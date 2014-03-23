
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
	 * A paraméterlistán kapott toronytól leolvasott,
	 * erre az ellenség típusra vonatkozó sebzés értéket
	 * levonja az aktuális életerõbõl.
	 * 
	 * @param t A torony amelyik éppen lö erre az ellenségre
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
