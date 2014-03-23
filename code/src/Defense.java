import java.util.Collection;


public interface Defense {

	public void attack(Collection<Enemy> c);
	public void wantToUpgrade(Player p);
	public void upgrade(MagicRock mr);
}
