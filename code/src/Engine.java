import java.util.Observable;

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
	private Player player;
	private Fellowship fellowship;
	private int counter;
	
	public Engine() {
		player = new Player(100);
		fellowship = new Fellowship();
		//fellowship.produceAllEnemy();
		player.startGame();
		counter = 1;
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
			for(int i = 0; i < player.getArea().getTower().size(); i++) {
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
						//this.player.reduceMagicPower(this.player.getMagicPower()+10);
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
		stepHandler();
		attackHandler();
		/**
		 *  ha nincs mar se passziv, se aktiv ellenseg, akkor gyozelem
		 */
		if(fellowship.getNumber() == 0) {
			victory();
		}
		/**
		 *  van-e a hegyen ellenseg, ha igen akkor vereseg
		 */
		player.getArea().isOnMountain(this);
		try {
			Thread.sleep(100);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * Vereseg
	 * Osszes lefoglalt objektumot felszabaditjuk es kiiratjuk, hogy Vereseg
	 */
	public boolean defeat() {
		fellowship.getActive().clear();
		fellowship.getPassive().clear();
		player.getArea().getObstacle().clear();
		player.getArea().getRoad().clear();
		player.getArea().getSource().clear();
		player.getArea().getTower().clear();
		Writer.writeText.add("Defeat! :(");
		
		return true;
	}
	/**
	 * Gyozelem
	 * Osszes lefoglalt objektumot felszabaditjuk es kiiratjuk, hogy Gyozelem
	 */
	public boolean victory() {
		fellowship.getActive().clear();
		fellowship.getPassive().clear();
		player.getArea().getObstacle().clear();
		player.getArea().getRoad().clear();
		player.getArea().getSource().clear();
		player.getArea().getTower().clear();
		Writer.writeText.add("Victory! :)");
		
		return true;
	}
}
