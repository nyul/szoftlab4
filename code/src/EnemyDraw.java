import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class EnemyDraw implements Observer {

	//Road previousRoad[] = new Road[2];  // elozo es aktualis utat tarolja
	//int counter = 0;
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o instanceof Hobbit) {
			Hobbit hobbit = (Hobbit) o;
			System.out.println(hobbit.getMyId());
			if (arg instanceof Road) {
				Road road = (Road)arg;
				//previousRoad[counter] = road;
				
				//fullNumber++;
				// elozo pozicio torlese
				/*if(fullNumber % 2 == 0 && fullNumber > 1) {
					GraphicsArea.tile[previousRoad[0].getPos().getX()][previousRoad[0].getPos().getY()].remove(0);
					GraphicsArea.tile[previousRoad[0].getPos().getX()][previousRoad[0].getPos().getY()].repaint();;
				}
				else if(fullNumber % 2 == 1 && fullNumber > 1) {
					GraphicsArea.tile[previousRoad[1].getPos().getX()][previousRoad[1].getPos().getY()].remove(0);
					GraphicsArea.tile[previousRoad[1].getPos().getX()][previousRoad[1].getPos().getY()].repaint();
				}*/
				if(hobbit.getPreviousRoad() != null) {
					GraphicsArea.tile[hobbit.getPreviousRoad().getPos().getX()][hobbit.getPreviousRoad().getPos().getY()].remove(0);
					GraphicsArea.tile[hobbit.getPreviousRoad().getPos().getX()][hobbit.getPreviousRoad().getPos().getY()].repaint();
				}
						
				ImageIcon  icon = new ImageIcon(hobbit.getImage()); 
				JLabel picLabel = new JLabel(icon);						
				GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(picLabel, 0);
				GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].validate();
				
				/*counter++;
				if(counter > 1) {
					counter = 0;
				}*/
			}
	    }
	}

}
