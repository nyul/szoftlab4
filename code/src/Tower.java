import java.util.ArrayList;


public class Tower extends Tile implements Defense{
	
	Geometry geometry;
	Enemy enemy;
	ArrayList<MagicRock> choosable;
	
	/**
	 * Tower konstruktor
	 */
	
	public Tower() {
		geometry = null;
		enemy = null;
		choosable = null;
	}
	
	/**
	 * szukseges objektumok letrehozasa
	 */
	
	public void createObject() {
		geometry = new Geometry();
		enemy = new Human();
		choosable = new ArrayList<MagicRock>();
	}
	
	/**
	 * A parameterul kapott enemy listara meghivja a tavolsag vizsgalatot, 
	 * majd az enemy hit metodusat
	 * ami csokkenti az enemy erejet
	 */
	
	public Enemy attack(ArrayList<Enemy> enemies) {
		Writer.entry();
		geometry.isInRange(enemy,this);
		enemy.hit(this);
		if(!Writer.question("Enemy eletereje nagyobb-e nullanal sebzes utan?")) {
			enemy.setActivity(false);
		}
		Writer.synchronexit();		
		return enemy;
	}
	
	/*
	 * (non-Javadoc)
	 * @see Defense#wantToUpgrade(Player)
	 */
	
	public void wantToUpgrade(Player player){
		Writer.entry();
		player.chooseUpgrade(choosable,this);
		Writer.asynchronexit();		
	}	
	
	/*
	 * (non-Javadoc)
	 * @see Defense#upgrade(MagicRock)
	 */
	public void upgrade(MagicRock magicRock){
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/*
	 * (non-Javadoc)
	 * @see Tile#setPos(Position)
	 */
	public void setPos(Position pos){
		Writer.entry();
		Writer.asynchronexit();
	};
}

