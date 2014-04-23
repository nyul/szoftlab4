import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * A jatekost reprezentalo objektum. Tarolja a jatekos varazserejet, ami szukseges a
tornyok es az akadalyok epitesehez. Felelos a tornyok es akadalyok epiteeseert, illetve
kezdemenyezheti ezek elhelyezeset a jatekter megfelelo reszein, tovabba felelos a
mar meglevo tornyok es akadalyok fejleszteesert varazskovek felhasznalasaval.
felelos a kivalasztott epitesi terilet beepithetosegenek, valamint az epiteshez  
szukgesges varazsero megallapitasaert, es player dolga tovabba a sajat
varazserejenek folyamatos menedzselese. A Player objektum inditja a jatekot.
 *
 */
public class Player {
	
	private int magicPower;
	private PlayingArea area;
	
	public Player(int magicPower) {
		this.magicPower = magicPower;
	}
	
	public int getMagicPower() {
		return magicPower;
	}

	public void setMagicPower(int magicPower) {
		this.magicPower = magicPower;
	}



	public PlayingArea getArea() {
		return area;
	}



	public void setArea(PlayingArea area) {
		this.area = area;
	}



	/**
	 * Egy listaban megkapja a jatekos, hogy egy toronyra vagy akadalyra milyen varazskoveket lehet rakni.
	 * Ezek kozul valaszthat,
	 * hogy milyen fejlesztest akar vegezni az adott tornyon vagy akadalyon
	 * @param magicRockList
	 * @param defense
	 */
	public void chooseUpgrade(ArrayList<MagicRock> magicRockList, Defense defense) {
		System.out.println("Select a number from the list!");
		for(int i = 0; i < magicRockList.size(); i++) {
			System.out.println(i + ": " + MagicRock.getName().get(magicRockList.get(i).getType())); 
		}
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(read);
		int number = 0;
		try {
			number = Integer.parseInt(in.readLine());
			for(int i = 0; i < magicRockList.size(); i++) {
				if(number == magicRockList.get(i).getType()) {
					if(magicPower < magicRockList.get(number).getPrice()) {
						System.out.println("You don't have enough magicpower.");
					} else {
					magicPower = magicPower - magicRockList.get(number).getPrice();
					defense.upgrade(magicRockList.get(number));
					}
				} else if(number < 0 || number > 6) {
					System.out.println("Wrong number.");
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Not a number");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Jatekos elinditja a jatekot, ezzel egyutt inicializalodik a palya.
	 * Ez a jatek kezdo lepese
	 */
	public void startGame() {
		area = new PlayingArea();
		area.initialize();
	}
	
	/**
	 * Jatekos varazserejet csokkenti.
	 * @param price: 
	 * megadja, hogy mennyivel csokkenti a varazserot
	 * A letrehozott objektum araval fog csokkenni
	 */
	public void reduceMagicPower(int price) {
		this.magicPower = this.magicPower - price;
	}
	
}
