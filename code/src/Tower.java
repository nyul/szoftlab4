import java.util.ArrayList;


public class Tower extends Tile implements Defense{
	
	Geometry geometry;
	Enemy enemy;
	ArrayList<MagicRock> choosable;
	
	/**
	 * Tower konstruktor
	 */
	
	public Tower() {
		geometry = null;
		enemy = null;
		choosable = null;
	}
	
	public void createObject() {
		geometry = new Geometry();
		enemy = new Human();
		choosable = new ArrayList<MagicRock>();
	}
	
	
	
	public Enemy attack(ArrayList<Enemy> enemies) {
		Writer.entry();
		geometry.isInRange(enemy,this);
		enemy.hit(this);
		Writer.synchronexit();		
		return enemy;
	}
	
	
	
	public void wantToUpgrade(Player player){
		Writer.entry();
		player.chooseUpgrade(choosable);
		Writer.asynchronexit();		
	}

	
	

	public void upgrade(MagicRock magicRock){
		Writer.entry();
		Writer.asynchronexit();
	}
}

