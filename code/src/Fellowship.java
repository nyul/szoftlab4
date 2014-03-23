import java.util.ArrayList;

/**
 *  *
 * A sz�vets�get reprezent�l� objektum, aminek c�lja az ellens�ges hull�mok nyilv�ntart�sa. 
 * A hull�mok ellens�gekb�l �llnak (t�rp�k, hobbitok, stb.), �s a j�t�k el�rehaladt�val egyre n�vekv� sz�m� ellens�get tartalmaz.
 * A Fellowship dolga a hull�mok �s azok sz�m�nak nyilv�ntart�s��rt, illetve az egyes hull�mok k�z�tti id��rt is.
 *
 */
public class Fellowship {	
	
	ArrayList<Enemy> passive;
	ArrayList<Enemy> active;
	private int number;
	
	
	public Fellowship() {
		passive = new ArrayList<Enemy>();
		active = new ArrayList<Enemy>();
		this.number = 0;
	}

	/**
	 * L�trehozza az �sszes ellens�get �s hozz�adja �ket a passive list�hoz.
	 */
	public void produceAllEnemy(){
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Elind�tja a k�vetkez� hull�mot, ami annyi ellens�gb�l fog �llni amennyit param�terk�nt kapunk.
	 * 
	 * @param number Ez a sz�m adja meg, hogy a k�vetkez� hull�m h�ny Enemy-b�l fog �llni
	 */
	public void startWave(int number){
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Visszat�r az �sszes m�g �l� ellens�g sz�m�val (akt�v + passz�v)
	 * @return fennmarad� ellens�gek sz�ma (aki m�r meghalt az nincs benne)
	 */
	public int getNumber(){
		Writer.entry();
		Writer.synchronexit();
		return number;
	}
	
	/**
	 * Megsemmis�ti a param�terk�nt kapott ellens�get.
	 * 
	 * Felszabad�tja az er�forr�sokat, t�rli az akt�v list�r�l.
	 * 
	 * @param enemy A megsemmis�tend� ellens�g referenci�ja
	 */
	public void killEnemy(Enemy enemy){
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Megadja az akt�v ellens�gek list�j�t.
	 * @return Az akt�v ellens�gek list�ja
	 */
	public ArrayList<Enemy> getActiveEnemies(){
		Writer.entry();
		Writer.synchronexit();
		return active;
	}

	/**
	 * Minden ellens�get l�pteti egyel aki nincs lass�tva.
	 * Aki lass�tva van az addig v�r ameddig le nem j�r a lass�t�s.
	 */
	public void moveAllActiveEnemy(){
		Writer.entry();
		Writer.asynchronexit();
	}	

}
