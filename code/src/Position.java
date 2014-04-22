/**
 * Pozicio osztaly - 
 * Az osszes pozicioval rendelkezo Entitas a jatek soran ennek
 * az osztalynak a felhasznalasaval kap poziciot.
 */
public class Position {
	
	private int x;
	private int y;
	
	/**
	 * Position konstruktor
	 * @param x - x koordinata
	 * @param y - y koordinata
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
