import java.util.ArrayList;


/**
 * Ez egy akadaly objetum, ami lassitja az ellenseg haladasat az akadaly terueten
 * belul. Tovabba tarolja a rahelyezheto varazskoveket es az akadalyon levo
 * varazskovek szamat. 
 *
 */
public class Obstacle extends Road implements Defense{
	
	private static int id = 0;
	private int myId;
	private int slowingFactor;
	private ArrayList<MagicRock> magicRock;
	private int magicRockNumber;
	private static int price = 5;
	
	/**
	 * Akadaly konstruktor
	 * @param pos - annak a csempenek a pozicioja amelyikre szeretnenk epiteni az akadalyt (csak utra helyezheto)
	 */
	public Obstacle(Position pos) {
		super(pos);
		myId=id;
		id++;
		slowingFactor = 1;
		magicRock = new ArrayList<MagicRock>();
		magicRockNumber = 0;
		this.type = 3;
	}
	
	/**
	 * @return az akadaly ID-jet adja vissza
	 */
	public int getMyId() {
		return myId;
	}

	/**
	 * az akadaly arat allitja be
	 * @param price - a beallitando ar
	 */
	public static void setPrice(int price) {
		Obstacle.price = price;
	}
	
	/**
	 * megadja mennyivel lassit az akadaly
	 * @return - a lassitas merteke
	 */
	public int getSlowingFactor() {
		return slowingFactor;
	}

	/**
	 * az akadaly lassitasanak merteket allithatjuk be vele
	 * @param slowingFactor - a lassitas merteke
	 */
	public void setSlowingFactor(int slowingFactor) {
		this.slowingFactor = slowingFactor;
	}

	/**
	 * az akadalyra elhelyezheto varazskovek listajat adja vissza
	 * @return - az elhelyezheto varazskovek listaja
	 */
	public ArrayList<MagicRock> getMagicRock() {
		return magicRock;
	}

	/**
	 * az akadalyra elhelyezheto varazskovek listajat adhatjuk meg
	 * @param magicRock - az elhelyezheto varazskovek listaja
	 */
	public void setMagicRock(ArrayList<MagicRock> magicRock) {
		this.magicRock = magicRock;
	}

	/**
	 * az elhelyezett varazskovek szamat adja meg
	 * @return - az elhelyezett varazskovek szama
	 */
	public int getMagicRockNumber() {
		return magicRockNumber;
	}

	public void setMagicRockNumber(int magicRockNumber) {
		this.magicRockNumber = magicRockNumber;
	}

	public static int getPrice() {
		return price;
	}

	/* (non-Javadoc)
	 * @see Defense#attack(java.util.ArrayList, Geometry)
	 * az akadaly nem tamad, ezert ures a metodus hasa
	 */
	public Enemy attack(ArrayList<Enemy> enemies, Geometry geometry) {	
		return null;
	}
	
	/**
	 * 
	 * @param player 
	 * a player ezen keresztul szol
	 * hogy upgradelni akarja az akadalyt, es atadja magat,
	 * hogy majd a varazsereje lecsokkentheto legyen
	 */
	
	public void wantToUpgrade(Player player){
		player.chooseUpgrade(magicRock, this);	
	}
	
	/**
	 * fejlesztest vegzo fuggveny 
	 * @param m parameterkent a varazskovet kapja meg
	 * amivel a jatekos fejleszt
	 */
	
	public void upgrade(MagicRock magicRock){
		if(magicRock.getType() == 6) {
			slowingFactor = slowingFactor + 1;
		}
	}

	/**
	 * @param e
	 * lassitast vegez az e parameterkent kapott enemy-n, beallitja a slowingfactort
	 * igy az adott enemy lassitva lesz, amig vissza nem allitju a slowingFactort
	 */
	public void slowMe(Enemy e){
		e.increasePause(this.slowingFactor);
	}
}
