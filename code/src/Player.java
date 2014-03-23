import java.util.ArrayList;


public class Player {
	
	PlayingArea playingArea;
	Tile tile;
	
	public Player() {
		playingArea = null;
		tile = null;
	}
	
	public void createObject() {
		playingArea = new PlayingArea();
		tile = new Tile();
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
