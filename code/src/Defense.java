import java.util.ArrayList;


public interface Defense {

	Enemy attack(ArrayList<Enemy> e);
	void wantToUpgrade(Player p);
	void upgrade(MagicRock m);
}
