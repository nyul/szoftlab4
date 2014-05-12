import java.util.Observable;
import java.util.Observer;


public class FellowshipDraw implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o instanceof Fellowship) {
			if(arg instanceof Integer) {
				int value = (Integer)arg;
				GraphicsArea.alive.setText(Integer.toString(value));
			}
		}
	}

}
