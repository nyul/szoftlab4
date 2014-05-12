import java.util.Observable;
import java.util.Observer;


public class FellowshipDraw implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o instanceof Fellowship) {
			Fellowship fellow = (Fellowship)o;
			if(arg instanceof Integer) {
				int value = (Integer)arg;
				GraphicsArea.alive.setText(Integer.toString(value));
			}
			if(fellow.isKill()) {
				if(arg instanceof Hobbit) {
					Hobbit h = (Hobbit)arg;
					GraphicsArea.tile[h.getRoad().getPos().getX()][h.getRoad().getPos().getY()].remove(0);
					GraphicsArea.tile[h.getRoad().getPos().getX()][h.getRoad().getPos().getY()].repaint();
				}
				else if(arg instanceof Human) {
					Human h = (Human)arg;
					GraphicsArea.tile[h.getRoad().getPos().getX()][h.getRoad().getPos().getY()].remove(0);
					GraphicsArea.tile[h.getRoad().getPos().getX()][h.getRoad().getPos().getY()].repaint();
				}
				else if(arg instanceof Dwarf) {
					Dwarf d = (Dwarf)arg;
					GraphicsArea.tile[d.getRoad().getPos().getX()][d.getRoad().getPos().getY()].remove(0);
					GraphicsArea.tile[d.getRoad().getPos().getX()][d.getRoad().getPos().getY()].repaint();
				}
				else if(arg instanceof Elf) {
					Elf elf = (Elf)arg;
					GraphicsArea.tile[elf.getRoad().getPos().getX()][elf.getRoad().getPos().getY()].remove(0);
					GraphicsArea.tile[elf.getRoad().getPos().getX()][elf.getRoad().getPos().getY()].repaint();
				}
				fellow.setKill(false);
			}
		}
	}
}
