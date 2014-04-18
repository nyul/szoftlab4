
public class Tile {
	
	protected Position pos;
	protected int type;
	
	public Tile(Position p) {
		pos = p;
		type = 0;
	}
	
	public Position getPos() {
		return pos;
	}

	public void setPos(Position p){
		pos = p;
	};
	
	

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	/**
	 * Egy tornyot epit erre a csempere, ha a jatekosnak van eleg varazsereje.
	 * @param p
	 * @return
	 */
	public Tower buildTower(Player player) {
		if(player.getMagicPower() > Tower.getPrice()) {   // van eleg varazsero
			if(this.type == 0) {   // ures csempe
				Tower twr = new Tower(pos); 
				player.reduceMagicPower(Tower.getPrice());
				return twr;
			} else {
				System.out.println("Error: Tower building failed-unbuildable area");
			}
		}
		else {
			System.out.println("Error: Tower building failed-you have not enough magicpower");
		}
		return null;
	}

	/**
	 * Egy akadalyt epit erre a csempere, ha a jatekosnak van eleg varazsereje.
	 * @param p
	 * @return
	 */
	public Obstacle buildObstacle(Player player) {
		if(player.getMagicPower() > Obstacle.getPrice()) {   // van eleg varazsero
			if(this.type == 2) {   // ures csempe
				Obstacle obst = new Obstacle(pos); 
				player.reduceMagicPower(Obstacle.getPrice());
				return obst;
			} else {
				System.out.println("Error: Obstacle building failed-unbuildable area");
			}
		}
		else {
			System.out.println("Error: Obstacle building failed-you have not enough magicpower");
		}
		return null;
	}
}
