import java.util.ArrayList;


public class Obstacle extends Road implements Defense{
	
	private static int id = 0;
	private int myId;
	private int slowingFactor;
	private ArrayList<MagicRock> magicRock;
	private int magicRockNumber;
	private static int price = 5;
	
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


	public static void setPrice(int price) {
		Obstacle.price = price;
	}



	public int getSlowingFactor() {
		return slowingFactor;
	}



	public void setSlowingFactor(int slowingFactor) {
		this.slowingFactor = slowingFactor;
	}



	public ArrayList<MagicRock> getMagicRock() {
		return magicRock;
	}



	public void setMagicRock(ArrayList<MagicRock> magicRock) {
		this.magicRock = magicRock;
	}



	public int getMagicRockNumber() {
		return magicRockNumber;
	}



	public void setMagicRockNumber(int magicRockNumber) {
		this.magicRockNumber = magicRockNumber;
	}

	public static int getPrice() {
		return price;
	}

	public Enemy attack(ArrayList<Enemy> enemies, Geometry geometry) {	
		return null;
	}
	
	/**
	 * 
	 * @param player a player ezen keresztul szol
	 * hogy upgradelni akar valamit, es atadja magat
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
	 * lassitast vegez az e enemyn
	 */
	public void slowMe(Enemy e){
		e.increasePause(this.slowingFactor);
	}
}
