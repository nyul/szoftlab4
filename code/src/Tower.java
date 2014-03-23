import java.util.ArrayList;


public class Tower extends Tile implements Defense{
	
	private Geometry geometry;
	private Enemy enemy;
	private ArrayList<MagicRock> choosable;
	
	private int shootPeriod;
	private int range;
	private int damagePowerHuman;
	private int damagePowerHobbit;
	private int damagePowerDwarf;
	private int damagePowerElf;
	private ArrayList<MagicRock> magicRock;
	private int magicRockNumber;
	
	/**
	 * Tower konstruktor
	 */
	
	public Tower() {
		geometry = new Geometry();
	}
	
	/**
	 * Enemy konstruktor
	 */
	
	public Enemy attack(ArrayList<Enemy> enemies) {
		Writer.entry();
		geometry.isInRange(enemy,this);
		enemy.hit(this);
		Writer.synchronexit();		
		return enemy;
	}
	
	/**
	 * Enemy konstruktor
	 */
	
	public void wantToUpgrade(Player player){
		Writer.entry();
		player.chooseUpgrade(choosable);
		Writer.asynchronexit();		
	}
	
	/**
	 * Enemy konstruktor
	 */
	
	public void upgrade(MagicRock magicRock){
		Writer.entry();
		Writer.asynchronexit();
	}
	
	/**
	 * Setterek és Getterek
	 */
	
	public int getSootPeriod(){
		Writer.entry();
		Writer.synchronexit();
		return shootPeriod;
	}
	
	public void setSootPeriod(int sp){
		Writer.entry();
		shootPeriod = sp;
		Writer.asynchronexit();		
	}
	
	public int getRange(){
		Writer.entry();
		Writer.synchronexit();
		return range;
	}

	public void setRange(int r){
		Writer.entry();
		range = r;
		Writer.asynchronexit();		
	}
	
	public int getDamagePowerHuman(){
		Writer.entry();
		Writer.synchronexit();
		return damagePowerHuman;
	}

	public void setDamagePowerHuman(int p){
		Writer.entry();
		damagePowerHuman = p;
		Writer.asynchronexit();
	}
	
	public int getDamagePowerHobbit(){
		Writer.entry();
		Writer.synchronexit();
		return damagePowerHobbit;
	}

	public void setDamagePowerHobbit(int p){
		Writer.entry();
		damagePowerHobbit = p;
		Writer.asynchronexit();
	}
	
	public int getDamagePowerDwarf(){
		Writer.entry();
		Writer.synchronexit();
		return damagePowerDwarf;
	}

	public void setDamagePowerDwarf(int p){
		Writer.entry();
		damagePowerDwarf = p;
		Writer.asynchronexit();
	}
	
	public int getDamagePowerElf(){
		Writer.entry();
		Writer.synchronexit();
		return damagePowerElf;
	}

	public void setDamagePowerElf(int p){
		Writer.entry();
		damagePowerElf = p;
		Writer.asynchronexit();
	}
	
	public int getMagicRockNumber(){
		Writer.entry();
		Writer.synchronexit();
		return magicRockNumber;
	}
	
	public void setMagicRockNumber(int m){
		Writer.entry();
		magicRockNumber = m;
		Writer.asynchronexit();		
	}

}
