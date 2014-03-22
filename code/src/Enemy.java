
public abstract class Enemy {
	protected int lifePower;
	protected int stepTime;
	protected int counter;
	protected Position currentPos;
	protected boolean isActive;
	protected boolean isSlowed;
	
	/**
	 * Enemy konstruktor
	 */
	public Enemy(int lifePower, int stepTime) {
	}
	
	/**
	 * Ellenség forrásra helyezése.
	 * 
	 */
	public void firstStep(Position p) {
	}
	
	/**
	 * A paraméterként kapott pozícióra lépteti
	 * az ellenséget.
	 */
	public void move(Position p) {
		
	}
	
	/**
	 * A paraméterlistán kapott toronytól leolvasott,
	 * erre az ellenség típusra vonatkozó sebzés értéket
	 * levonja az aktuális életerõbõl.
	 */
	public abstract void lifePowerReduce(Tower t);
	
	/**
	 * Visszatér egy boolean értékkel,
	 * ami megadja, hogy az adott ellenség lassítva van-e.
	 */
	public boolean getIsSlowed() {
		return isSlowed;
	}
}
