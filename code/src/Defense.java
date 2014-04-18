import java.util.ArrayList;

/**
 * Ez egy interfesz, amelyet ha egy osztaly meg akar valositani, akkor mind a 3 metodust kotelezo implementalni. Tehat ez egyfajta
 * szerzodes.
 */
public interface Defense {
	/**
	 * 
	 * @param e - az aktiv ellensegeket adja at
	 * @param geometry - a toronynak tudnia kell, hogy ki van a hatotavan belul, ezt pedig a geometry osztaly kozremukodesevel
	 * 					 tudja meghatarozni
	 * @return
	 */
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
