
public class Tile {
	protected char beepitheto;
	protected Position pos;
	
	public Tile(char c, Position p) {
		beepitheto = c;
		pos = p;
	}
	
	public Position getPos() {
		return pos;
	}
	
	public char getBeepitheto() {
		return beepitheto;
	}
	
	public void setBeepitheto(char c) {
		beepitheto = c;
	}
}
