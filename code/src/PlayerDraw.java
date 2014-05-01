import java.util.Observable;
import java.util.Observer;

public class PlayerDraw implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof Player) {
			Player player = (Player) o;
			if (arg instanceof Integer) {
				int value = (int)arg;
				if(value == player.getMagicPower()) {
					updateMagicPower(value);
				}
			}
	    }
	}
	
	public void updateMagicPower(int value) {
		GraphicsArea.magic.setText(Integer.toString(value));
	}
}
