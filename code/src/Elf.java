import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Ez egy tunde tipusu ellenseg. Az kulonbozteti meg a tobbi ellensegtol, hogy a torony tuzelese soran a sebzes merteke fugg
 * a torony specialis kepessegetol. Ha az adott toronynak olyan specialis kepessege van, hogy egy tunde ellenseget jobban sebez, mint
 *  a tobbi ellenseget es ha tunde ellensegbol van a legtobb, akkor a palyan levo tornyokra erdemes olyan varazskovet tenni, hogy az 
 *  jobban sebezze a tunde ellenseget, ezaltal hatekonyabb vedekezest biztositva.
 */
public class Elf extends Enemy{
	
	BufferedImage image = null;
	ImageIcon  icon = null;
	JLabel picLabel = null;
	
	public Elf() {
		super();
		try {
		    image = ImageIO.read(new File("img/elf.png"));
		    icon = new ImageIcon(image); 
			picLabel = new JLabel(icon);
		} catch (IOException e) {
			System.out.println("Sikertelen kep betoltes");
		}
	}
	
	public Elf(Road road) {
		super(road);
		try {
		    image = ImageIO.read(new File("img/elf.png"));
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
	 * Torony tuzelese soran megsebzi a tunde ellenseget.
	 */
	@Override
	public void lifePowerReduce(Tower t) {
		this.lifePower = this.lifePower - t.getDamagePowerElf();
	}
}
