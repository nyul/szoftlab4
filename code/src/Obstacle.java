import java.util.ArrayList;


public class Obstacle extends Tile{
	
	Enemy enemy;
	ArrayList<MagicRock> choosable;
	int slowingFactor = 0;
	
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
		player.chooseUpgrade(choosable);
		Writer.asynchronexit();		
	}
	
	public void upgrade(MagicRock magicRock){
		Writer.entry();
		Writer.asynchronexit();
	}

	public void slowMe(Enemy e){
		Writer.entry();
		e.increasePause(slowingFactor);
		Writer.asynchronexit();
	}
}
