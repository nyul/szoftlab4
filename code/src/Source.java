/**
 * 
 * Egy forras csempet reprezental. Az ellenseg a palyara helyezesekor egy ilyen tipusu csempere kerul.
 *
 */
public class Source extends Road{
	
	public Source(Position pos) {
		super(pos);
		this.type = 4;
	}
	
	public void requestDestination(Enemy e){
		Writer.entry();
		e.setRoad(this);
		Writer.asynchronexit();
	};

}
