import java.util.ArrayList;
/**
 * A palya osszes csempejet tarolja.
 */
public class Geometry {

	private ArrayList<ArrayList<Tile>> tiles;

	/**
	 * Geometry kosntruktor
	 */
	public Geometry() {
		tiles = new ArrayList<ArrayList<Tile>>();
	}

	public ArrayList<ArrayList<Tile>> getTiles() {
		return tiles;
	}

	/**
	 * Megadja, hogy a parameterul kapott ellenseg a torony hatotavolsagan belul
	 * van-e.
	 * 
	 * @param enemy
	 *            - megkapja a vizsgalando enemyt
	 * @param tower
	 *            - megkapja a vizsgalando tornyot
	 * @return - visszaadja, hogy az enemy a torony hatotavolsagan belul van-e
	 */
	public boolean isInRange(Enemy enemy, Tower tower) {
		if(tower.getPos().getX()+tower.getRange() > enemy.getRoad().getPos().getX() 
				&& tower.getPos().getX()-tower.getRange() < enemy.getRoad().getPos().getX() 
				&& tower.getPos().getY()+tower.getRange() > enemy.getRoad().getPos().getY() 
				&& tower.getPos().getY()-tower.getRange() < enemy.getRoad().getPos().getY()) {
			return true;
		}
		else return false;
	}
	
	public void createAllTile(int row, int column) {
		for(int i = 0; i < row; i++) {  
			tiles.add(new ArrayList<Tile>());
			for(int j = 0; j < column; j++) {
				tiles.get(i).add(new Tile(new Position(i, j)));    
			}
		}
	}
}
