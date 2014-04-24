import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


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
public class Player extends Observable {
	
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private int magicPower; // A jatekos varazsereje
	private PlayingArea area; // A jatekter
	
	public Player(int magicPower) {
		this.magicPower = magicPower;
	}
	
	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public int getMagicPower() {
		return magicPower;
	}

	public PlayingArea getArea() {
		return area;
	}

	/**
	 * Egy listaban megkapja a jatekos, hogy egy toronyra vagy akadalyra milyen varazskoveket lehet rakni.
	 * Ezek kozul valaszthat
	 * @param magicRockList - az adott Toronyra vagy Akadalyra helyezheto varazskovek listaja, amibol a Player valaszthat
	 * @param defense - az aktualis Torony vagy Akadaly, amire el szeretnenek helyezni a varazskovet
	 * Ezek kozul valaszthat,
	 * hogy milyen fejlesztest akar vegezni az adott tornyon vagy akadalyon
	 * @param magicRockList
	 * @param defense
	 */
	public void chooseUpgrade(ArrayList<MagicRock> magicRockList, Defense defense) {
		System.out.println("Select a number from the list!");
		for(int i = 0; i < magicRockList.size(); i++) { // kilistazza az aktualis objektumon elerheto varazskoveket
			System.out.println(i + ": " + MagicRock.name.get(magicRockList.get(i).getType())); 
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
						if(defense instanceof Tower) {
							Tower tower = (Tower) defense;
							tower.increaseMagicRockNumber(1);
						}
						else if(defense instanceof Obstacle) {
							Obstacle obst = (Obstacle) defense;
							obst.increaseMagicRockNumber(1);
						}
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
		if(this.magicPower - price < 0) {
			this.magicPower = 0;
		} else {
			this.magicPower = this.magicPower - price;
		}
		setChanged();
		notifyObservers(this, price);
	}
	
	public void notifyObservers(Observable observable, int price) {
		System.out.println("Notifying to all the subscribers when product became available");
		for(Observer ob : observers) {
			ob.update(observable, this.magicPower);
		}
	}
	/**
	 * Beregisztrálunk egy observert erre az osztályra
	 * @param observer
	 */
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
	/**
	 * Töröljük az adott observer-t a listából: már nem kell értesülnie a model állapot változásairól
	 * @param observer
	 */
	public void removeObservers(Observer observer) {
		observers.remove(observer);
	}
	
}
