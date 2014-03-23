
/**
 * A j�t�kteret reprezent�l� objektum. A p�ly�t fel�p�t� elemt�pusok csoportjait tartalmazza. 
 * 
 * Felel�ss�ge: A p�lya inicializ�l�sa.
 * Felel�s az�rt, hogy inform�ci�t szolg�ltasson a t�rk�p egyes mez�inek tulajdons�gair�l,
 * ilyen inform�ci�szolg�ltat�s p�ld�ul a j�t�kos inform�l�sa a mez� be�p�thet�s�gr�l 
 * vagy az ellens�g inform�l�sa az �t k�vetkez� mez�j�r�l.
 */
public class PlayingArea {

	/**
	 * A p�ly�t inicializ�lja.
	 * 
	 * Az �t / utak bet�lt�se amin az ellens�gek haladnak.
	 * Hegy koordin�t�j�nak megad�sa, forr�s(ok) megad�sa.
	 */
	public void initialize() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Hozz�ad egy tornyot a tornyok list�j�hoz.
	 * @param t A hozz�adni k�v�nt torony referenci�ja
	 */
	public void addTower(Tower t) {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Hozz�ad egy akad�lyt az akad�lyok list�j�hoz.
	 * @param o A hozz�adni k�v�nt akad�ly referenci�ja
	 */	
	public void addObstacle(Obstacle o) {
		Writer.entry();
		Writer.asynchronexit();
	}
	
}
