
public class Source extends Road{
	
	public Source() {
		super();
	}
	
	public void requestDestination(Enemy e){
		Writer.entry();
		enemy.setRoad(this);
		Writer.asynchronexit();
	};

}
