import java.util.Observable;
import java.util.Observer;


public class GeometryDraw implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Geometry) {
			Geometry geo = (Geometry) o;
			if (arg instanceof Tile) {
				
			}
		}
		
	}

}
