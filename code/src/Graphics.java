import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class Graphics {
	
	public static JTextArea text;
	
	public void go() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		text = new JTextArea(10, 20);
		text.setLineWrap(true);
		
		JScrollPane scroller = new JScrollPane(text);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroller);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(350, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
