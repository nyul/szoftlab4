import java.util.Observable;
import java.util.Observer;

public class PlayerDraw implements Observer {
	
	private int magic;
	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg instanceof Integer) {
			magic = (int) arg;
			Graphics.text.append("Player magicPower has changed: " + magic + "\n");
		}
	}
}
