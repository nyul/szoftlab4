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
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Elinditja a kovetkezo hullamot, ami annyi ellensegbol fog allni amennyit parameterkent kapunk.
	 * 
	 * @param number Ez a szam adja meg, hogy a kovetkezo hullam hany Enemy-bol fog allni
	 */
	public void startWave(int num){ // atirtam num-ra number helyett, mert az osztalynak is van egy number valtozoja
		int j = this.passive.size() > num ? num : this.passive.size();
		for(int i = 0; i < j ; i++){
			this.active.add(this.passive.get(0));
			this.active.get(this.active.size()-1).setPause(i);
			this.active.get(this.active.size()-1).goToSource(i);
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
	 * @return Az aktiv ellensegek listája
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

}
