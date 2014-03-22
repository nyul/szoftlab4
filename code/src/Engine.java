
public class Engine extends Thread{
 	
	Player player;
	Fellowship fellowship;
	
	public Engine() {
		player = new Player(0);
		fellowship = new Fellowship(0);
	}
	
	public void attackHandler() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public void stepHandler() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public void takeToArea() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public void run() {
		Writer.entry();
		attackHandler();
		stepHandler();
		takeToArea();
		Writer.asynchronexit();
	}
	
	public void defeat() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public void victory() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public Player getPlayer() {
		Writer.entry();
		Writer.synchronexit();
		return player;
	}
}
