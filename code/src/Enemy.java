
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
	 * Ellens�g forr�sra helyez�se.
	 * 
	 */
	public void firstStep(Position p) {
	}
	
	/**
	 * A param�terk�nt kapott poz�ci�ra l�pteti
	 * az ellens�get.
	 */
	public void move(Position p) {
		
	}
	
	/**
	 * A param�terlist�n kapott toronyt�l leolvasott,
	 * erre az ellens�g t�pusra vonatkoz� sebz�s �rt�ket
	 * levonja az aktu�lis �leter�b�l.
	 */
	public abstract void lifePowerReduce(Tower t);
	
	/**
	 * Visszat�r egy boolean �rt�kkel,
	 * ami megadja, hogy az adott ellens�g lass�tva van-e.
	 */
	public boolean getIsSlowed() {
		return isSlowed;
	}
}
