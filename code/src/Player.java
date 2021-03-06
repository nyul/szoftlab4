import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;


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
	
	private ArrayList<PlayerDraw> observers;
	private int magicPower; // A jatekos varazsereje
	private boolean stateMagic;
	private PlayingArea area; // A jatekter
	
	public Player(int magicPower) {
		observers = new ArrayList<PlayerDraw>();
		this.magicPower = magicPower;
		this.stateMagic = false;
	}
	
	public ArrayList<PlayerDraw> getObservers() {
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
		Object[] possibilities = new Object[6];
		for(int i = 0; i < magicRockList.size(); i++) { // kilistazza az aktualis objektumon elerheto varazskoveket
			possibilities[i] = MagicRock.name.get(magicRockList.get(i).getType());
		}
		String s = (String)JOptionPane.showInputDialog(
                GraphicsArea.frame,
                "Choose an upgrade from the list!",
                "Upgrade",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities, possibilities[0]);
		
		if(s != null){
			if(magicPower < magicRockList.get(0).getPrice()) { // ha nincs eleg varazsero
				System.out.println("You don't have enough magicpower.");
			} else { // ha van eleg varazsero
				reduceMagicPower(magicRockList.get(0).getPrice()); // csokkenti a varazserot
				defense.upgrade(magicRockList.get(0)); // es elhelyezi a varazskovet a tornyon vagy akadalyon
				if(defense instanceof Tower) {
					Tower tower = (Tower) defense;
					tower.increaseMagicRockNumber(1);
				}
				else if(defense instanceof Obstacle) {
					Obstacle obst = (Obstacle) defense;
					obst.increaseMagicRockNumber(1);
				}
			}
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
		stateMagic = true;
		setChanged();
		notifyObservers(this);
	}
	
	public void escalateMagicPower(int price) {
		if(this.magicPower + price > 100) {
			this.magicPower = 100;
		} else {
			this.magicPower = this.magicPower + price;
		}
		stateMagic = true;
		setChanged();
		notifyObservers(this);
	}
	
	public void notifyObservers(Observable observable) {
		for(Observer ob : observers) {
			if(stateMagic == true) {
				ob.update(observable, this.magicPower);
				stateMagic = false;
			}
		}
	}
	
	/**
	 * Beregisztr�lunk egy observert erre az oszt�lyra
	 * @param observer
	 */
	public void registerObserver(PlayerDraw draw) {
		observers.add(draw);
	}
	/**
	 * T�r�lj�k az adott observer-t a list�b�l: m�r nem kell �rtes�lnie a model �llapot v�ltoz�sair�l
	 * @param observer
	 */
	public void removeObserver(PlayerDraw draw) {
		observers.remove(draw);
	}
	
}
