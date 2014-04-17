import java.util.ArrayList;

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



	public void setTiles(ArrayList<ArrayList<Tile>> tiles) {
		this.tiles = tiles;
	}



	/**
	 * Megadja, hogy a parameterul kapott ellenseg a torony hatotavolsagan belul van-e.
	 * @param enemy - megkapja a vizsgalando enemyt
	 * @param tower - megkapja a vizsgalando tornyot
	 * @return - visszaadja, hogy az enemy a torony hatotavan belul van-e
	 */
	public boolean isInRange(Enemy enemy, Tower tower){
		Writer.entry();
		Writer.synchronexit();
		return true;
	}
}
