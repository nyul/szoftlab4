import java.util.ArrayList;
import java.util.Observable;
/**
 * A palya osszes csempejet tarolja.
 */
public class Geometry extends Observable {
	
	private ArrayList<GeometryDraw> observers;
	private ArrayList<ArrayList<Tile>> tiles;

	/**
	 * Geometry kosntruktor
	 */
	public Geometry() {
		observers = new ArrayList<GeometryDraw>();
		tiles = new ArrayList<ArrayList<Tile>>();
	}

	public ArrayList<ArrayList<Tile>> getTiles() {
		return tiles;
	}
	
	public void setTile(int row, int column, Tile tile) {
		tiles.get(row).set(column, tile);
		setChanged();
		notifyObservers(this, row, column);
	}
	
	public void notifyObservers(Observable observable, int row, int column) {
		System.out.println("Notifying to all the subscribers when product became available");
		for(GeometryDraw ob : observers) {
			ob.update(observable, this.tiles.get(row).get(column));
		}
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
	
	/**
	 * @param row: palya sorainak szama
	 * @param column: palya oszlopainak szama
	 *  
	 *  A jatek inditasakor a megadott parameterekkel letrehozunk egy csak Tile-okbol allo palyat,
	 *  kesobb erre helyezzuk el a Road es egyeb objektumokat
	 */
	public void createAllTile(int row, int column) {
		for(int i = 0; i < row; i++) {  
			tiles.add(new ArrayList<Tile>());
			for(int j = 0; j < column; j++) {
				tiles.get(i).add(new Tile(new Position(i, j)));    
			}
		}
	}
	
	/**
	 * Beregisztrálunk egy observert erre az osztályra
	 * @param observer
	 */
	public void registerObserver(GeometryDraw draw) {
		observers.add(draw);
	}
	/**
	 * Töröljük az adott observer-t a listából: már nem kell értesülnie a model állapot változásairól
	 * @param observer
	 */
	public void removeObserver(GeometryDraw draw) {
		observers.remove(draw);
	}
}
