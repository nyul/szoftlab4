import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	private static int number;
	Engine engine;
	
	public Main() {
		engine = new Engine();
	}
	
	public void inditas() {
		// szukseges objektumok letrehozasa
		engine.createObject();
		engine.player.createObject();
		engine.fellowship.createObject();
		
		System.out.print("Engine");
		engine.player.startGame();
		engine.fellowship.produceAllEnemy();
		engine.run();
	}
	
	public void torony_epites() {
		
	}
	
	public void akadaly_epites() {
		
	}
	
	public void torony_fejlesztes() {
		
	}
	
	public void akadaly_fejlesztes() {
		
	}
	
	public void ellenseg_palyara_helyezese() {
		
	}
	
	public void ellenseg_leptetese() {
		
	}
	
	public void ellenseg_lassitasa() {
		Human e;
		engine.createObject();
		engine.fellowship.createObject();
		engine.fellowship.active.add(e);
		
		System.out.print("Fellowship");
		engine.fellowship.enemy.move();
	}
	
	public void vereseg() {
		
	}
	
	public void tuzeles() {
		
	}
	
	public void ellenseg_elpusztulasa() {
		
	}
	
	public void gyozelem() {
		
	}
	
	public void menu() {
		boolean isRun = true;
		
		while(isRun) {
			System.out.println("Use-case menu");
			System.out.println("1.Inditas");
			System.out.println("2.Torony epites");
			System.out.println("3.Akadaly epites");
			System.out.println("4.Torony fejlesztes");
			System.out.println("5.Akadaly fejlesztes");
			System.out.println("6.Ellenseg palyara helyezese");
			System.out.println("7.Ellenseg leptetese");
			System.out.println("8.Ellenseg lassitasa");
			System.out.println("9.Vereseg");
			System.out.println("10.Tuzeles");
			System.out.println("11.Ellenseg elpusztulasa");
			System.out.println("12.Gyozelem");
			System.out.println("0.Kilepes");
			System.out.println("");
			System.out.println("Valassz egy use-case-t!");
			InputStreamReader read = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(read);
			
			try {
				number = Integer.parseInt(in.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
			switch(number) {
			case 0:
				isRun = false;
				System.out.println("Kilepes a programbol.");
				break;
			case 1:
				inditas();
				break;
			case 2:
				torony_epites();
				break;
			case 3:
				akadaly_epites();
				break;
			case 4:
				torony_fejlesztes();
				break;
			case 5:
				akadaly_fejlesztes();
				break;
			case 6:
				ellenseg_palyara_helyezese();
				break;
			case 7:
				ellenseg_leptetese();
				break;
			case 8:
				ellenseg_lassitasa();
				break;
			case 9:
				vereseg();
				break;
			case 10:
				tuzeles();
				break;
			case 11:
				ellenseg_elpusztulasa();
				break;
			case 12:
				gyozelem();
				break;
			default:
				System.out.println("Nincs ilyen menupont. Probald meg ujra.");
			}
			
			System.out.println("---------------------");
			System.out.println("");
		}
        
	}
	
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.menu();
	}
}
