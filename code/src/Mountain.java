/**
 * 
 * A Vegzet-hegyet reprezentalja. Ha ellenseg all egy ilyen ut-csempen, akkor a jatek vereseggel veget er.
 *
 */
public class Mountain extends Road{
	
	public Mountain(Position pos) {
		super(pos);
		this.type = 5;
	}
	
	
	public void requestDestination(Enemy e){
		Writer.entry();
		
		Writer.asynchronexit();
	};
	
}
