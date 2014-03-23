
public class MagicRock {
	
	int type;
	int price;
	
	public MagicRock(){};
	
	public int getType(){
		Writer.entry();
		Writer.synchronexit();
		return type;
	};
	public int getPrice(){
		Writer.entry();
		Writer.synchronexit();
		return price;
	};
	public void setType(int type){
		Writer.entry();
		Writer.asynchronexit();
	};
	public void setPrice(int price){
		Writer.entry();
		Writer.asynchronexit();
	};
}
