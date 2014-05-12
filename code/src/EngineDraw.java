import java.util.Observable;
import java.util.Observer;

public class EngineDraw implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof Engine) {
			if(arg instanceof Player) {
				updateVictory(o, arg);
			}
			else if(arg instanceof Fellowship) {
				updateDefeat(o, arg);
			}
			updateStatus();
	    }
	}
	
	public void updateVictory(Observable o, Object arg) {
		GraphicsArea.end = false;
	}
	
	public void updateDefeat(Observable o, Object arg) {
		GraphicsArea.end = true;
	}
	
	public void updateStatus() {
		GraphicsArea.endGameMessage();
	}
}
