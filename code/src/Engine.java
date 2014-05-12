import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Egesz jatek motorja, ami az idozitest es a leptetes utemezeset vegzi. Ezenfelul felelossege, hogy a gyozelem illetve vereseg
 * felismerese. Player-on keresztul latja az egesz palyat, Fellowship-en keresztul pedig latja az osszes ellenseget.
 */
public class Engine extends Observable implements Runnable{
	/**
	 * player - egy jatekosra mutato referencia
	 * fellowship - egy szovetsegre mutato referencia
	 * counter - lovesvizsgalat gyakorisagahoz szukseges
	 */
	private ArrayList<EngineDraw> observers;
	private boolean isVictory;
	private boolean isDefeat;
	private Player player;
	private Fellowship fellowship;
	private int counter;
	private int randValue;  //kod random mukodesehez
	private int tick;
	private int waveCount;
	
	public Engine() {
		observers = new ArrayList<EngineDraw>();
		isVictory = false;
		isDefeat = false;
		player = new Player(100);
		fellowship = new Fellowship();
		fellowship.produceAllEnemy();
		player.startGame();
		counter = 1;
		randValue = 0;
		tick = 0;
		waveCount = 3;
	}
	
	public ArrayList<EngineDraw> getObservers() {
		return observers;
	}

	public Player getPlayer() {
		return player;
	}

	public Fellowship getFellowship() {
		return fellowship;
	}
	
	/**
	 * A torony tuzelesenek kezdemenyzeset vegzi. Bizonyos idokozonkent meghivja az osszes toronynak az attack(...) metodusat, ami
	 * a tuzeles vegrehajtasat vegzi.
	 */
	public void attackHandler() {
		if(counter >= 10) {
			Enemy enemy = null;
			randValue = (int)(Math.random() * player.getArea().getTower().size()*5);
			for(int i = 0; i < player.getArea().getTower().size(); i++) {
				if(randValue % 4 == 0) {
					player.getArea().getTower().get(i).fogOn();
				}
				else if(randValue % 3 == 0) {
					player.getArea().getTower().get(i).fogOff();
				}
				
				/**
				 *  attack metodus visszadja azt az ellenseget, akit meglott, de ha nem lott senkire, akkor egy null-al ter vissza
				 */
				enemy = player.getArea().getTower().get(i).attack(fellowship.getActive(), player.getArea().getGeometry());
				if(enemy != null) {
					/**
					 *  megvizsgaljuk, hogy a megsebzett ellensegnek, aki biztosan aktiv volt sebzes elott, passziv lett-e
					 *  ez csak akkor kovetkezhet be, ha a sebzes soran az ellenseg eletereje kisebb egyenlo lesz, mint 0
					 */
					if(enemy.isActive() == false) {
						/**
						 *  ellenseget meg kell olnunk, azaz torolnunk kell az aktiv listabol
						 */
						fellowship.killEnemy(enemy);
						this.player.escalateMagicPower(10);
					}
					/**
					 *  ellenseg sebzese soran kette lett-e hasitva, true ha igen
					 *  fontos, hogy az ellenseget csak akkor lehet kettehasitani, ha aktiv, azaz sebzes utan maradt eleg eletereje
					 */
					if(enemy.isDuplicated() == true && enemy.isActive == true) {
						/**
						 *  klonozni kell a meglott ellenseget
						 */
						fellowship.addToActiveEnemyList(enemy);
						/**
						 *  isDuplicate valtozot vissza kell allitani false-ra, kulonben minden lepesben klonozas tortenne
						 */
						enemy.setDuplicated(false);
					}
				}
			}
			counter = 1;
		} else {
			counter = counter + 1;
		}
	}
	/**
	 * Aktov ellensegek leptetesenek kezdemenyezese bizonyos idokozonkent
	 */
	public void stepHandler() {
		if(tick % 100 == 0) {
			fellowship.startWave(waveCount++, player.getArea().getSource());
			tick = 1;
		}
		fellowship.moveAllActiveEnemy();
	}
	/**
	 * Egy megadott szamu passziv ellenseg palyara helyezesenek kezdemenyezese
	 */
	public void takeToArea() {
		fellowship.startWave(5, player.getArea().getSource());
	}
	/**
	 * Ez itt a motor, ami az egesz gepezetet hajtja. stepHandler illetve attackHandler bizonyos idokozonkent meghivodik
	 * Most meg a step number bemeneti parancs hatasara ez a fv. 10*number-szor fut le 100 ms-onkent
	 */
	public void run() {
		//while(true) {
			stepHandler();
			attackHandler();
			/**
			 *  ha nincs mar se passziv, se aktiv ellenseg, akkor gyozelem
			 */
			if(fellowship.getNumber() == 0) {
				victory();
				try {
					Thread.sleep(1000);
				} catch(Exception ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
			/**
			 *  van-e a hegyen ellenseg, ha igen akkor vereseg
			 */
			player.getArea().isOnMountain(this);
			try {
				tick += 1;
				Thread.sleep(100);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		//}
	}
	/**
	 * Vereseg
	 * Osszes lefoglalt objektumot felszabaditjuk es kiiratjuk, hogy Vereseg
	 */
	public void defeat() {
		fellowship.getActive().clear();
		fellowship.getPassive().clear();
		player.getArea().getObstacle().clear();
		player.getArea().getRoad().clear();
		player.getArea().getSource().clear();
		player.getArea().getTower().clear();
		Writer.writeText.add("Defeat! :(");
		
		isDefeat = true;
		setChanged();
		notifyObservers(this);
	}
	/**
	 * Gyozelem
	 * Osszes lefoglalt objektumot felszabaditjuk es kiiratjuk, hogy Gyozelem
	 */
	public void victory() {
		fellowship.getActive().clear();
		fellowship.getPassive().clear();
		player.getArea().getObstacle().clear();
		player.getArea().getRoad().clear();
		player.getArea().getSource().clear();
		player.getArea().getTower().clear();
		Writer.writeText.add("Victory! :)");
		
		isVictory = true;
		setChanged();
		notifyObservers(this);
	}
	
	public void notifyObservers(Observable observable) {
		for(Observer ob : observers) {
			if(isVictory == true) {
				ob.update(observable, this.getFellowship());
				isVictory = false;
			}
			else if(isDefeat == true) {
				ob.update(observable, this.getPlayer());
				isDefeat = false;
			}
		}
	}
	
	/**
	 * Beregisztrálunk egy observert erre az osztályra
	 * @param observer
	 */
	public void registerObserver(EngineDraw draw) {
		observers.add(draw);
	}
	/**
	 * Töröljük az adott observer-t a listából: már nem kell értesülnie a model állapot változásairól
	 * @param observer
	 */
	public void removeObserver(EngineDraw draw) {
		observers.remove(draw);
	}
}
