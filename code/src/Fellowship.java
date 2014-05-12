import java.util.ArrayList;
import java.util.Observable;

/**
 *  *
 * A szovetseget reprezentalo objektum, aminek celja az ellenseges hullamok nyilvantartasa. 
 * A hullamok ellensegekbol allnak (torpok, hobbitok, tundek es emberek), es a jatek elorehaladtaval egyre novekvo szamu ellenseget tartalmaz.
 * A Fellowship dolga a hullamok es azok szamanak nyilvantartasa, illetve az egyes hullamok kozotti idokozok beosztasa.
 *
 */
public class Fellowship extends Observable {	
	/**
	 * active - aktiv ellensegejet tarolja
	 * passive - passziv ellensegeket tarolja
	 * number - passziv + aktiv ellensegek aktualis szama egyuttesen
	 */
	private ArrayList<FellowshipDraw> observers;
	private ArrayList<Enemy> active;
	private ArrayList<Enemy> passive;
	private int number;
	private boolean kill;     // ellenseg meghal observer
	private boolean numberWrite;   // ellenseg szamanak kiiratasa observer
	EnemyDraw enemyDraw;
	
	public Fellowship() {
		observers = new ArrayList<FellowshipDraw>();
		active = new ArrayList<Enemy>();
		passive = new ArrayList<Enemy>();
		number = 0;
		kill = false;
		numberWrite = false;
		enemyDraw = new EnemyDraw();
	}
	
	public ArrayList<FellowshipDraw> getObservers() {
		return observers;
	}
	
	/**
	 * Megadja az aktiv ellensegek listajat.
	 * @return Az aktiv ellensegek listája
	 */
	public ArrayList<Enemy> getActive() {
		return active;
	}

	public ArrayList<Enemy> getPassive() {
		return passive;
	}
	
	/**
	 * Vissaadja a fennmarado ellensegek szamat (aktiv + passziv)
	 * @return Ellensegek szama (aki meghalt azt nem szamoljuk)
	 */
	public int getNumber(){
		return number;
	}

	public void reduceNumber(int number) {
		this.number -= number;
		setChanged();
		notifyObservers(this, null);
	}
	
	public void increaseNumber(int number) {
		this.number += number;
		numberWrite = true;
		setChanged();
		notifyObservers(this, null);
	}
	
	public void addActive(Enemy enemy) {
		this.active.add(enemy);
		increaseNumber(1);
		this.active.get(active.size()-1).registerObserver(enemyDraw);
	}
	
	public void removeActive(int index) {
		if(this.active.size() > 0) {
			this.active.get(index).removeObserver(enemyDraw);
			this.active.remove(index);
			reduceNumber(1);
		}
	}
	
	public void addPassive(Enemy enemy) {
		this.passive.add(enemy);
		increaseNumber(1);
	}
	
	public void removePassive(int index) {
		if(this.passive.size() > 0) {
			this.passive.remove(index);
			reduceNumber(1);
		}
	}

	/**
	 * Letrehozza az osszes ellenseget es hozzaadja oket a passive listahoz.
	 * Jelenleg tiz passziv ellenseget hoz letre, amelyeknek a tipusa veletlenszerunen sorsolodik ki, egyenletes eloszlassal
	 */
	public void produceAllEnemy(){
		int rand = 0;
		for(int i = 0; i < 10; i++) {
			rand = (int)(Math.random() * 4);
			if(rand == 0) {
				Human human = new Human();
				passive.add(human);
			}
			else if(rand == 1) {
				Hobbit hobbit = new Hobbit();
				passive.add(hobbit);
			}
			else if(rand == 2) {
				Dwarf dwarf = new Dwarf();
				passive.add(dwarf);
			}
			else if(rand == 3) {
				Elf elf = new Elf();
				passive.add(elf);
			}
			increaseNumber(1);
		}
	}
	
