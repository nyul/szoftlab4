
public class Tile {
	protected char type;
	protected int price;
	protected Position pos;
	
	public Tile(char c, Position p) {
		type = c;
		price = 0;
		pos = p;
	}
	
	public Position getPos() {
		return pos;
	}
	
	public char getType() {
		return type;
	}
	
	public void setType(char c) {
		type = c;
	}
	
	public int getPrice() {
		return price;
	}
}
