
public class Source extends Road{
	
	public Source() {
		super();
	}
	
	public void requestDestination(Enemy e){
		Writer.entry();
		e.setRoad(this);
		Writer.asynchronexit();
	};

}
