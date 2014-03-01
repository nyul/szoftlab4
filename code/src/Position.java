
public class Position {
	private int x;
	private int y;
	
	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int number) {
		x = number;
	}
	
	public void setY(int number) {
		y = number;
	}
	
	public boolean equals(Position p1, Position p2) {
		if(p1.x == p2.x && p1.y == p2.y) return true;
		else return false;
	}
	
	public double distance(Position p1, Position p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}
}
