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
		// szukseges objektumok letrehozasa
		engine.createObject();
		engine.player.createObject();
		engine.player.tile.createObject();
				
		if(Writer.kerdes("Van elég varázserő a toronyépítéshez?")) {
			System.out.print("Player");
			engine.player.playingArea.addTower(engine.player.tile.buildTower(engine.player));
		}
	}
	
	public void akadaly_epites() {
		// szukseges objektumok letrehozasa
		engine.createObject();
		engine.player.createObject();
		engine.player.tile.createObject();
		
		if(Writer.kerdes("Van elég varázserő a akadályépítéshez?")) {
			System.out.print("Player");
			engine.player.playingArea.addObstacle(engine.player.tile.buildObstacle(engine.player));
		}
	}
	
	public void torony_fejlesztes() {
		// szukseges objektumok letrehozasa
		engine.createObject();
		engine.player.createObject();
		engine.tower.createObject();
		
		System.out.print("Player");
		engine.player.tower.wantToUpgrade(engine.player);		
		
	}
	
	public void akadaly_fejlesztes() {
		// szukseges objektumok letrehozasa
		engine.createObject();
		engine.player.createObject();
		engine.player.obstacle.createObject();
		
		System.out.print("Player");
		engine.player.obstacle.wantToUpgrade(engine.player);		
	}
	
	public void ellenseg_palyara_helyezese() {
		// szukseges objektumok letrehozasa
		engine.createObject();
		engine.fellowship.createObject();
		engine.fellowship.enemy.createObject();
		engine.fellowship.enemy.source.createObject();
		
		System.out.print("Engine");
		engine.takeToArea();
	}
	
	public void ellenseg_leptetese() {
		// szukseges objektumok letrehozasa
		engine.createObject();
		engine.fellowship.createObject();
		engine.fellowship.enemy.createObject();
		engine.fellowship.enemy.road.createObject();
		
		System.out.print("Engine");
		engine.stepHandler();
	}
	
	public void ellenseg_lassitasa() {
		// szukseges objektumok letrehozasa
		engine.createObject();
		engine.fellowship.createObject();
		
		engine.fellowship.enemy.createObject();
		
		engine.fellowship.enemy.road.createObject();
		engine.fellowship.enemy.obstacle.createObject();
		
		System.out.print("Enemy");
		engine.fellowship.enemy.move();
	}
	
	public void vereseg() {
		engine.createObject();
		engine.player.createObject();
		engine.player.playingArea.createObject();

		engine.player.playingArea.isOnMountain(engine);
	}
	
	public void tuzeles() {
		// szukseges objektumok letrehozasa
		engine.createObject();
		engine.fellowship.createObject();
		engine.tower.createObject();
		
		System.out.print("Engine");
		engine.attackHandler();
	}
	
	public void ellenseg_elpusztulasa() {
		// szukseges objektumok letrehozasa
		engine.createObject();
		engine.fellowship.createObject();
		engine.tower.createObject();
				
		System.out.print("Engine");
		engine.attackHandler();
	}
	
	public void gyozelem() {
		// szukseges objektumok letrehozasa
		engine.createObject();
		engine.fellowship.createObject();
		
		System.out.print("Engine");
		engine.fellowship.getNumber();		
		if(Writer.kerdes("Az ellensegek szama 0?")) {
			engine.victory();		
		}						
	}
	
	/**
	 * Use-case menu
	 * Lefut egy use-case attol fuggoen, hogy milyen szamot adott meg a felhasznalo. 0-12
	 */
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
