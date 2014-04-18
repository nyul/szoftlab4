import java.util.ArrayList;


public class Obstacle extends Road implements Defense{
	
	private int slowingFactor;
	private ArrayList<MagicRock> magicRock;
	private int magicRockNumber;
	private static int price;
	
	public Obstacle(Position pos) {
		super(pos);
		slowingFactor = 1;
		magicRock = new ArrayList<MagicRock>();
		magicRockNumber = 0;
		this.type = 3;
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
	
	public void wantToUpgrade(Player player){
		player.chooseUpgrade(magicRock, this);	
	}
	
	public void upgrade(MagicRock magicRock){
		if(magicRock.getType() == 6) {
			slowingFactor = slowingFactor + 1;
		}
	}

	public void slowMe(Enemy e){
		Writer.entry();
		e.increasePause(0);
		Writer.asynchronexit();
	}
	
	public void setPos(Position pos){
		Writer.entry();
		Writer.asynchronexit();
	};
}
