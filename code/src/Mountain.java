
public class Mountain extends Road{

	public Mountain(Position pos) {
		super(pos);
		System.out.println("Mountain() constructor");
	}
	
	public void requestDestination(){
		System.out.println("requestDestination(enemy)");
	};
	
}
