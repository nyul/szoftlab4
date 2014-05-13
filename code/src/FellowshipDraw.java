import java.util.Observable;
import java.util.Observer;


public class FellowshipDraw implements Observer {

	/**
	 * Fellowship-ben levo valtozasokra reagal
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o instanceof Fellowship) {
			Fellowship fellow = (Fellowship)o;
			if(arg instanceof Integer) {
				int value = (Integer)arg;
				/**
				 * eletben levo ellensegek szamanak frissitese a feluleten
				 */
				GraphicsArea.alive.setText(Integer.toString(value));
			}
			/**
			 * ha lefutott a Fellowship kill() metodusa
			 */
			if(fellow.isKill()) {
				if(arg instanceof Hobbit) {
					/**
					 * toroljuk a feluletrol az elpusztult hobbitot
					 */
					Hobbit h = (Hobbit)arg;
					GraphicsArea.tile[h.getRoad().getPos().getX()][h.getRoad().getPos().getY()].remove(0);
					GraphicsArea.tile[h.getRoad().getPos().getX()][h.getRoad().getPos().getY()].repaint();
				}
				else if(arg instanceof Human) {
					/**
					 * toroljuk a feluletrol az elpusztult humant
					 */
					Human h = (Human)arg;
					GraphicsArea.tile[h.getRoad().getPos().getX()][h.getRoad().getPos().getY()].remove(0);
					GraphicsArea.tile[h.getRoad().getPos().getX()][h.getRoad().getPos().getY()].repaint();
				}
				else if(arg instanceof Dwarf) {
					/**
					 * toroljuk a feluletrol az elpusztult dwarfot
					 */
					Dwarf d = (Dwarf)arg;
					GraphicsArea.tile[d.getRoad().getPos().getX()][d.getRoad().getPos().getY()].remove(0);
					GraphicsArea.tile[d.getRoad().getPos().getX()][d.getRoad().getPos().getY()].repaint();
				}
				else if(arg instanceof Elf) {
					/**
					 * toroljuk a feluletrol az elpusztult elfet
					 */
					Elf elf = (Elf)arg;
					GraphicsArea.tile[elf.getRoad().getPos().getX()][elf.getRoad().getPos().getY()].remove(0);
					GraphicsArea.tile[elf.getRoad().getPos().getX()][elf.getRoad().getPos().getY()].repaint();
				}
				/**
				 * jelzes, hogy az ellenseg sikeresen eltunt a kepernyorol
				 */
				fellow.setKill(false);
			}
			/**
			 * ha loves soran duplikalodott az ellenseg
			 */
			if(fellow.isDuplicate()) {
				if(arg instanceof Hobbit) {
					/**
					 * ugyanarra a csempere klonozzuk az ellenseget, a regi moge teve
					 */
					Hobbit h = (Hobbit)arg;
					GraphicsArea.tile[h.getRoad().getPos().getX()][h.getRoad().getPos().getY()].add(h.picLabel, 1);
					GraphicsArea.tile[h.getRoad().getPos().getX()][h.getRoad().getPos().getY()].validate();
				}
				else if(arg instanceof Human) {
					/**
					 * ugyanarra a csempere klonozzuk az ellenseget, a regi moge teve
					 */
					Human h = (Human)arg;
					GraphicsArea.tile[h.getRoad().getPos().getX()][h.getRoad().getPos().getY()].add(h.picLabel, 1);
					GraphicsArea.tile[h.getRoad().getPos().getX()][h.getRoad().getPos().getY()].validate();
				}
				else if(arg instanceof Dwarf) {
					/**
					 * ugyanarra a csempere klonozzuk az ellenseget, a regi moge teve
					 */
					Dwarf d = (Dwarf)arg;
					GraphicsArea.tile[d.getRoad().getPos().getX()][d.getRoad().getPos().getY()].add(d.picLabel, 1);
					GraphicsArea.tile[d.getRoad().getPos().getX()][d.getRoad().getPos().getY()].validate();
				}
				else if(arg instanceof Elf) {
					/**
					 * ugyanarra a csempere klonozzuk az ellenseget, a regi moge teve
					 */
					Elf elf = (Elf)arg;
					GraphicsArea.tile[elf.getRoad().getPos().getX()][elf.getRoad().getPos().getY()].add(elf.picLabel, 1);
					GraphicsArea.tile[elf.getRoad().getPos().getX()][elf.getRoad().getPos().getY()].validate();
				}
				/**
				 * jelzes, hogy a klonozas sikeresen megjelent a feluleten
				 */
				fellow.setDuplicate(false);
			}
		}
	}
}
