import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * TowerDraw osztaly ami a torony kirajzoltatasaert felelos.
 * Implementalja az Observer interfeszt, ami a
 * kirajzolasert felelos osztalyt ertesiti ha
 * valtozas tortenik, es akkor ujrarajzolas kovetkezik.
 */
public class TowerDraw implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		// vizsgalja, hogy a parameterul kapott
		// objektum egy torony-e
		if(o instanceof Tower) {
			Tower tower = (Tower)o;
			if(arg instanceof Integer) {
				if(tower.isFogOn()) {
					// ha kod van
					BufferedImage img;
					try {
						// kep betoltese
						img = ImageIO.read(new File("img/fog.png"));
						ImageIcon  icon = new ImageIcon(img); 
						JLabel picLabel = new JLabel(icon);								 
						GraphicsArea.tile[tower.getPos().getX()][tower.getPos().getY()].add(picLabel, 0);
						GraphicsArea.tile[tower.getPos().getX()][tower.getPos().getY()].validate();
					} catch (IOException e) {
						// kivetelek kezelese
						e.printStackTrace();
					}
					// a kodot kikapcsolja
					tower.setFogOn(false);
				}
				else if(tower.isFogOff()) {
					GraphicsArea.tile[tower.getPos().getX()][tower.getPos().getY()].remove(0);
					GraphicsArea.tile[tower.getPos().getX()][tower.getPos().getY()].repaint();
					tower.setFogOff(false);
				}
			}
		}
	}

}
