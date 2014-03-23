import java.util.ArrayList;

/**
 *  *
 * A szövetséget reprezentáló objektum, aminek célja az ellenséges hullámok nyilvántartása. 
 * A hullámok ellenségekbõl állnak (törpök, hobbitok, stb.), és a játék elõrehaladtával egyre növekvõ számú ellenséget tartalmaz.
 * A Fellowship dolga a hullámok és azok számának nyilvántartásáért, illetve az egyes hullámok közötti idõért is.
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
	 * Létrehozza az összes ellenséget és hozzáadja õket a passive listához.
	 */
	public void produceAllEnemy(){
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Elindítja a következõ hullámot, ami annyi ellenségbõl fog állni amennyit paraméterként kapunk.
	 * 
	 * @param number Ez a szám adja meg, hogy a következõ hullám hány Enemy-bõl fog állni
	 */
	public void startWave(int number){
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Visszatér az összes még élõ ellenség számával (aktív + passzív)
	 * @return fennmaradó ellenségek száma (aki már meghalt az nincs benne)
	 */
	public int getNumber(){
		Writer.entry();
		Writer.synchronexit();
		return number;
	}
	
	/**
	 * Megsemmisíti a paraméterként kapott ellenséget.
	 * 
	 * Felszabadítja az erõforrásokat, törli az aktív listáról.
	 * 
	 * @param enemy A megsemmisítendõ ellenség referenciája
	 */
	public void killEnemy(Enemy enemy){
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Megadja az aktív ellenségek listáját.
	 * @return Az aktív ellenségek listája
	 */
	public ArrayList<Enemy> getActiveEnemies(){
		Writer.entry();
		Writer.synchronexit();
		return active;
	}

	/**
	 * Minden ellenséget lépteti egyel aki nincs lassítva.
	 * Aki lassítva van az addig vár ameddig le nem jár a lassítás.
	 */
	public void moveAllActiveEnemy(){
		Writer.entry();
		Writer.asynchronexit();
	}	

}
