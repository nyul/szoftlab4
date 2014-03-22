
public abstract class Enemy {
	protected int lifePower;
	protected int stepTime;
	
	protected Position currentPos;
	protected boolean isActive;
	protected boolean isSlowed;
	
	/**
	 * Enemy konstruktor
	 * 
	 * @param lifePower ellenség életereje
	 * @param stepTime léptetés sebessége
	 */
	public Enemy(int lifePower, int stepTime) {
	}
	
	/**
	 * A paraméterként kapott pozícióra lépteti az ellenséget.
	 * 
	 * @param p A léptetés célpozíciója
	 */
	public void move(Position p) {
		
	}
	
	/**
	 * A paraméterlistán kapott toronytól leolvasott,
	 * erre az ellenség típusra vonatkozó sebzés értéket
	 * levonja az aktuális életerõbõl.
	 * 
	 * @param t A torony amelyik éppen lö erre az ellenségre
	 */
	public abstract void lifePowerReduce(Tower t);
	
	/**
	 * Visszatér egy boolean értékkel,
	 * ami megadja, hogy az adott ellenség lassítva van-e.
	 * 
	 * @return Ha az adott ellenség lassítva van true, egyébként false 
	 */
	public boolean getIsSlowed() {
		return isSlowed;
	}
}
