/**
 * Ez egy ember tipusu ellenseg. Az kulonbozteti meg a tobbi ellensegtol, hogy a torony tuzelese soran a sebzes merteke fugg
 * a torony specialis kepessegetol. Ha az adott toronynak olyan specialis kepessege van, hogy egy ember ellenseget jobban sebez, mint
 *  a tobbi ellenseget es ha ember ellensegbol van a legtobb, akkor a palyan levo tornyokra erdemes olyan varazskovet tenni, hogy az 
 *  jobban sebezze az emebr ellenseget, ezaltal hatekonyabb vedekezest biztositva.
 */
public class Human extends Enemy{

	public Human() {
		super();
	}
	
	public Human(Road road) {
		super(road);
	}
	
	/**
	 * Torony tuzelese soran megsebzi az ember ellenseget.
	 */
	@Override
	public void lifePowerReduce(Tower t) {
		this.lifePower = this.lifePower - t.getDamagePowerHuman();
	}
}
