
public class Tower extends Tile implements Defense{

	public Tower(char c, Position p) {
		super(c, p);
		// TODO Auto-generated constructor stub
	}
	
	public void attack(){
		System.out.println("attack() \n");
	}
	public void wantToUpgrade(){
		System.out.println("wantToUpgrade() \n");
	}
	
	public void upgrade(){
		System.out.println("upgrade() \n");
	}
}
