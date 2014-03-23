
public class MagicRock {
	
	private int type;
	private int price;
	
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
		this.type = type;
		Writer.asynchronexit();
	};
	public void setPrice(int price){
		Writer.entry();
		this.price = price;
		Writer.asynchronexit();
	};
}
