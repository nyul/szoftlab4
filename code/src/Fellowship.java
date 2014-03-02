import java.util.ArrayList;


public class Fellowship {
	private ArrayList<Wave> wave;
	private int number;
	private int deltaTime;
	
	public Fellowship(int n, int time) {
		wave = new ArrayList<Wave>();
		number = n;
		deltaTime = time;
	}
	
	public void addWave(Wave w) {
		if(isAddWave()) {
			wave.add(w);
		}
	}
	
	public boolean isAddWave() {
		if(wave.size() <= number) return true;
		else return false;
	}
	
	public void removeWave(Wave w) {
		wave.remove(w);
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getDeltaTime() {
		return deltaTime;
	}
	
}