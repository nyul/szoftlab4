
public class Player {
	private int magicPower;
	private int magicRockPrice;
	private PlayingArea area;
	
	public Player(int number) {
		magicPower = number;
		magicRockPrice = 25;
	}
	
	public Tower buildTower(Tile t) {
		if(isBuildTower(t)) {
			if(magicPower > 10) {
				Tower tw =  new Tower(t.getType(), t.getPos());
				System.out.println("The tower has successfully been putting off.");
				magicPower = magicPower - tw.getPrice();
				return tw;
			}
			else {
				System.out.println("No more magicPower.");
				return null;
			}
		}
		System.out.println("This tile can not be built.");
		return null;
	}
	
	public Obstacle buildObstacle(Tile t) {
		if(isBuildObstacle(t)) {
			if(magicPower > 10) {
				Obstacle o = new Obstacle(t.getType(), t.getPos());
				System.out.println("The obstacle has successfully been putting off.");
				magicPower = magicPower - o.getPrice();
				return o;
			}
			else {
				System.out.println("No more magicPower.");
				return null;
			}
		}
		return null;
	}
	
	public boolean isBuildTower(Tile t) {
		if(t.getType() == '0') return true;
		else return false;
	}
	
	public boolean isBuildObstacle(Tile t) {
		if(t.getType() == '1') return true;
		else return false;
	}
	
	public void buyMagicRock(Tower t, int number) {
		if(isBuyingMagicRock()) {
			if(number == 0 || number == 1 || number == 2 || number == 3 || number == 4 || number == 5) {
				t.setMagicRockNumber(t.getMagicRockNumber() + 1);
				magicPower = magicPower - magicRockPrice;
			}
			switch(number) {
				case 0: t.setDamagePowerHuman(20 + t.getDamagePowerHuman());
						break;
				case 1: t.setDamagePowerHobbit(20 + t.getDamagePowerHobbit());
						break;
				case 2: t.setDamagePowerDwarf(20 + t.getDamagePowerDwarf());
						break;
				case 3: t.setDamagePowerElf(20 + t.getDamagePowerElf());
						break;
				case 4: t.setDistance(2);
						break;
				case 5: t.setShootPeriod(2);
						break;
				default: System.out.println("Rossz erteket adtal meg, ezert a varazsko elhelyezese sikertelen.");
						 break;	
			}
		}
		
	}
	
	public void buyMagicRock(Obstacle o, int number) {
		if(isBuyingMagicRock()) {
			if(number == 6) {
				o.setSlowingFactor(2 * o.getSlowingFactor());
				o.setMagicRockNumber(o.getMagicRockNumber() + 1);
				magicPower = magicPower - magicRockPrice;
			}
			else System.out.println("Rossz erteket adtal meg, ezert a varazsko elhelyezese sikertelen.");
		}
	}
	
	public boolean isBuyingMagicRock() {
		if(magicPower > 10) return true;
		else return false;
	}
	
	public void startGame() {
		area = new PlayingArea();
		area.initialize();
	}
	
	public int getMagicPower() {
		return magicPower;
	}
	
	public void setMagicPower(int number) {
		magicPower = number;
	}
	
	public PlayingArea getPlayingArea() {
		return area;
	}
}
