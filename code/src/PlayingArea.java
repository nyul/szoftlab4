
/**
 * A jatekteret reprezentalo objektum. A palyat felepito elemtipusok csoportjait tartalmazza. 
 * 
 * Felelossege: A palya inicializalasa.
 * Felelos azert, hogy informaciot szolgaltasson a terkep egyes mezoinek tulajdonsagairol,
 * ilyen informaciaszolgaltatas peldaul a jatekos informalasa a mezo beepithetosegrol 
 * vagy az ellenseg informalasa az ut k�vetkezo mezojerol.
 */
public class PlayingArea {

	/**
	 * A palyat inicializalja.
	 * 
	 * Az ut / utak bet�ltese amin az ellensegek haladnak.
	 * Hegy koordinatajanak megadasa, forras(ok) megadasa.
	 */
	public void initialize() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Hozz�ad egy tornyot a tornyok list�j�hoz.
	 * @param t A hozz�adni k�v�nt torony referenci�ja
	 */
	public void addTower(Tower t) {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Hozzaad egy akadalyt az akadalyok listajahoz.
	 * @param o A hozzaadni kivant akadaly referenciaja
	 */	
	public void addObstacle(Obstacle o) {
		Writer.entry();
		Writer.asynchronexit();
	}
	
}