	/**
	 * Elinditja a kovetkezo hullamot, ami annyi ellensegbol fog allni amennyit parameterkent kapunk.
	 * @param source Lehetseges forrasok, amelyek kozul az egyikre lerakjuk az ellenseget
	 * 
	 * @param number Ez a szam adja meg, hogy a kovetkezo hullam hany Enemy-bol fog allni
	 */
	public void startWave(int num, ArrayList<Source> source) {
		/**
		 *  ha nincs annyi passziv ellenseg, amennyit palyara akarunk helyezni, akkor csak annyit rakunk le, amennyi rendelkezesre all
		 */
		int j = this.passive.size() > num ? num : this.passive.size();
		for(int i = 0; i < j ; i++){
			/**
			 *  eloszor is hozzadjuk az active listahoz a passive lista legelso ellenseget
			 */
			this.addActive(this.passive.get(0));
			/**
			 *  A mar aktiv ellenseg pause-at beallitjuk ugy, hogy az elso berakott-nak 0, a masodiknak 1 es igy tovabb legyen a pause
			 *  ertekuk. Ez azert lesz kójo, mert igy fokozatosan egymas utan lepnek majd palyara.
			 */
			this.active.get(this.active.size()-1).setPause(i);
			/**
			 * rahelyezzuk valamelyik forrasra az aktiv ellenseget
			 */
			this.active.get(this.active.size()-1).goToSource(source);
			/**
			 *  toroljuk active listahoz hozzaadott ellenseget a passive listabol
			 */
			this.removePassive(0);
		}
	}
	
	/**
	 * Megsemmisiti a parameterkent kapott ellenseget.
	 * 
	 * Felszabaditja az eroforrasokat, torli az aktiv listarol.
	 * 
	 * @param enemy A megsemmisitendo ellenseg referenciaja
	 */
	public void killEnemy(Enemy enemy){
		
		if(enemy instanceof Hobbit){
			enemy = (Hobbit) enemy;
		}
		else if(enemy instanceof Human){
			enemy = (Human) enemy;
		}
		else if(enemy instanceof Elf){
			enemy = (Elf) enemy;
		}
		else if(enemy instanceof Dwarf){
			enemy = (Dwarf) enemy;
		}
		
		for(int i=0; i < this.active.size(); i++){
			if(this.active.get(i).equals(enemy)) {
				System.out.println("[" + active.get(i).getMyId() + ":" + enemy.getClass().getName() + "] has been deleted");
				kill = true;
				setChanged();
				notifyObservers(this, this.active.get(i));
				this.removeActive(i);
			}
		}
	}

	/**
	 * Minden ellenseget lepteti 1-el, aki nincs lassitva.
	 * Aki lassitva van az addig var ameddig le nem jar a lassitas.
	 */
	public void moveAllActiveEnemy(){
		for(int i = 0; i < active.size(); i++) {
			active.get(i).move();
		}
	}
	
	/**
	 * Ha sebzes soran ketteszakadt egy ellenfel, akkor letre kell hoznunk a klonjat, azonos eleterovel es ugyanarra az ut-csempere kell
	 * helyezni, ahol az eredeti is van
	 * @param enemy Sebzes soran kettehasadt ellenseg referenciaja
	 */
	public void addToActiveEnemyList(Enemy enemy) {
		/**
		 *  ha a kettehasitott ellenseg ember volt, akkor egy uj embert hozunk letre
		 */
		if(enemy instanceof Human) {
			Human hu = new Human(enemy.getRoad());
			hu.setLifePower(enemy.getLifePower());
			this.addActive(hu);
		}
		/**
		 *  ha a kettehasitott ellenseg hobbit volt, akkor egy uj hobbitot hozunk letre
		 */
		else if(enemy instanceof Hobbit) {
			Hobbit ho = new Hobbit(enemy.getRoad());
			ho.setLifePower(enemy.getLifePower());
			this.addActive(ho);
		}
		/**
		 *  ha a kettehasitott ellenseg torp volt, akkor egy uj torpot hozunk letre
		 */
		else if(enemy instanceof Dwarf) {
			Dwarf d = new Dwarf(enemy.getRoad());
			d.setLifePower(enemy.getLifePower());
			this.addActive(d);			
		}
		/**
		 *  ha a kettehasitott ellenseg tunde volt, akkor egy uj tundet hozunk letre
		 */
		else if(enemy instanceof Elf) {
			Elf elf = new Elf(enemy.getRoad());
			elf.setLifePower(enemy.getLifePower());
			this.addActive(elf);
		}
	}
	
	public void notifyObservers(Observable observable, Enemy enemy) {
		for(FellowshipDraw ob : observers) {
			if(numberWrite == true) {
				ob.update(observable, this.number);
				numberWrite = false;
			}
			else if(kill == true) {
				ob.update(observable, enemy);
				kill = false;
			}
		}
	}
	
	/**
	 * Beregisztrálunk egy observert erre az osztályra
	 * @param observer
	 */
	public void registerObserver(FellowshipDraw draw) {
		observers.add(draw);
	}
	/**
	 * Töröljük az adott observer-t a listából: már nem kell értesülnie a model állapot változásairól
	 * @param observer
	 */
	public void removeObserver(FellowshipDraw draw) {
		observers.remove(draw);
	}
}
