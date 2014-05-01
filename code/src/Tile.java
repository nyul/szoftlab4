
public class Tile {
	/**
	 * pos - csempe pozicioja
	 * type - csempe tipusa
	 */
	protected Position pos;
	protected int type;
	
	public Tile(Position p) {
		this.pos = p;
		this.type = 0;
	}
	
	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos){
		this.pos = pos;
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
		if(player.getMagicPower() >= Tower.price) {   // van-e eleg varazsero
			if(this.type == 0) {   // ures csempe
				Tower twr = new Tower(pos); 
				player.reduceMagicPower(Tower.price);
				return twr;
			} else {
				Writer.writeText.add("Error: Tower building failed-unbuildable area");
			}
		}
		else {
			Writer.writeText.add("Error: Tower building failed-you have not enough magicpower");
		}
		return null;
	}

	/**
	 * Egy akadalyt epit erre a csempere, ha a jatekosnak van eleg varazsereje.
	 * @param p
	 * @return
	 */
	public Obstacle buildObstacle(Player player) {
		if(player.getMagicPower() >= Obstacle.price) {   // van eleg varazsero
			if(this.type == 2) {   // csak ut-csempere lehet lerakni
				Obstacle obst = new Obstacle(pos); 
				player.reduceMagicPower(Obstacle.price);
				return obst;
			} else {
				Writer.writeText.add("Error: Obstacle building failed-unbuildable area");
			}
		}
		else {
			Writer.writeText.add("Error: Obstacle building failed-you have not enough magicpower");
		}
		return null;
	}
}
