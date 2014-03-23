
/**
 * A játékteret reprezentáló objektum. A pályát felépítõ elemtípusok csoportjait tartalmazza. 
 * 
 * Felelõssége: A pálya inicializálása.
 * Felelõs azért, hogy információt szolgáltasson a térkép egyes mezõinek tulajdonságairól,
 * ilyen információszolgáltatás például a játékos informálása a mezõ beépíthetõségrõl 
 * vagy az ellenség informálása az út következõ mezõjérõl.
 */
public class PlayingArea {

	/**
	 * A pályát inicializálja.
	 * 
	 * Az út / utak betöltése amin az ellenségek haladnak.
	 * Hegy koordinátájának megadása, forrás(ok) megadása.
	 */
	public void initialize() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Hozzáad egy tornyot a tornyok listájához.
	 * @param t A hozzáadni kívánt torony referenciája
	 */
	public void addTower(Tower t) {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Hozzáad egy akadályt az akadályok listájához.
	 * @param o A hozzáadni kívánt akadály referenciája
	 */	
	public void addObstacle(Obstacle o) {
		Writer.entry();
		Writer.asynchronexit();
	}
	
}
