import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


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
							BufferedImage img;
							try {
								img = ImageIO.read(new File("img/road.png"));
								ImageIcon  icon = new ImageIcon(img); 
								JLabel picLabel = new JLabel(icon);								 
								GraphicsArea.tile[i][j].add(picLabel);
								GraphicsArea.tile[i][j].validate();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
						}
						}
					}
				}
			}
			else if(arg instanceof Obstacle) {
				Obstacle obst = (Obstacle)arg;
				for(int i = 0; i < geo.getTiles().size(); i++) {
					for(int j = 0; j < geo.getTiles().get(i).size(); j++) {
						if(geo.getTiles().get(i).get(j).getPos().getX() == obst.getPos().getX() && geo.getTiles().get(i).get(j).getPos().getY() == obst.getPos().getY()) {
							BufferedImage img;
							try {
								img = ImageIO.read(new File("img/obstacle.png"));
								ImageIcon  icon = new ImageIcon(img); 
								JLabel picLabel = new JLabel(icon);						 
								
								if(GraphicsArea.tile[i][j].getComponentCount() > 1){
									GraphicsArea.tile[i][j].remove(1);
									
									GraphicsArea.tile[i][j].add(picLabel, 1);
									GraphicsArea.tile[i][j].validate();
								} else {
									GraphicsArea.tile[i][j].add(picLabel, 0);
									GraphicsArea.tile[i][j].validate();
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
			else if(arg instanceof Tower) {
				Tower tow = (Tower)arg;
				for(int i = 0; i < geo.getTiles().size(); i++) {
					for(int j = 0; j < geo.getTiles().get(i).size(); j++) {
						if(geo.getTiles().get(i).get(j).getPos().getX() == tow.getPos().getX() && geo.getTiles().get(i).get(j).getPos().getY() == tow.getPos().getY()) {
							BufferedImage img;
							try {
								img = ImageIO.read(new File("img/tower.png"));
								ImageIcon  icon = new ImageIcon(img); 
								JLabel picLabel = new JLabel(icon);								 
								GraphicsArea.tile[i][j].add(picLabel);
								GraphicsArea.tile[i][j].validate();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
						}
					}
				}
			}
			else if(arg instanceof Source) {
				Source source = (Source)arg;
				for(int i = 0; i < geo.getTiles().size(); i++) {
					for(int j = 0; j < geo.getTiles().get(i).size(); j++) {
						if(geo.getTiles().get(i).get(j).getPos().getX() == source.getPos().getX() && geo.getTiles().get(i).get(j).getPos().getY() == source.getPos().getY()) {
							BufferedImage img;
							try {
								img = ImageIO.read(new File("img/source.png"));
								ImageIcon  icon = new ImageIcon(img); 
								JLabel picLabel = new JLabel(icon);								 
								GraphicsArea.tile[i][j].add(picLabel);
								GraphicsArea.tile[i][j].validate();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
			else if(arg instanceof Mountain) {
				Mountain moun = (Mountain)arg;
				for(int i = 0; i < geo.getTiles().size(); i++) {
					for(int j = 0; j < geo.getTiles().get(i).size(); j++) {
						if(geo.getTiles().get(i).get(j).getPos().getX() == moun.getPos().getX() && geo.getTiles().get(i).get(j).getPos().getY() == moun.getPos().getY()) {
							BufferedImage img;
							try {
								img = ImageIO.read(new File("img/mountain.png"));
								ImageIcon  icon = new ImageIcon(img); 
								JLabel picLabel = new JLabel(icon);								 
								GraphicsArea.tile[i][j].add(picLabel);
								GraphicsArea.tile[i][j].validate();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}		
			
		}
		
	}

}
