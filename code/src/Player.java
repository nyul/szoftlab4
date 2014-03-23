import java.util.ArrayList;


public class Player {
	
	PlayingArea playingArea;
	Obstacle obstacle;
	Tower tower;
	
	public Player() {
		playingArea = null;
		obstacle = null;
		tower = null;
	}
	
	public void createObject() {
		playingArea = new PlayingArea();
		obstacle = new Obstacle();
		tower = new Tower();
	}

	public void chooseUpgrade(ArrayList<MagicRock> magicRockList) {
		Writer.entry();
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
