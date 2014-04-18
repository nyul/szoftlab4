import java.util.ArrayList;


public interface Defense {

	Enemy attack(ArrayList<Enemy> e, Geometry geometry);
	/**
	 * 
	 * @param p a player ezen keresztul szol
	 * hogy upgradelni akar valamit, es atadja magat
	 */
	void wantToUpgrade(Player p);
	
	/**
	 * fejlesztest vegzo fuggveny 
	 * @param m parameterkent a varazskovet kapja meg
	 * amivel a jatekos fejleszt
	 */
	void upgrade(MagicRock m);
}
