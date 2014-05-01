import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
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


public class GraphicsArea {
	
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
				tile[i][j].setBackground(new Color(0, 170, 0));
				tile[i][j].setPreferredSize(new Dimension(50, 50));
				tile[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
				area.add(tile[i][j]);
			}
		}
	}
	
	public static void addImageToTile(int row, int column, Enemy e) {
		if(e instanceof Hobbit) {
			Hobbit h = (Hobbit) e;
			/*JLabel label = new JLabel();
			label.setIcon(h.getImage());
			tile[row][column].add(label);
			System.out.println("hello");*/
			ImagePanel impanel = new ImagePanel(h.getImage());
			tile[row][column].add(impanel);
		}
	}
	
	
	
	public static void addComponentsToPane(Container pane) {
        
        area = new JPanel();
        pane.add(area, BorderLayout.PAGE_START);
        
        stateBarBottom = new JPanel();
        pane.add(stateBarBottom, BorderLayout.PAGE_END);
        
        JPanel stateBarBottomLeft = new JPanel();
        stateBarBottomLeft.setLayout(new BorderLayout());
        
        JPanel textBarOne = new JPanel();
        textBarOne.setLayout(new BorderLayout());
        JLabel magicPower = new JLabel("magicPower: ");
        textBarOne.add(magicPower, BorderLayout.WEST);
        JTextField magic = new JTextField(3);
        magic.setBorder(BorderFactory.createEmptyBorder());
        magic.setEditable(false);
        magic.setText("100");
        textBarOne.add(magic, BorderLayout.EAST);
        
        JPanel textBarTwo = new JPanel();
        textBarTwo.setLayout(new BorderLayout());
        JLabel aliveEnemies = new JLabel("Alive enemies: ");
        textBarTwo.add(aliveEnemies, BorderLayout.WEST);
        JTextField alive = new JTextField(3);
        alive.setEditable(false);
        alive.setBorder(BorderFactory.createEmptyBorder());
        alive.setText("20");
        textBarTwo.add(alive, BorderLayout.EAST);
        
        stateBarBottomLeft.add(textBarOne, BorderLayout.NORTH);
        stateBarBottomLeft.add(textBarTwo, BorderLayout.SOUTH);
        
        stateBarBottom.add(stateBarBottomLeft);
        
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
