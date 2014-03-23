import java.util.ArrayList;


public class Player {
	
	private PlayingArea playingArea;

	public void chooseUpgrade(ArrayList<MagicRock> magicRockList) {
		Writer.entry();
		Writer.asynchronexit();
	}
		
	public void startGame() {
		Writer.entry();
		playingArea = new PlayingArea();
		playingArea.initialize();
		Writer.asynchronexit();
	}
	
	public void reduceMagicPower(int price) {
		Writer.entry();
		Writer.asynchronexit();
	}
	
}
