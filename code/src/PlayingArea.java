import java.util.ArrayList;

/**
 * A játékteret reprezentáló objektum. A pályát felépítõ elemtípusok csoportjait tartalmazza. 
 * 
 * Felelõssége: A pálya inicializálása.
 * Felelõs azért, hogy információt szolgáltasson a térkép egyes mezõinek tulajdonságairól,
 * ilyen információszolgáltatás például a játékos informálása a mezõ beépíthetõségrõl 
 * vagy az ellenség informálása az út következõ mezõjérõl.
 */
public class PlayingArea {
	
	ArrayList<Source> source;
	ArrayList<Tower> tower;
	ArrayList<Obstacle> obstacle;
	Mountain mountain;
	
	public PlayingArea() {

	}

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
	 * Megadja hány forrás van a pályán, és ezeknek az elhelyezkedését.
	 * @return A források listája
	 */
	public ArrayList<Source> getSourceList() {
		Writer.entry();
		Writer.synchronexit();
		return source;
	}
	
	/**
	 * Megadja hány akadály van a pályán, és ezeknek az elhelyezkedését.
	 * @return Az akadályok listája
	 */
	public ArrayList<Obstacle> getObstacleList() {
		Writer.entry();
		Writer.synchronexit();
		return obstacle;
	}
	
	/**
	 * Megadja hány torony van a pályán, és ezeknek az elhelyezkedését.
	 * @return A tornyok listája
	 */
	public ArrayList<Tower> getTowerList() {
		Writer.entry();
		Writer.synchronexit();
		return tower;
	}
	
	/**
	 * Megadja, hogy hol helyezkedik el a Végzet Hegye a pályán.
	 * @return Az hegy referenciája
	 */
	public Mountain getMountain() {
		Writer.entry();
		Writer.synchronexit();
		return mountain;
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
