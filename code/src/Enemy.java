
public abstract class Enemy {
	
	Road road;

	/**
	 * A paraméterként kapott poziciora lepteti az ellenseget.
	 * 
	 * @param p A leptetes celpozicioja
	 */
	public void move() {
		Writer.entry();	
		Writer.asynchronexit();
	}

	/**
	 * A parameterlistan kapott toronytol leolvasott,
	 * erre az ellenseg tipusra vonatkozo sebzes erteket
	 * levonja az aktualis eleterobol.
	 * 
	 * @param t A torony amelyik eppen lo erre az ellensegre
	 */
	public abstract void lifePowerReduce(Tower t);

	public void goToSource(int pause){
		Writer.entry();
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
	
	public void setRoad(Road nextroad) {
		Writer.entry();
		Writer.asynchronexit();
	}

}
