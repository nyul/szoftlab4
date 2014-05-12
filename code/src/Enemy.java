import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *Ez egy absztrakt osztaly, ami arra jo, hogy tarolja az ellenseg allapotait illetve megszabja a viselkedesuket, ami minden egyes
 *ellenseg tipusra igaz. 
 */
public abstract class Enemy extends Observable {
	/**
	 * id - osztalyszintu valtozo, amely 1-el novelodik minden egyes enemy letrehozaskor
	 * myId - ellenseg azonositoja
	 * lifePower - ellenseg eleterejet tarolja
	 * stepTime - ellenseg haladasanak sebesseget tarolja
	 * pause - tarolja, hogy egy ellenseg hany lepesbol marad ki
	 * road - tarolja azt az ut-csempet, amelyiken all
	 * isActive - ellenseg aktivitasat vizsgalja, ha egy ellenseg passziv, akkor addig nem helyezheto a palyara, csak az aktiv
	 * 			  ellensegeket lehet leptetni
	 * isDuplicated - alapesetben false az erteke, true abban az esetben, ha az ellenseget a torony sebzese soran kettehasitotta
	 * counter - 1-tol stepTime-ig novelodik az erteke, ha eleri a stepTime erteket, akkor lep az ellenseg
	 */
	private ArrayList<EnemyDraw> observers;
	public static int id = 0;  // azonosito generalashoz kell
	protected int myId;  // azonosito  
	protected int lifePower;
	protected int stepTime;   
	protected int pause; 
	protected Road road;
	protected Road previousRoad;
	protected boolean isActive;
	protected boolean isDuplicated;
	protected int counter;
	
	/**
	 *  palyara helyezeskor hivodik meg
	 */
	public Enemy() {
		observers = new ArrayList<EnemyDraw>();
		myId = id;
		id++;
		lifePower = 100;
		stepTime = 10;
		pause = 0;
		road = new Road(new Position(-1, -1));  // meg nincs palyara helyezve (virtualis pozicio)
		previousRoad = null;
		isActive = false;
		isDuplicated = false;
		counter = 1;
	}
	/**
	 *  ellenseg lerakasa egy tetszoleges ut-csempere
	 * @param pos
	 */
	public Enemy(Road r) {
		observers = new ArrayList<EnemyDraw>();
		myId = id;
		id++;
		lifePower = 100;
		stepTime = 10;
		pause = 0;
		road = r;
		previousRoad = null;
		isActive = true;
		isDuplicated = false;
		counter = 1;
	}

	public ArrayList<EnemyDraw> getObservers() {
		return observers;
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
	
	/**
	 * Az ellenseg aktivitasat allitja (~kirajzolas)
	 * @param a Ha true akkor aktiv lesz, ha false akkor passziv
	 */
	public void setActivity(boolean a) {
		if(a == false) notifyObservers(this);
		this.isActive = a;
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
	 * Ez mar a konkret leptetes a kovetkezo ut-csempere. Ha az ellenseg elott all valaki, akkor is tud lepni, ugyanis semmilyen 
	 * megkotes nincs arra, hogy hany ellenseg allhat egy adott ut-csempen.
	 * @param nextroad A kovetkezo ut-csempe, ahova lepnie kell 
	 */
	public void setRoad(Road nextRoad) {
		/**
		 *  ha a kovetkezo ut-csempe egy akadaly-csempe, akkor az ellenseget le kell lassitani, amit a slowMe metodus hajt vegre
		 */
		if(nextRoad instanceof Obstacle) {
			Obstacle o = (Obstacle) nextRoad;
			o.slowMe(this);
		} 
		previousRoad = road;
		road = nextRoad;
		setChanged();
		notifyObservers(this);
	}
	
	public Road getPreviousRoad() {
		return previousRoad;
	}

	/**
	 * Az ellenseget lepteteset kezdemenyezi, ugy hogy meghivja annak a road-nak a requestDestination metodusat, amelyiken eppen all. 
	 */
	public void move() {
		/**
		 *  counter minden tick-ben novelodik 1-el, ha eleri a stepTime-t, akkor leptetjuk az ellenseget
		 */
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
	public void goToSource(ArrayList<Source> source) {
		/**
		 * forrasok szamatol fuggoen visszaad egy szamot, ha a randomgenerator be van kapcsolva [0;forrasok szama-1]
		 * ha randomgenerator ki van kapcsolva, azaz random = false, akkor mindig a forras lista 0-dik elemere teszzük ra az ellenseget
		 */
		int randValue = (int)(Math.random()*source.size());
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
		Writer.writeText.add("[" + t.getMyId() + ":" + t.getClass().getName() + "] has shot [" + this.getMyId() + ":" + this.getClass().getName() + "]");
		return this.lifePower;
	}
	
	public void notifyObservers(Observable observable) {
		for(Observer ob : observers) {
			ob.update(observable, this.road);
		}
	}
	
	/**
	 * Beregisztrálunk egy observert erre az osztályra
	 * @param observer
	 */
	public void registerObserver(EnemyDraw draw) {
		observers.add(draw);
	}
	/**
	 * Töröljük az adott observer-t a listából: már nem kell értesülnie a model állapot változásairól
	 * @param observer
	 */
	public void removeObserver(EnemyDraw draw) {
		observers.remove(draw);
	}
}
