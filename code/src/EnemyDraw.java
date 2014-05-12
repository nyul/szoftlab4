import java.awt.Component;
import java.util.Observable;
import java.util.Observer;



public class EnemyDraw implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		
		if(o instanceof Hobbit) {
			System.out.print(((Hobbit) o).getMyId());
			Hobbit hobbit = (Hobbit) o;
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
		else if(o instanceof Human) {
			Human human = (Human) o;
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
		
		else if(o instanceof Elf) {
			Elf elf = (Elf) o;
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
		
		else if(o instanceof Dwarf) {
			Dwarf dwarf = (Dwarf) o;
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
