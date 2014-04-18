import java.util.ArrayList;


public class Writer {
	
	private static ArrayList<String> writeText;

	public Writer() {
		writeText = new ArrayList<String>();
	}
	
	public void addString(String text) {
		writeText.add(text);
	}
}

