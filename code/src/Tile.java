
public class Tile {
	
	Position pos;
	
	public Tile() {
		pos = null;
	}
	
	public void createObject() {
		pos = new Position();
	}
	
	/**
	 * Egy tornyot epit erre a csempere, ha a jatekosnak van eleg varazsereje.
	 * @param p
	 * @return
	 */
	public Tower buildTower(Player p) {
		Writer.entry();
		createObject();
		Tower twr = new Tower(); 
		twr.setPos(pos);
		p.reduceMagicPower(0);
		Writer.synchronexit();
		return twr;
	}

	/**
	 * Egy akadalyt epit erre a csempere, ha a jatekosnak van eleg varazsereje.
	 * @param p
	 * @return
	 */
	public Obstacle buildObstacle(Player p) {
		Writer.entry();
		createObject();
		Obstacle obstacle = new Obstacle();
		obstacle.setPos(pos);
		p.reduceMagicPower(0);
		Writer.synchronexit();
		return obstacle;
	}

	/**
	 * ket pozicio kozotti tavolsagot adja meg
	 * @param p1
	 * @param p2
	 * @return
	 */
	public double distance(Position p1, Position p2) {
		Writer.entry();
		Writer.asynchronexit();
		return 0.0f;
	}
	
	public void setPos(Position pos){
		Writer.entry();
		Writer.asynchronexit();
	};
}
