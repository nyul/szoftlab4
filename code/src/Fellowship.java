import java.util.ArrayList;

/**
 *  *
 * A szovetseget reprezentalo objektum, aminek celja az ellenseges hullamok nyilvantartasa. 
 * A hullamok ellensegekbol allnak (torpok, hobbitok, stb.), es a jatek elorehaladtaval egyre novekvo szamu ellenseget tartalmaz.
 * A Fellowship dolga a hullamok es azok szamanak nyilvantartasaert, illetve az egyes hullamok kozotti idoert is.
 *
 */
public class Fellowship {	
	
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
	 * @param source 
	 * 
	 * @param number Ez a szam adja meg, hogy a kovetkezo hullam hany Enemy-bol fog allni
	 */
	public void startWave(int num, ArrayList<Source> source){ // atirtam num-ra number helyett, mert az osztalynak is van egy number valtozoja
		int j = this.passive.size() > num ? num : this.passive.size();
		for(int i = 0; i < j ; i++){
			this.active.add(this.passive.get(0));
			this.active.get(this.active.size()-1).setPause(i);
			this.active.get(this.active.size()-1).goToSource(source);
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
		for(Enemy e: this.active){
			if (e.equals(enemy)){
				this.active.remove(e);
				this.number--;
			}
		}
	}
	
	/**
	 * Megadja az aktiv ellensegek listajat.
	 * @return Az aktiv ellensegek list�ja
	 */
	public ArrayList<Enemy> getActiveEnemies(){
		return active;
	}

	/**
	 * Minden ellenseget lepteti egyel aki nincs lassitva.
	 * Aki lassitva van az addig var ameddig le nem jar a lassitas.
	 */
	public void moveAllActiveEnemy(){
		for(int i = 0; i < active.size(); i++) {
			active.get(i).move();
		}
	}
	
	/**
	 * Vissaadja a fennmarado ellensegek szamat (aktiv + passziv)
	 * @return Ellensegek szama (aki meghalt azt nem szamoljuk)
	 */
	public int getNumber(){
		return number;
	}
	
	public void addToActiveEnemyList(Enemy enemy) {
		if(enemy instanceof Human) {
			Human h = new Human(enemy.getRoad().getPos());
			h.setLifePower(enemy.getLifePower());
		}
		else if(enemy instanceof Hobbit) {
			Hobbit h = new Hobbit(enemy.getRoad().getPos());
			h.setLifePower(enemy.getLifePower());
		}
		else if(enemy instanceof Dwarf) {
			Dwarf d = new Dwarf(enemy.getRoad().getPos());
			d.setLifePower(enemy.getLifePower());
		}
		else if(enemy instanceof Elf) {
			Elf elf = new Elf(enemy.getRoad().getPos());
			elf.setLifePower(enemy.getLifePower());
		}
	}

}
