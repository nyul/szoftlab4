import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Player {
	
	private int magicPower;
	private PlayingArea area;
	
	public Player(int magicPower) {
		this.magicPower = magicPower;
		area = new PlayingArea();
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
	 * @param magicRockList
	 * @param defense
	 */
	public void chooseUpgrade(ArrayList<MagicRock> magicRockList, Defense defense) {
		System.out.println("Select a number from the list!");
		for(int i = 0; i < magicRockList.size(); i++) {
			System.out.println(i + ": " + magicRockList.get(i).getName().get(magicRockList.get(i).getType()));   // hibalehetoseg
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
					}
					magicPower = magicPower - magicRockList.get(number).getPrice();
					defense.upgrade( magicRockList.get(number));
				} else {
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
		Writer.entry();
		area.initialize();
		Writer.asynchronexit();
	}
	
	/**
	 * Jatekos eleterejet csokkenti.
	 * @param price: megadja, hogy mennyivel csokkenti
	 */
	public void reduceMagicPower(int price) {
		Writer.entry();
		Writer.asynchronexit();
	}
	
}
