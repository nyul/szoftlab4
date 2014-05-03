import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;


public class GraphicsArea {
	
	public static JTextArea text;
	public static JPanel[][] tile;
	static JFrame frame;
	static JPanel area;
	static JPanel stateBarRight;
	static JPanel stateBarBottom;
	public static JTextField magic;
	static int row;
	static int column;
	static Main main;
	
	public static void tilesDraw(ArrayList<ArrayList<Tile>> tiles) {
		row = tiles.size();
		column = tiles.get(0).size();
		
		tile = new JPanel[row][column];
		area.setLayout(new GridLayout(row, column));
		
		for (int i = 0; i < row; i ++) { 
			for (int j = 0; j < column; j ++) { 
				
				tile[i][j] = new JPanel(); 
				tile[i][j].setLayout(new BorderLayout(0,0));
				tile[i][j].setBackground(new Color(0, 170, 0));
				tile[i][j].setPreferredSize(new Dimension(50, 50));
				tile[i][j].setBorder( new EmptyBorder( 0, 0, 0, 0 ) );
				tile[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
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
        pane.add(area, BorderLayout.LINE_START);
        
        stateBarRight = new JPanel();
        pane.add(stateBarRight,BorderLayout.LINE_END);
        
        stateBarBottom = new JPanel();
        pane.add(stateBarBottom, BorderLayout.PAGE_END);
        
        stateBarRight.setLayout(new BorderLayout());
        JPanel textBarThree = new JPanel();
        
        JPanel stateBarBottomLeft = new JPanel();
        stateBarBottomLeft.setLayout(new BorderLayout());
        
        JPanel textBarOne = new JPanel();
        textBarOne.setLayout(new BorderLayout());
        JLabel magicPower = new JLabel("magicPower: ");
        textBarOne.add(magicPower, BorderLayout.WEST);
        magic = new JTextField(3);
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
	
	public static void clickHandling(final ArrayList<ArrayList<Tile>> tiles) {
		for (int i = 0; i < row; i ++) { 
			for (int j = 0; j < column; j ++) {
				final int ii = i;
		        final int jj = j;
				tile[ii][jj].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if(tiles.get(ii).get(jj).getType() == 0) {
							String message = "Do you want to build a tower?";
							Object[] options = { "Yes", "No" };
							int number = JOptionPane.showOptionDialog(frame, message, "",
						            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
							if(number == JOptionPane.OK_OPTION) {
								Tower t = tiles.get(ii).get(jj).buildTower(main.getEngine().getPlayer());
								main.getEngine().getPlayer().getArea().isBuildable(t);
							}
							if(number == JOptionPane.NO_OPTION) {
								// close
							}
						}
						else if(tiles.get(ii).get(jj).getType() == 1) {
							String message = "Do you want to upgrade this tower?";
							Object[] options = { "Yes", "No" };
							int number = JOptionPane.showOptionDialog(frame, message, "",
						            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
							if(number == JOptionPane.OK_OPTION) {
								Tower t = (Tower) tiles.get(ii).get(jj);
								t.wantToUpgrade(main.getEngine().getPlayer());
							}
							if(number == JOptionPane.NO_OPTION) {
								// close
							}
						}
					}
				});	
			}
		}
	}
	
	public static void createAndShowGUI(ArrayList<ArrayList<Tile>> tiles) {
        
        frame = new JFrame("Tower defense");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        tilesDraw(tiles);
        clickHandling(tiles);
        frame.pack();
        frame.setVisible(true);
    }
	
	public static void main(String[] args) {
		main = new Main();
		main.draw();
		main.loadInputLanguage();
	}
}
