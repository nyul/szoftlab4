
public abstract class Enemy {
	private int lifePower;
	private int stepTime;
	
	private Position currentPos;
	private boolean isActive;
	private boolean isSlowed;
	

	/**
	 * A paraméterként kapott pozícióra lépteti az ellenséget.
	 * 
	 * @param p A léptetés célpozíciója
	 */

	public void move(Position p) {
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
	

	public int getLifePower(){
		Writer.entry();
		Writer.synchronexit();
		return this.lifePower;	
	}

	
	public void setLifePower(int newLifePower){
		Writer.entry();
		Writer.asynchronexit();		
	}
	

	public int getStepTime(){
		Writer.entry();
		Writer.synchronexit();
		return this.stepTime;		
	}
	
	
	public void setStepTime(int newStepTime){
		Writer.entry();
		Writer.asynchronexit();
	}
	
	
	public Position getCurrentPos(){
		Writer.entry();
		Writer.synchronexit();
		return this.currentPos;
	}


	public void setCurrentPos(Position newPos){
		Writer.entry();
		Writer.asynchronexit();
	}


	public boolean getIsActive(){
		Writer.entry();
		Writer.synchronexit();
		return this.isActive;
	}


	public void setIsActive(boolean activity){
		Writer.entry();
		Writer.asynchronexit();
	}

	
	public boolean getIsSlowed() {
		Writer.entry();
		Writer.synchronexit();
		return isSlowed;
	}
	
	
	public void setIsSlowed(boolean isSlowed){
		Writer.entry();
		Writer.asynchronexit();
	}	


}
