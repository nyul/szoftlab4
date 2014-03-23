import java.util.ArrayList;

/**
 * A szovetseget reprezentalo objektum, aminek celja az ellenseges hullamok nyilvantartasa. 
 * A hullamok ellensegekbol allnak (torpok, hobbitok, stb.), es a jatek elorehaladtaval egyre novekvo szamu ellenseget tartalmaz.
 * A Fellowship dolga a hullamok es azok szamanak nyilvantartasaert, illetve az egyes hullamok kozotti idoert is.
 *
 */
public class Fellowship {	
	
	ArrayList<Enemy> active;
	Enemy enemy;
	
	public Fellowship() {
		active = null;
		enemy = null;
	}
	
	public void createObject() {
		active = new ArrayList<Enemy>();
		enemy = new Human();
	}
	

	/**
	 * Letrehozza az osszes ellenseget és hozzaadja oket a passive listahoz.
	 */
	public void produceAllEnemy(){
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Elinditja a kovetkezo hullamot, ami annyi ellensegbol fog allni amennyit parameterkent kapunk.
	 * 
	 * @param number Ez a szam adja meg, hogy a kovetkezo hullam hány Enemy-bol fog allni
	 */
	public void startWave(int number){
		Writer.entry();
		enemy.goToSource(0);
		Writer.asynchronexit();
	}
	
	/**
	 * Megsemmisiti a parameterkent kapott ellenseget.
	 * 
	 * Felszabaditja az eroforrasokat, torli az aktiv listarol.
	 * 
	 * @param enemy A megsemmisitendo ellenseg referenciaja
	 */
	public void killEnemy(Enemy enemy){
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Megadja az aktiv ellensegek listajat.
	 * @return Az aktiv ellensegek listaja
	 */
	public ArrayList<Enemy> getActiveEnemies(){
		Writer.entry();
		Writer.synchronexit();
		return active;
	}

	/**
	 * Minden ellenseget lepteti egyel aki nincs lassitva.
	 * Aki lassitva van az addig var ameddig le nem jar a lassitas.
	 */
	public void moveAllActiveEnemy(){
		Writer.entry();
		enemy.move();
		Writer.asynchronexit();
	}	

}
