
public abstract class Enemy {

	/**
	 * A param�terk�nt kapott poz�ci�ra l�pteti az ellens�get.
	 * 
	 * @param p A l�ptet�s c�lpoz�ci�ja
	 */

	public void move() {
		Writer.entry();	
		Writer.asynchronexit();
	}
	


	/**
	 * A param�terlist�n kapott toronyt�l leolvasott,
	 * erre az ellens�g t�pusra vonatkoz� sebz�s �rt�ket
	 * levonja az aktu�lis �leter�b�l.
	 * 
	 * @param t A torony amelyik �ppen l� erre az ellens�gre
	 */
	
	public abstract void lifePowerReduce(Tower t);

	public void goToSource(int pause){
		Writer.entry();
		Writer.asynchronexit();
	}


	public void increasePause(int slowingFactor){
		Writer.entry();
		Writer.asynchronexit();
	}		


	public int hit(Tower t){
		Writer.entry();
		Writer.synchronexit();
		return 0;
	}
	
	public void setActivity(boolean a) {
		Writer.entry();
		Writer.asynchronexit();
	}

}
