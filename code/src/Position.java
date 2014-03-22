
public class Position {
	
	private int x;
	private int y;
	
	public Position() {
		System.out.println("Position() constructor");
	}

	public int getX(){
		Writer.entry();
		Writer.synchronexit();
		return x;					
	}
	public int getY(){
		Writer.entry();
		Writer.synchronexit();
		return y;							
	}
	
	public void setX(int xx){
		Writer.entry();
		Writer.asynchronexit();
		x = xx;
	}
	public void setY(int yy){
		Writer.entry();
		Writer.asynchronexit();
		y = yy;
	}
}
