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
	
	public Tower() {
		geometry = new Geometry();
	}
	
	public Enemy attack(ArrayList<Enemy> enemies) {
		Writer.entry();
		geometry.isInRange(enemy,this);
		enemy.hit(this);
		Writer.synchronexit();		
		return enemy;
	}
	public void wantToUpgrade(Player player){
		Writer.entry();
		player.chooseUpgrade(choosable);
		Writer.asynchronexit();		
	}
	
	public void upgrade(MagicRock magicRock){
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public int getSootPeriod(){
		Writer.entry();
		Writer.synchronexit();
		return shootPeriod;
	}
	
	public void setSootPeriod(int sp){
		Writer.entry();
		Writer.asynchronexit();
		shootPeriod = sp;
	}
	
	public int getRange(){
		Writer.entry();
		Writer.synchronexit();
		return range;
	}

	public void setRange(int r){
		Writer.entry();
		Writer.asynchronexit();
		range = r;
	}
	
	public int getDamagePowerHuman(){
		Writer.entry();
		Writer.synchronexit();
		return damagePowerHuman;
	}

	public void setDamagePowerHuman(int p){
		Writer.entry();
		Writer.asynchronexit();
		damagePowerHuman = p;
	}
	
	public int getDamagePowerHobbit(){
		Writer.entry();
		Writer.synchronexit();
		return damagePowerHobbit;
	}

	public void setDamagePowerHobbit(int p){
		Writer.entry();
		Writer.asynchronexit();
		damagePowerHobbit = p;
	}
	
	public int getDamagePowerDwarf(){
		Writer.entry();
		Writer.synchronexit();
		return damagePowerDwarf;
	}

	public void setDamagePowerDwarf(int p){
		Writer.entry();
		Writer.asynchronexit();
		damagePowerDwarf = p;
	}
	
	public int getDamagePowerElf(){
		Writer.entry();
		Writer.synchronexit();
		return damagePowerElf;
	}

	public void setDamagePowerElf(int p){
		Writer.entry();
		Writer.asynchronexit();
		damagePowerElf = p;
	}
	
	public int getMagicRockNumber(){
		Writer.entry();
		Writer.synchronexit();
		return magicRockNumber;
	}
	
	public void setMagicRockNumber(int m){
		Writer.entry();
		Writer.asynchronexit();
		magicRockNumber = m;
	}

}
