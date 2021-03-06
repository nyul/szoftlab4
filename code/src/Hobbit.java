import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Ez egy hobbit tipusu ellenseg. Az kulonbozteti meg a tobbi ellensegtol, hogy a torony tuzelese soran a sebzes merteke fugg
 * a torony specialis kepessegetol. Ha az adott toronynak olyan specialis kepessege van, hogy egy hobbit ellenseget jobban sebez, mint
 *  a tobbi ellenseget es ha hobbit ellensegbol van a legtobb, akkor a palyan levo tornyokra erdemes olyan varazskovet tenni, hogy az 
 *  jobban sebezze a hobbit ellenseget, ezaltal hatekonyabb vedekezest biztositva.
 */
public class Hobbit extends Enemy{

	BufferedImage image = null;
	ImageIcon  icon = null;
	JLabel picLabel = null;
	/**
	 * A Hobbit grafikus megjelenitese miatt, a kep betoltese 
	 */
	public Hobbit() {
		super();
		try {
		    image = ImageIO.read(new File("img/hobbit.png"));
		    icon = new ImageIcon(image); 
			picLabel = new JLabel(icon);
		} catch (IOException e) {
			System.out.println("Sikertelen kep betoltes");
		}
	}
	/**
	 * A Hobbit grafikus megjelenitese miatt, a kep betoltese 
	 */
	public Hobbit(Road road) {
		super(road);
		try {
		    image = ImageIO.read(new File("img/hobbit.png"));
		    icon = new ImageIcon(image); 
			picLabel = new JLabel(icon);
		} catch (IOException e) {
			System.out.println("Sikertelen kep betoltes");
		}
	}
	
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * Torony tuzelese soran megsebzi a hobbit ellenseget.
	 */
	@Override
	public void lifePowerReduce(Tower t) {
		this.lifePower = this.lifePower - t.getDamagePowerHobbit();
	}
}
