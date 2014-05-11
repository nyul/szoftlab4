import java.util.Observable;
import java.util.Observer;

public class EngineDraw implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof Engine) {
			Engine engine = (Engine) o;
			if (arg instanceof Boolean) {
				boolean value = (boolean)arg;
				
				if(engine.defeat() == value) {
					GraphicsArea.end = false;
				}				
				else if(engine.victory() == value) {
					GraphicsArea.end = true;
				}
				updateStatus();	
			}
			
	    }
	}
	
	public void updateStatus() {
		GraphicsArea.endGameMessage();
	}
}
