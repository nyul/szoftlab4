
public class Tower extends Tile implements Defense{

	public Tower() {
		System.out.println("Tower() constructor");
	}
	
	public void attack() {
		System.out.println("attack(enemyList)");
	}
	public void wantToUpgrade(){
		System.out.println("wantToUpgrade(player)");
	}
	
	public void upgrade(){
		System.out.println("upgrade(magicRock)");
	}
}
