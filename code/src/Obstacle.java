
public class Obstacle extends Tile{
	
	public Obstacle() {
		System.out.println("Obstacle() constructor");
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

	public void slowMe(){
		System.out.println("slowMe(enemy)");
	}
}
