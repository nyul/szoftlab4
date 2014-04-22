import java.util.ArrayList;

/**
 *Ez egy absztrakt osztaly, ami arra jo, hogy tarolja az ellenseg allapotait illetve megszabja a viselkedesuket, ami minden egyes
 *ellenseg tipusra igaz. 
 */
public abstract class Enemy {
	/**
	 * lifePower - ellenseg eleterejet tarolja
	 * stepTime - ellenseg haladasanak sebesseget tarolja
	 * pause - tarolja, hogy egy ellenseg hany lepesbol marad ki
	 * road - tarolja azt az ut-csempet, amelyiken all
	 * isActive - ellenseg aktivitasat vizsgalja, ha egy ellenseg passziv, akkor addig nem helyezheto a palyara, csak az aktiv
	 * 			  ellensegeket lehet leptetni
	 * isDuplicated - alapesetben false az erteke, true abban az esetben, ha az ellenseget a torony sebzese soran kettehasitotta
	 */
	private static int id = 0;
	private int myId;
	protected int lifePower;
	protected int stepTime;
	protected int pause;
	protected Road road;
	protected boolean isActive;
	protected boolean isDuplicated;
	protected int counter;
	protected boolean random = false;
	
	/**
	 *  palyara helyezeskor hivodik meg
	 */
	public Enemy() {
		myId = id;
		id++;
		lifePower = 100;
		stepTime = 10;
		pause = 0;
		road = new Road(new Position(-1, -1));  // meg nincs palyara helyezve (virtualis pozicio)
		isActive = false;
		isDuplicated = false;
		counter = 1;
	}
	/**
	 *  ellenseg lerakasa egy tetszoleges ut-csempere
	 * @param pos
	 */
	public Enemy(Road r) {
		myId = id;
		id++;
		lifePower = 100;
		stepTime = 10;
		pause = 0;
		road = r;
		isActive = true;
		isDuplicated = false;
		counter = 1;
	}

	
	public int getMyId() {
		return myId;
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
	 * Az ellenseget lepteteset kezdemenyezi, ugy hogy meghivja annak a road-nak a requestDestination metodusat, amelyiken eppen all. 
	 */
	public void move() {
		if(counter >= stepTime) {
			if(pause == 0) {
				road.requestDestination(this);
			} else {
				pause--;
			}
			counter = 1;
		} else {
			counter = counter + 1;
		}
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
	 * @param source - tobb forras kozul valamelyiket veletlenszeruen kisorsoljuk es erre helyezzuk ra az ellenseget
	 */
	public void goToSource(ArrayList<Source> source){
		int randValue = random == true ? (int)(Math.random()*source.size()) : 0;   // forrasok szamatol fuggoen visszaad egy szamot, [0;forrasok szama-1]
		source.get(randValue).requestDestination(this);
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
	public int hit(Tower t) {
		this.lifePowerReduce(t);
		System.out.println("[" + t.getMyId() + ":" + t.getClass().getName() + "] has shot [" + this.getMyId() + ":" + this.getClass().getName() + "]");
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
	 * Ez mar a konkret leptetes a kovetkezo ut-csempere. Ha az ellenseg elott all valaki, akkor is tud lepni, ugyanis semmilyen 
	 * megkotes nincs arra, hogy hany ellenseg allhat egy adott ut-csempen.
	 * @param nextroad A kovetkezo ut-csempe, ahova lepnie kell 
	 */
	public void setRoad(Road nextRoad) {
		// ha a kovetkezo ut-csempe egy akadaly-csempe, akkor az ellenseget le kell lassitani, amit a slowMe metodus hajt vegre
		if(nextRoad instanceof Obstacle) {
			Obstacle o = (Obstacle) nextRoad;
			o.slowMe(this);
		} 
		road = nextRoad;
	}
}
