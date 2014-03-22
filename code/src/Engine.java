
public class Engine extends Thread{
 	
	public Engine() {
		System.out.println("Engine() constructor");
	}

	public void attackHandler() {
		System.out.println("attackHandler()");
	}
	
	public void stepHandler() {
		System.out.println("stepHandler()");
	}
	
	public void takeToArea() {
		System.out.println("takeToArea()");
	}
	
	public void run() {
		System.out.println("run()");
	}
	
	public void defeat() {
		System.out.println("defeat()");
	}
	
	public void victory() {
		System.out.println("victory()");
	}
	
	public void getPlayer() {
		System.out.println("getPlayer()");
	}
}
