import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Ez egy ember tipusu ellenseg. Az kulonbozteti meg a tobbi ellensegtol, hogy a torony tuzelese soran a sebzes merteke fugg
 * a torony specialis kepessegetol. Ha az adott toronynak olyan specialis kepessege van, hogy egy ember ellenseget jobban sebez, mint
 *  a tobbi ellenseget es ha ember ellensegbol van a legtobb, akkor a palyan levo tornyokra erdemes olyan varazskovet tenni, hogy az 
 *  jobban sebezze az emebr ellenseget, ezaltal hatekonyabb vedekezest biztositva.
 */
public class Human extends Enemy{
	
	BufferedImage image = null;
	ImageIcon  icon = null;
	JLabel picLabel = null;
	
	public Human() {
		super();
		try {
		    image = ImageIO.read(new File("img/human.png"));
		    icon = new ImageIcon(image); 
			picLabel = new JLabel(icon);
		} catch (IOException e) {
			System.out.println("Sikertelen kep betoltes");
		}
	}
	
	public Human(Road road) {
		super(road);
		try {
		    image = ImageIO.read(new File("img/human.png"));
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
	 * Torony tuzelese soran megsebzi az ember ellenseget.
	 */
	@Override
	public void lifePowerReduce(Tower t) {
		this.lifePower = this.lifePower - t.getDamagePowerHuman();
	}
}
