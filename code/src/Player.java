import java.util.ArrayList;


public class Player {
	
	PlayingArea playingArea;
	
	int magicPower;
	
	public Player(int magicPower) {
		playingArea = null;
		this.magicPower = magicPower;
	}

	public void chooseUpgrade(ArrayList<MagicRock> magicRockList) {
		Writer.entry();
		Writer.exit();
	}
		
	public void startGame() {
		Writer.entry();
		playingArea = new PlayingArea();
		playingArea.initialize();
		Writer.exit();
	}
	
	public void reduceMagicPower(int price) {
		Writer.entry();
		Writer.exit();
	}
	
}
