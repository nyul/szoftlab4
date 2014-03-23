
public abstract class Enemy {
	private int lifePower;
	private int stepTime;
	
	private Position currentPos;
	private boolean isActive;
	private boolean isSlowed;
	

	/**
	 * A param�terk�nt kapott poz�ci�ra l�pteti az ellens�get.
	 * 
	 * @param p A l�ptet�s c�lpoz�ci�ja
	 */

	public void move(Position p) {
		Writer.entry();	
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
