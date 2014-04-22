import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Player {
	
	private int magicPower; // A jatekos varazsereje
	private PlayingArea area; // A jatekter
	
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
	 * Ezek kozul valaszthat
	 * @param magicRockList - az adott Toronyra vagy Akadalyra helyezheto varazskovek listaja, amibol a Player valaszthat
	 * @param defense - az aktualis Torony vagy Akadaly, amire el szeretnenek helyezni a varazskovet
	 */
	public void chooseUpgrade(ArrayList<MagicRock> magicRockList, Defense defense) {
		System.out.println("Select a number from the list!");
		for(int i = 0; i < magicRockList.size(); i++) { // kilistazza az aktualis objektumon elerheto varazskoveket
			System.out.println(i + ": " + MagicRock.getName().get(magicRockList.get(i).getType())); 
		}
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(read);
		int number = 0;
		try {
			number = Integer.parseInt(in.readLine()); // beolvassa a valasztott szamot
			for(int i = 0; i < magicRockList.size(); i++) {
				if(number == magicRockList.get(i).getType()) {
					if(magicPower < magicRockList.get(number).getPrice()) { // ha nincs eleg varazsero
						System.out.println("You don't have enough magicpower.");
					} else { // ha van eleg varazsero
					magicPower = magicPower - magicRockList.get(number).getPrice(); // csokkenti a varazserot
					defense.upgrade(magicRockList.get(number)); // es elhelyezi a varazskovet a tornyon vagy akadalyon
					}
				} else if(number < 0 || number > 6) { // ha helytelen szamot adott meg
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
	 */
	public void startGame() {
		area = new PlayingArea();
		area.initialize();
	}
	
	/**
	 * Jatekos varazserejet csokkenti.
	 * @param price: megadja, hogy mennyivel csokkenti
	 */
	public void reduceMagicPower(int price) {
		this.magicPower = this.magicPower - price;
	}
	
}
