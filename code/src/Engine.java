
public class Engine extends Thread{
 	
	Player player;
	Fellowship fellowship;
	
	public Engine() {
		player = new Player(0);
		fellowship = new Fellowship();
	}
	
	public void attackHandler() {
		
	}
	
	public void stepHandler() {
		
	}
	
	public void takeToArea() {
		
	}
	
	public void run() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public void defeat() {
		
	}
	
	public void victory() {
	}
	
	public Player getPlayer() {
		return player;
	}
}
