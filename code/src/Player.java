import java.util.ArrayList;


public class Player {
	
	PlayingArea playingArea;
	Obstacle obstacle;
	Tower tower;
	Tile tile;
	
	public Player() {
		playingArea = null;
		obstacle = null;
		tower = null;
		tile = null;
	}
	
	public void createObject() {
		playingArea = new PlayingArea();
		obstacle = new Obstacle();
		tower = new Tower();
		tile = new Tile();
	}

	public void chooseUpgrade(ArrayList<MagicRock> magicRockList, Defense defense) {
		Writer.entry();
		MagicRock magicRock = null;
		defense.upgrade(magicRock);
		Writer.asynchronexit();
	}
		
	public void startGame() {
		Writer.entry();
		playingArea.initialize();
		Writer.asynchronexit();
	}
	
	public void reduceMagicPower(int price) {
		Writer.entry();
		Writer.asynchronexit();
	}
	
}
