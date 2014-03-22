import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	private static int number;
	private static int tab = 0;
	Engine engine;
	
	public Main() {
		engine = null;
	}
	
	public void menu() {
		switch(number) {
		case 0:
			inditas();
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		}
	}
	
	public void inditas() {
		engine = new Engine();
		
	}
	
	public static void main(String[] args) throws IOException {
		Main main = new Main();
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
		System.out.println("Choose a use-case!");
		InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        number = Integer.parseInt(in.readLine());
		main.menu();
	}
}
