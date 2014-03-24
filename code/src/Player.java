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
	
	/**
	 * Egy listaban megkapja a jatekos, hogy egy toronyra vagy akadalyra milyen varazskoveket lehet rakni.
	 * @param magicRockList
	 * @param defense
	 */
	public void chooseUpgrade(ArrayList<MagicRock> magicRockList, Defense defense) {
		Writer.entry();
		MagicRock magicRock = null;
		defense.upgrade(magicRock);
		Writer.asynchronexit();
	}
	
	/**
	 * Jatekos elinditja a jatekot, ezzel egyutt inicializalodik a palya.
	 */
	public void startGame() {
		Writer.entry();
		playingArea.initialize();
		Writer.asynchronexit();
	}
	
	/**
	 * Jatekos eleterejet csokkenti.
	 * @param price: megadja, hogy mennyivel csokkenti
	 */
	public void reduceMagicPower(int price) {
		Writer.entry();
		Writer.asynchronexit();
	}
	
}
