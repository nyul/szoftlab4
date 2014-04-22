import java.util.ArrayList;

/**
 *  *
 * A szovetseget reprezentalo objektum, aminek celja az ellenseges hullamok nyilvantartasa. 
 * A hullamok ellensegekbol allnak (torpok, hobbitok, tundek es emberek), es a jatek elorehaladtaval egyre novekvo szamu ellenseget tartalmaz.
 * A Fellowship dolga a hullamok es azok szamanak nyilvantartasa, illetve az egyes hullamok kozotti idokozok beosztasa.
 *
 */
public class Fellowship {	
	/**
	 * active - aktiv ellensegejet tarolja
	 * passive - passziv ellensegeket tarolja
	 * number - passziv + aktiv ellensegek aktualis szama egyuttesen
	 */
	private ArrayList<Enemy> active;
	private ArrayList<Enemy> passive;
	private int number;
	
	public Fellowship() {
		active = new ArrayList<Enemy>();
		passive = new ArrayList<Enemy>();
		number = 0;
	}
	
	public ArrayList<Enemy> getActive() {
		return active;
	}

	public void setActive(ArrayList<Enemy> active) {
		this.active = active;
	}

	public ArrayList<Enemy> getPassive() {
		return passive;
	}

	public void setPassive(ArrayList<Enemy> passive) {
		this.passive = passive;
	}

	public void setNumber(int number) {
		this.number = number;
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
			number++;
		}
	}
	
	/**
	 * Elinditja a kovetkezo hullamot, ami annyi ellensegbol fog allni amennyit parameterkent kapunk.
	 * @param source Lehetseges forrasok, amelyek kozul az egyikre lerakjuk az ellenseget
	 * 
	 * @param number Ez a szam adja meg, hogy a kovetkezo hullam hany Enemy-bol fog allni
	 */
	public void startWave(int num, ArrayList<Source> source) {
		// ha nincs annyi passziv ellenseg, amennyit palyara akarunk helyezni, akkor csak annyit rakunk le, amennyi rendelkezesre all
		int j = this.passive.size() > num ? num : this.passive.size();
		for(int i = 0; i < j ; i++){
			// eloszor is hozzadjuk az active listahoz a passive lista legelso ellenseget
			this.active.add(this.passive.get(0));
			// A mar aktiv ellenseg pause-at beallitjuk ugy, hogy az elso berakott-nak 0, a masodiknak 1 es igy tovabb legyen a pause
			// ertekuk. Ez azert lesz kójo, mert igy fokozatosan egymas utan lepnek majd palyara.
			this.active.get(this.active.size()-1).setPause(i);
			// rahelyezzuk valamelyik forrasra az aktiv ellenseget
			this.active.get(this.active.size()-1).goToSource(source);
			// toroljuk active listahoz hozzaadott ellenseget a passive listabol
			this.passive.remove(0);
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
			if(this.active.get(i).equals(enemy)){
				System.out.println("[" + enemy.getId() + ":" + enemy.getClass().getName() + "] has been deleted");
				this.active.remove(i);				
				this.number--;
			}
		}
		
		/*
		for(Enemy e: this.active){
			if (e.equals(enemy)){
				this.active.remove(e);
				// 1-el csokkent az ellensegek szama
				this.number--;
			}
		}
		*/
	}
	
	/**
	 * Megadja az aktiv ellensegek listajat.
	 * @return Az aktiv ellensegek listája
	 */
	public ArrayList<Enemy> getActiveEnemies(){
		return active;
	}

	/**
	 * Minden ellenseget lepteti 1-el, aki nincs lassitva.
	 * Aki lassitva van az addig var ameddig le nem jar a lassitas.
	 */
	public void moveAllActiveEnemy(){
		for(int i = 0; i < active.size(); i++) {
			active.get(i).move();
			System.out.println("["+active.get(i).getId() + ":" + active.get(i).getClass() + "] has moved to Road(" + active.get(i).getRoad().getPos().getX() + "," +active.get(i).getRoad().getPos().getY() + ")" );
		}
	}
	
	/**
	 * Vissaadja a fennmarado ellensegek szamat (aktiv + passziv)
	 * @return Ellensegek szama (aki meghalt azt nem szamoljuk)
	 */
	public int getNumber(){
		return number;
	}
	/**
	 * Ha sebzes soran ketteszakadt egy ellenfel, akkor letre kell hoznunk a klonjat, azonos eleterovel es ugyanarra az ut-csempere kell
	 * helyezni, ahol az eredeti is van
	 * @param enemy Sebzes soran kettehasadt ellenseg referenciaja
	 */
	public void addToActiveEnemyList(Enemy enemy) {
		// ha a kettehasitott ellenseg ember volt, akkor egy uj embert hozunk letre
		/*if(enemy instanceof Human) {
			Human h = new Human(enemy.getRoad().getPos());
			h.setLifePower(enemy.getLifePower());
		}
		// ha a kettehasitott ellenseg hobbit volt, akkor egy uj hobbitot hozunk letre
		else if(enemy instanceof Hobbit) {
			Hobbit h = new Hobbit(enemy.getRoad().getPos());
			h.setLifePower(enemy.getLifePower());
		}
		// ha a kettehasitott ellenseg torp volt, akkor egy uj torpot hozunk letre
		else if(enemy instanceof Dwarf) {
			Dwarf d = new Dwarf(enemy.getRoad().getPos());
			d.setLifePower(enemy.getLifePower());
		}
		// ha a kettehasitott ellenseg tunde volt, akkor egy uj tundet hozunk letre
		else if(enemy instanceof Elf) {
			Elf elf = new Elf(enemy.getRoad().getPos());
			elf.setLifePower(enemy.getLifePower());
		}*/
	}

}
