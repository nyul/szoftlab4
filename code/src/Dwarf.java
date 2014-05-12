import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Ez egy torpe tipusu ellenseg. Az kulonbozteti meg a tobbi ellensegtol, 
 * hogy a torony tuzelese soran a sebzes merteke fugg
 * a torony specialis kepessegetol. Ha az adott toronynak olyan specialis kepessege van, 
 * hogy egy torpe ellenseget jobban sebez, mint
 * a tobbi ellenseget es ha torpe ellensegbol van a legtobb, 
 * akkor a palyan levo tornyokra erdemes olyan varazskovet tenni, hogy az 
 * jobban sebezze a torpe ellenseget, ezaltal hatekonyabb vedekezest biztositva.
 */
public class Dwarf extends Enemy{

	BufferedImage image = null;
	ImageIcon  icon = null;
	JLabel picLabel = null;
	
	public Dwarf() {
		super();
		try {
		    image = ImageIO.read(new File("img/dwarf.png"));
		    icon = new ImageIcon(image); 
			picLabel = new JLabel(icon);
		} catch (IOException e) {
			System.out.println("Sikertelen kep betoltes");
		}
	}
	
	public BufferedImage getImage() {
		return image;
	}

	
	public Dwarf(Road road) {
		super(road);
		try {
		    image = ImageIO.read(new File("img/dwarf.png"));
		    icon = new ImageIcon(image); 
			picLabel = new JLabel(icon);
		} catch (IOException e) {
			System.out.println("Sikertelen kep betoltes");
		}
	}
	/**
	 * Torony tuzelese soran megsebzi a torpe ellenseget.
	 */
	@Override
	public void lifePowerReduce(Tower t) {
		System.out.println("Dwarf before:" + this.lifePower);
		this.lifePower = this.lifePower - t.getDamagePowerDwarf();
		System.out.println("Dwarf after:" + this.lifePower);
	}
}
