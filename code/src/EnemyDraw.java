import java.awt.Component;
import java.util.Observable;
import java.util.Observer;


/**
 * Az ellenseg kirajzolasaert felelos osztaly.
 */
public class EnemyDraw implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		
		// Ha az parameterul kapott megfigyelheto objektum egy hobbit
		if(o instanceof Hobbit) {
			Hobbit hobbit = (Hobbit)o;
			if(hobbit.isSource) {
				if (arg instanceof Road) {
					Road road = (Road)arg;
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(hobbit.picLabel, 0);
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].validate();
					hobbit.setSource(false);
				}
			}
			else {
				if (arg instanceof Road) {
					Road road = (Road)arg;
							
					if(hobbit.getPreviousRoad() != null) {
						Component[] comp = GraphicsArea.tile[hobbit.getPreviousRoad().getPos().getX()][hobbit.getPreviousRoad().getPos().getY()].getComponents();
						for(int i = 0; i < comp.length; i++) {
							if(comp[i] == hobbit.picLabel) {
								GraphicsArea.tile[hobbit.getPreviousRoad().getPos().getX()][hobbit.getPreviousRoad().getPos().getY()].remove(i);
								GraphicsArea.tile[hobbit.getPreviousRoad().getPos().getX()][hobbit.getPreviousRoad().getPos().getY()].repaint();
							}
						}
					}
					
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(hobbit.picLabel, 0);
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].repaint();
				}
			}
	    }

		// Ha az parameterul kapott megfigyelheto objektum egy human
		else if(o instanceof Human) {
			Human human = (Human) o;
			if(human.isSource) {
				if (arg instanceof Road) {
					Road road = (Road)arg;
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(human.picLabel, 0);
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].validate();
					human.setSource(false);
				}
			}
			else {
				if (arg instanceof Road) {
					Road road = (Road)arg;
					
					if(human.getPreviousRoad() != null) {
						Component[] comp = GraphicsArea.tile[human.getPreviousRoad().getPos().getX()][human.getPreviousRoad().getPos().getY()].getComponents();
						for(int i = 0; i < comp.length; i++) {
							if(comp[i] == human.picLabel) {
								GraphicsArea.tile[human.getPreviousRoad().getPos().getX()][human.getPreviousRoad().getPos().getY()].remove(i);
								GraphicsArea.tile[human.getPreviousRoad().getPos().getX()][human.getPreviousRoad().getPos().getY()].repaint();
							}
						}
					}
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(human.picLabel, 0);
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].repaint();
				}
			}
	    }

		// Ha az parameterul kapott megfigyelheto objektum egy elf
		else if(o instanceof Elf) {
			Elf elf = (Elf) o;
			if(elf.isSource) {
				if (arg instanceof Road) {
					Road road = (Road)arg;
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(elf.picLabel, 0);
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].validate();
					elf.setSource(false);
				}
			}
			else {
				if (arg instanceof Road) {
					Road road = (Road)arg;
					
					if(elf.getPreviousRoad() != null) {
						Component[] comp = GraphicsArea.tile[elf.getPreviousRoad().getPos().getX()][elf.getPreviousRoad().getPos().getY()].getComponents();
						for(int i = 0; i < comp.length; i++) {
							if(comp[i] == elf.picLabel) {
								GraphicsArea.tile[elf.getPreviousRoad().getPos().getX()][elf.getPreviousRoad().getPos().getY()].remove(i);
								GraphicsArea.tile[elf.getPreviousRoad().getPos().getX()][elf.getPreviousRoad().getPos().getY()].repaint();
							}
						}
					}
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(elf.picLabel, 0);
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].repaint();
				}
			}
	    }

		// Ha az parameterul kapott megfigyelheto objektum egy dwarf
		else if(o instanceof Dwarf) {
			Dwarf dwarf = (Dwarf) o;
			if(dwarf.isSource) {
				if (arg instanceof Road) {
					Road road = (Road)arg;
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(dwarf.picLabel, 0);
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].validate();
					dwarf.setSource(false);
				}
			}
			else {
				if (arg instanceof Road) {
					Road road = (Road)arg;
					
					if(dwarf.getPreviousRoad() != null) {
						Component[] comp = GraphicsArea.tile[dwarf.getPreviousRoad().getPos().getX()][dwarf.getPreviousRoad().getPos().getY()].getComponents();
						for(int i = 0; i < comp.length; i++) {
							if(comp[i] == dwarf.picLabel) {
								GraphicsArea.tile[dwarf.getPreviousRoad().getPos().getX()][dwarf.getPreviousRoad().getPos().getY()].remove(i);
								GraphicsArea.tile[dwarf.getPreviousRoad().getPos().getX()][dwarf.getPreviousRoad().getPos().getY()].repaint();
							}
						}
					}
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(dwarf.picLabel, 0);
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].repaint();
				}
			}
	    }
	}

}
