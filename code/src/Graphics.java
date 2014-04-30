import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


public class Graphics {
	
	public static JTextArea text;
	public static JPanel[][] tile;
	JFrame frame;
	static JPanel area;
	static JPanel stateBarRight;
	static JPanel stateBarBottom;
	
	public static void tilesDraw(ArrayList<ArrayList<Tile>> tiles) {
		int row = tiles.size();
		int column = tiles.get(0).size();
		
		tile = new JPanel[row][column];
		area.setLayout(new GridLayout(row, column));
		
		for (int i = 0; i < row; i ++) { 
			for (int j = 0; j < column; j ++) { 

				tile[i][j] = new JPanel(); 
				tile[i][j].setBackground(new Color(0, 200, 0));
				tile[i][j].setPreferredSize(new Dimension(50, 50));
				tile[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
				area.add(tile[i][j]);
			}
		}
	}
	
	public static void addComponentsToPane(Container pane) {
        if (!(pane.getLayout() instanceof BorderLayout)) {
            pane.add(new JLabel("Container doesn't use BorderLayout!"));
            return;
        }
        
        area = new JPanel();
        pane.add(area, BorderLayout.PAGE_START);
        
        stateBarBottom = new JPanel();
        pane.add(stateBarBottom, BorderLayout.PAGE_END);
        
        JLabel magicPower = new JLabel("magicPower: ");
        stateBarBottom.add(magicPower);
        JTextField magic = new JTextField(3);
        magic.setEditable(false);
        magic.setText("100");
        stateBarBottom.add(magic);
        
        JLabel aliveEnemies = new JLabel("Alive Enemies: ");
        stateBarBottom.add(aliveEnemies);
        JTextField alive = new JTextField(3);
        alive.setEditable(false);
        alive.setText("20");
        stateBarBottom.add(alive);
        
        JTextArea stateConsole = new JTextArea(5, 30);
        stateConsole.setEditable(false);
        
        JScrollPane scroller = new JScrollPane(stateConsole);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        stateBarBottom.add(stateConsole);
	}
	
	public static void createAndShowGUI(ArrayList<ArrayList<Tile>> tiles) {
        
        JFrame frame = new JFrame("Tower defense");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        tilesDraw(tiles);
        frame.pack();
        frame.setVisible(true);
    }
}
