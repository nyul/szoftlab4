
public abstract class Enemy {

	/**
	 * A paraméterként kapott pozícióra lépteti az ellenséget.
	 * 
	 * @param p A léptetés célpozíciója
	 */

	public void move() {
		Writer.entry();	
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

}
