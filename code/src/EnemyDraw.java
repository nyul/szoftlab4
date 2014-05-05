import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class EnemyDraw implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o instanceof Hobbit) {
			Hobbit hobbit = (Hobbit) o;
			if (arg instanceof Road) {
				Road road = (Road)arg;
				ImageIcon  icon = new ImageIcon(hobbit.getImage()); 
				JLabel picLabel = new JLabel(icon);								 
				GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(picLabel);
				GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].validate();
			}
	    }
	}

}
