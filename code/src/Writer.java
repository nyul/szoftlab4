
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Writer {
	private static int belepes;

	public Writer() {
		belepes = 0;
	}

	/**
	 * Fuggvenybe valo belepeskor hivando, a megfelelo tabnyi behuzas utan
	 * kiirja az objektum osztalyat es a metodus nevet.
	 */
	public static void entry() {
		// Behuzas novelese
		belepes++;
		// Tabok kiirasa
		for (int i = 0; i < belepes; i++) {
			System.out.print('\t');
		}
		// Osztaly es metodus nev kiirasa
		System.out.println("-->"
				+ Thread.currentThread().getStackTrace()[2].getClassName()
				+ "."
				+ Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	/**
	 * Szinkron fuggvenybol valo visszatereskor hivando, a megfelelo tabnyi behuzas utan
	 * kiirja az objektum osztalyat es a metodus nevet.
	 */
	public static void synchronexit() {
		// Megfelelo szamu tab kiirasa
		for (int i = 0; i < belepes; i++) {
			System.out.print('\t');
		}
		// Osztaly es metodus nev kiirasa
		System.out.println("<--"
				+ Thread.currentThread().getStackTrace()[2].getClassName()
				+ "."
				+ Thread.currentThread().getStackTrace()[2].getMethodName());
		// Behuzas csokkentese
		belepes--;
	}
	
	public static void asynchronexit() {
		// Behuzas csokkentese
		belepes--;
	}

	/**
	 * Kiirja es feldolgozza a use case-ek kozben felmerulo felhasznalonak szolo kerdeseket.
	 * @param kerdes A kiirando kerdes
	 * @return ha a valasz igen akkor true, ha nem akkor false
	 */
	public static boolean kerdes(String kerdes) {

		// Kirja a kerdest
		System.out.println(kerdes);
		System.out.println("I:Igen N:Nem");
		while (true) {
			try {
				// Felhasznalotol elkerjuk a bemenetet
				System.out.print(">");
				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));
				String beolvas = br.readLine();

				// Ha I-vel kezdodik akkor igennek vesszuk
				if (beolvas.startsWith("I") || beolvas.startsWith("i")) {
					return true;
				}

				// Ha N-nel, akkor nemnek.
				if (beolvas.startsWith("N") || beolvas.startsWith("n")) {
					return false;
				}

				// Ha mast ad meg akkor kiirjuk, hogy rossz opciot adott meg
				// es ujra megkerdezzuk
				System.out.println("? Nem megfelelo opciot adtal meg");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

