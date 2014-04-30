import java.awt.Color;
import java.util.Observable;
import java.util.Observer;


public class GeometryDraw implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Geometry) {
			Geometry geo = (Geometry) o;
			if(arg instanceof Road && !(arg instanceof Obstacle) && !(arg instanceof Source) && !(arg instanceof Mountain)) {
				Road road = (Road)arg;
				for(int i = 0; i < geo.getTiles().size(); i++) {
					for(int j = 0; j < geo.getTiles().get(i).size(); j++) {
						if(geo.getTiles().get(i).get(j).getPos().getX() == road.getPos().getX() && geo.getTiles().get(i).get(j).getPos().getY() == road.getPos().getY()) {
							GraphicsArea.tile[i][j].setBackground(new Color(0, 0, 255));
						}
					}
				}
			}
			else if(arg instanceof Obstacle) {
				Obstacle obst = (Obstacle)arg;
				for(int i = 0; i < geo.getTiles().size(); i++) {
					for(int j = 0; j < geo.getTiles().get(i).size(); j++) {
						if(geo.getTiles().get(i).get(j).getPos().getX() == obst.getPos().getX() && geo.getTiles().get(i).get(j).getPos().getY() == obst.getPos().getY()) {
							GraphicsArea.tile[i][j].setBackground(new Color(255, 255, 0));
						}
					}
				}
			}
			else if(arg instanceof Tower) {
				Tower tow = (Tower)arg;
				for(int i = 0; i < geo.getTiles().size(); i++) {
					for(int j = 0; j < geo.getTiles().get(i).size(); j++) {
						if(geo.getTiles().get(i).get(j).getPos().getX() == tow.getPos().getX() && geo.getTiles().get(i).get(j).getPos().getY() == tow.getPos().getY()) {
							GraphicsArea.tile[i][j].setBackground(new Color(148, 0, 211));
						}
					}
				}
			}
			else if(arg instanceof Source) {
				Source source = (Source)arg;
				for(int i = 0; i < geo.getTiles().size(); i++) {
					for(int j = 0; j < geo.getTiles().get(i).size(); j++) {
						if(geo.getTiles().get(i).get(j).getPos().getX() == source.getPos().getX() && geo.getTiles().get(i).get(j).getPos().getY() == source.getPos().getY()) {
							GraphicsArea.tile[i][j].setBackground(new Color(0, 100, 255));
						}
					}
				}
			}
			else if(arg instanceof Mountain) {
				Mountain moun = (Mountain)arg;
				for(int i = 0; i < geo.getTiles().size(); i++) {
					for(int j = 0; j < geo.getTiles().get(i).size(); j++) {
						if(geo.getTiles().get(i).get(j).getPos().getX() == moun.getPos().getX() && geo.getTiles().get(i).get(j).getPos().getY() == moun.getPos().getY()) {
							GraphicsArea.tile[i][j].setBackground(new Color(255, 0, 0));
						}
					}
				}
			}
		}
		
	}

}
