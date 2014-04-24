import java.util.ArrayList;

/**
 * 
 * Egy varazskovet reprezental. A jatekos egy ilyet hasznal fel, mikor tornyot vagy akadalyt fejleszt.
 *
 */
public class MagicRock {
	
	/**
	 *  0 - tower range upgrade
	 *  1 - tower shootPeriod upgrade
	 *	2 - tower damagePowerHuman upgrade
	 *  3 - tower damagePowerHobbit upgrade
	 *  4 - tower damagePowerDwarf upgrade
	 *  5 - tower damagePowerElf upgrade
	 *  6 - obstacle slowingFactor upgrade
	 */
	/**
	 * type - varazsko tipusat tarolja
	 * price - varazsko arat tarolja
	 * name - varazsko tipusanak nevet tarolja ugy, hogy lista i-dik eleme a varazsko i-dik tipusa
	 */
	private int type;
	private int price;
	public static ArrayList<String> name = new ArrayList<String>();
	static {
		name.add("range upgrade");
		name.add("shootPeriod upgrade");
		name.add("damagePowerHuman upgrade");
		name.add("damagePowerHobbit upgrade");
		name.add("damagePowerDwarf upgrade");
		name.add("damagePowerElf upgrade");
		name.add("slowingFactor upgrade");
	}
	/**
	 * konstruktor
	 * @param type
	 */
	public MagicRock(int type) {
		this.type = type;
		this.price = 10;
	}

	public int getType() {
		return type;
	}
	
	public int getPrice() {
		return price;
	}
	
}
