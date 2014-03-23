
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
		x = xx;
		Writer.asynchronexit();
		
	}
	public void setY(int yy){
		Writer.entry();
		y = yy;
		Writer.asynchronexit();
		
	}
}
