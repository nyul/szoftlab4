
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Writer {
	private static int belepes;

	public Writer() {
		belepes = 0;
	}

	// Függvénybe való belépéskor hívandó, a megfelelő tabnyi behúzás után
	// kiírja az objektum osztályát és a metódus nevét.
	public static void entry() {
		// Behúzás növelése
		belepes++;
		// Tabok kiírása
		for (int i = 0; i < belepes; i++) {
			System.out.print('\t');
		}
		// Osztály és metódus név kiírása
		System.out.println("-->"
				+ Thread.currentThread().getStackTrace()[2].getClassName()
				+ "."
				+ Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	// Függvényből való visszatéréskor hívandó, a megfelelő tabnyi behúzás után
	// kiírja az objektum osztályát és a metódus nevét.
	public static void synchronexit() {
		// Megfelelő számú tab kiírása
		for (int i = 0; i < belepes; i++) {
			System.out.print('\t');
		}
		// Osztály és metódus név kiírása
		System.out.println("<--"
				+ Thread.currentThread().getStackTrace()[2].getClassName()
				+ "."
				+ Thread.currentThread().getStackTrace()[2].getMethodName());
		// Behúzás csökkentése
		belepes--;
	}
	
	public static void asynchronexit() {
		// Behúzás csökkentése
		belepes--;
	}

	// Kiíra és feldolgozza a use case-ek közben felmerülõ felhasználónak szóló
	// kérdéseket.
	public static boolean kerdes(String kerdes) {

		// Kiírja a kérdést
		System.out.println(kerdes);
		System.out.println("I:Igen N:Nem");
		while (true) {
			try {
				// Felhasználótól elkérjük a bemenetet
				System.out.print(">");
				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));
				String beolvas = br.readLine();

				// Ha I-vel kezdõdik, akkor Igennek vesszük.
				if (beolvas.startsWith("I") || beolvas.startsWith("i")) {
					return true;
				}

				// Ha N-nel, akkor nemnek.
				if (beolvas.startsWith("N") || beolvas.startsWith("n")) {
					return false;
				}

				// Ha mást ad meg, akkor kiírjuk, hogy rossz opciót adott meg és
				// újra megkérdezzük..
				System.out.println("? Nem megfelelo opciot adtal meg");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

