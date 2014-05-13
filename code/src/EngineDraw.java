import java.util.Observable;
import java.util.Observer;

/**
 * A gyozelem es vereseg felugro ablakok miatt van szukseg erre az osztalyra
 * Engine defeat() es victory() metodusainak meghivodasakor ertesitjuk az Obsevert,
 * vagyis ezt az osztalyt, hogy allapotvaltozas tortent, igy hozzuk a grafikus feluletet
 * osszhangba, az adott allapottal
 */
public class EngineDraw implements Observer {
	/**
	 * Engine notifyObservers() metodusanak hatasara hivokdik meg a fuggveny.
	 * Attol fuggoen, hogy milyen bemeneti parametert kapott a meghivasakor
	 * hivodik meg a flageket allito metodusok.
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof Engine) {
			if(arg instanceof Player) {
				updateVictory(o, arg);
			}
			else if(arg instanceof Fellowship) {
				updateDefeat(o, arg);
			}
			updateStatus();
	    }
	}
	/**
	 * Flag segitsegevel allitjuk be, hogy a grafikus feluleten, majd
	 * melyik informacios uzenet jelenjen meg. Gyozelem eseten erteke a flagnek false.
	 */
	public void updateVictory(Observable o, Object arg) {
		GraphicsArea.end = false;
	}
	/**
	 * Flag segitsegevel allitjuk be, hogy a grafikus feluleten, majd
	 * melyik informacios uzenet jelenjen meg. Vereseg eseten az erteke a flagnek true.
	 */
	public void updateDefeat(Observable o, Object arg) {
		GraphicsArea.end = true;
	}
	/**
	 * Ez a fuggveny hivja meg a tenylegesen kirajzolo fuggvenyt.
	 */
	public void updateStatus() {
		GraphicsArea.endGameMessage();
	}
}
