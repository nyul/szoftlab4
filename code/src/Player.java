import java.util.ArrayList;


public class Player {
	
	PlayingArea playingArea;
	
	public Player() {
		playingArea = null;
	}
	
	public void createObject() {
		playingArea = new PlayingArea();
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
