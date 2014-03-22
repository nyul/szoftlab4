
public abstract class Enemy {
	protected int lifePower;
	protected int stepTime;
	
	protected Position currentPos;
	protected boolean isActive;
	protected boolean isSlowed;
	
	/**
	 * Enemy konstruktor
	 * 
	 * @param lifePower ellens�g �letereje
	 * @param stepTime l�ptet�s sebess�ge
	 */
	public Enemy(int lifePower, int stepTime) {
	}
	
	/**
	 * A param�terk�nt kapott poz�ci�ra l�pteti az ellens�get.
	 * 
	 * @param p A l�ptet�s c�lpoz�ci�ja
	 */
	public void move(Position p) {
		
	}
	
	/**
	 * A param�terlist�n kapott toronyt�l leolvasott,
	 * erre az ellens�g t�pusra vonatkoz� sebz�s �rt�ket
	 * levonja az aktu�lis �leter�b�l.
	 * 
	 * @param t A torony amelyik �ppen l� erre az ellens�gre
	 */
	public abstract void lifePowerReduce(Tower t);
	
	/**
	 * Visszat�r egy boolean �rt�kkel,
	 * ami megadja, hogy az adott ellens�g lass�tva van-e.
	 * 
	 * @return Ha az adott ellens�g lass�tva van true, egy�bk�nt false 
	 */
	public boolean getIsSlowed() {
		return isSlowed;
	}
}
