
public abstract class Enemy {
	
	protected int lifePower;
	protected int stepTime;
	protected int pause;
	protected Road road;
	protected boolean isActive;
	protected boolean isDuplicated;
	
	// palyara helyezeskor hivodik meg
	public Enemy() {
		lifePower = 100;
		stepTime = 10;
		pause = 0;
		road = new Road(new Position(-1, -1));
		isActive = false;
		isDuplicated = false;
	}
	// ellenseg lerakasa egy tetszoleges ut-csempere
	public Enemy(Position pos) {
		lifePower = 100;
		stepTime = 10;
		pause = 0;
		road = new Road(pos);
		isActive = true;
		isDuplicated = false;
	}

	
	
	public int getLifePower() {
		return lifePower;
	}



	public void setLifePower(int lifePower) {
		this.lifePower = lifePower;
	}



	public int getStepTime() {
		return stepTime;
	}



	public void setStepTime(int stepTime) {
		this.stepTime = stepTime;
	}



	public int getPause() {
		return pause;
	}



	public void setPause(int pause) {
		this.pause = pause;
	}



	public boolean isActive() {
		return isActive;
	}


	public boolean isDuplicated() {
		return isDuplicated;
	}



	public void setDuplicated(boolean isDuplicated) {
		this.isDuplicated = isDuplicated;
	}



	public Road getRoad() {
		return road;
	}



	/**
	 * A parameterkent kapott poziciora lepteti az ellenseget.
	 * 
	 * @param p A leptetes celpozicioja
	 */
	public void move() {
		road.requestDestination(this);
	}

	/**
	 * A parameterlistan kapott toronytol leolvasott,
	 * erre az ellenseg tipusra vonatkozo sebzes erteket
	 * levonja az aktualis eleterobol.
	 * 
	 * @param t A torony amelyik eppen lo erre az ellensegre
	 */
	public abstract void lifePowerReduce(Tower t);

	/**
	 * Ellenseg forras poticiora helyezese
	 * @param pause A kesleltetes erteke, ami megadja a palyara lepes sorrendjet
	 */
	public void goToSource(int pause){
		int randValue = (int)(Math.random()*1);
		
		//source.requestDestination(this);
	}

	/**
	 * A varakozas ertekenek novelese (palyara helyezeskor vagy lassitaskor fordul elo)
	 * @param slowingFactor Az akadaly lassito tenyezoje
	 */
	public void increasePause(int slowingFactor){
		pause = pause + slowingFactor;
	}		

	/**
	 * Az ellenseget sebzi
	 * @param t - a torony ami sebzi az enemyt
	 * @return - visszaadja a sebzes utani lifePower erteket
	 */
	public int hit(Tower t){
		this.lifePowerReduce(t);
		return this.lifePower;
	}
	
	/**
	 * Az ellenseg aktivitasat allitja (~kirajzolas)
	 * @param a Ha true akkor aktiv lesz, ha false akkor passziv
	 */
	public void setActivity(boolean a) {
		this.isActive = a;
	}
	
	/**
	 * Beallitja az ellenseg poziciojat, amin allnia kell
	 * @param nextroad A kovetkezo ut, ahova lepnie kell 
	 */
	public void setRoad(Road nextRoad) {
		if(nextRoad instanceof Obstacle) {
			Obstacle o = (Obstacle) nextRoad;
			o.slowMe(this);
		} 
		road = nextRoad;
	}
}
