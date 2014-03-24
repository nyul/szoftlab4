import java.util.ArrayList;


/**
 * A jatekteret reprezentalo objektum. A palyat felepito elemtipusok csoportjait tartalmazza. 
 * 
 * Felelossege: A palya inicializalasa.
 * Felelos azert, hogy informaciot szolgaltasson a terkep egyes mezoinek tulajdonsagairol,
 * ilyen informaciaszolgaltatas peldaul a jatekos informalasa a mezo beepithetosegrol 
 * vagy az ellenseg informalasa az ut következo mezojerol.
 */
public class PlayingArea {
	
	Mountain mountain;
	
	public PlayingArea() {
		mountain = null;
	}
	
	public void createObject() {
		mountain = new Mountain();
	}
	
	/**
	 * A palyat inicializalja.
	 * 
	 * Az ut / utak betotese amin az ellensegek haladnak.
	 * Hegy koordinatajanak megadasa, forras(ok) megadasa.
	 */
	public void initialize() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Hozzaad egy tornyot a tornyok listajahoz.
	 * @param t - a hozzaadni kivant torony referenciaja
	 */
	public void addTower(Tower t) {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Hozzaad egy akadalyt az akadalyok listajahoz.
	 * @param o - a hozzaadni kivant akadaly referenciaja
	 */	
	public void addObstacle(Obstacle o) {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Megadja, hogy aktualis tickben van-e ellenseg a hegyen.
	 * Ha igen akkor a parameterul kapott engine referencian meghivja a defeat() metodust tehat a jatek veget er.
	 * @param e - az engine osztaly referenciaja
	 */
	public void isOnMountain(Engine e){
		if(true){ 				// a szkeleton teszthez ennek igazat kell adnia,
			Writer.entry();		// valojaban itt lesz implementalva a vizsgalat,
			e.defeat(); 		// hogy valoban all-e a hegyen ellenseg.
			Writer.asynchronexit();
		}						
	}
}
