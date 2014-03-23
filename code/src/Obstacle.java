import java.util.ArrayList;


public class Obstacle extends Tile{
	
	private int slowingFactor;
	private ArrayList<MagicRock> choosable;
	private int magicRockNumber;
	private Geometry geometry;
	private Enemy enemy;
	
	public Obstacle(Position pos) {
		super(pos);
		slowingFactor = 0;
		magicRockNumber = 0;
		geometry = new Geometry();
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

	public void slowMe(Enemy e){
		Writer.entry();
		Writer.asynchronexit();
	}
}
