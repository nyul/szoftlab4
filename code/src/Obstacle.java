import java.util.ArrayList;


public class Obstacle extends Tile implements Defense{
	
	Enemy enemy;
	ArrayList<MagicRock> choosable;
	
	public Obstacle() {
		enemy = null;
		choosable = null;
	}
	
	public void createObject() {
		enemy = new Human();
		choosable = new ArrayList<MagicRock>();
	}
	
	public Enemy attack(ArrayList<Enemy> enemies) {
		Writer.entry();
		Writer.synchronexit();		
		return enemy;
	}
	public void wantToUpgrade(Player player){
		Writer.entry();
		player.chooseUpgrade(choosable,this);
		Writer.asynchronexit();		
	}
	
	public void upgrade(MagicRock magicRock){
		Writer.entry();
		Writer.asynchronexit();
	}

	public void slowMe(Enemy e){
		Writer.entry();
		enemy.increasePause(0);
		Writer.asynchronexit();
	}
}
