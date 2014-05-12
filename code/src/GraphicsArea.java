import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
	public static JTextField alive;
	static int row;
	static int column;
	static Main main;
	public static boolean end;
	
	/**
	 * Kirajzolja a csempeket a gridre
	 * @param tiles - a csempek arraylistje
	 */
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
	
	/**
	 * Letrehozza az ablakot es hozzaadja a menuket es a komponenseket
	 * @param pane - az ablak amihez az elemeket hozza a akarjuk adni
	 */
	public static void addComponentsToPane(Container pane) {
        
		JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem startItem = new JMenuItem("Start");
        startItem.setMnemonic(KeyEvent.VK_S);
        startItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	String message = "Please load a map!";
				String name = JOptionPane.showInputDialog(frame, message, null);
				
				if(name != null && name.startsWith("input") && name.endsWith(".txt")) {
					main.loadMap();
				}
            }
        });
	        
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_E);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        file.add(startItem);
        file.add(exitItem);

        menubar.add(file);

        frame.setJMenuBar(menubar);
		
		area = new JPanel();
        pane.add(area, BorderLayout.LINE_START);
        
        stateBarRight = new JPanel();
        pane.add(stateBarRight,BorderLayout.LINE_END);
        
        stateBarBottom = new JPanel();
        pane.add(stateBarBottom, BorderLayout.PAGE_END);
        
        stateBarRight.setLayout(new BorderLayout());
        
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
        alive = new JTextField(3);
        alive.setEditable(false);
        alive.setBorder(BorderFactory.createEmptyBorder());
        //alive.setText("20");
        textBarTwo.add(alive, BorderLayout.EAST);
        
        stateBarBottomLeft.add(textBarOne, BorderLayout.NORTH);
        stateBarBottomLeft.add(textBarTwo, BorderLayout.SOUTH);
        
        stateBarBottom.add(stateBarBottomLeft);
        
        JTextArea stateConsole = new JTextArea(5, 33);
        stateConsole.setBackground(new Color(200, 200, 200));
        stateConsole.setEditable(false);
        
        JScrollPane scroller = new JScrollPane(stateConsole);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        stateBarBottom.add(stateConsole);
	}
	
	/**
	 * Katintas kezelo metodus, a csempere kattintas esemenyre reagalo funkciok vannak itt megvalositva
	 * @param tiles - a csempek listaja
	 */
	public static void clickHandling(final ArrayList<ArrayList<Tile>> tiles) {
		for (int i = 0; i < row; i++) { 
			for (int j = 0; j < column; j++) {
				final int ii = i;
		        final int jj = j;
				tile[ii][jj].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						// Torony epitesenel fut le
						if(tiles.get(ii).get(jj).getType() == 0) {
							String message = "Do you want to build a tower?";
							Object[] options = { "Yes", "No" };
							int number = JOptionPane.showOptionDialog(frame, message, "",
						            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
							if(number == JOptionPane.OK_OPTION) {
								Tower tower = tiles.get(ii).get(jj).buildTower(main.getEngine().getPlayer());
								if(tower == null) {
									message = "You don't have enough magicpower.";
									JOptionPane.showMessageDialog(frame, "You don't have enough magicpower.", "Warning", JOptionPane.WARNING_MESSAGE);
								}
								main.getEngine().getPlayer().getArea().isBuildable(tower);
							}
							if(number == JOptionPane.NO_OPTION) {
								// close
							}
						}
							
						// Torony fejlesztesenel fut le
						else if(tiles.get(ii).get(jj).getType() == 1) {
								String message = "Do you want to upgrade this tower?";
								Object[] options = { "Yes", "No" };
								int number = JOptionPane.showOptionDialog(frame, message, "",
							            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
								if(number == JOptionPane.OK_OPTION && (main.getEngine().getPlayer().getMagicPower() >= 10)) {
									Tower t = (Tower) tiles.get(ii).get(jj);
									t.wantToUpgrade(main.getEngine().getPlayer());
								}
								if(main.getEngine().getPlayer().getMagicPower() < 10){
									message = "You don't have enough magicpower.";
									JOptionPane.showMessageDialog(frame, "You don't have enough magicpower.", "Warning", JOptionPane.WARNING_MESSAGE);
								}
								if(number == JOptionPane.NO_OPTION) {
									// close
								}
							}
							
						// Akadaly epitesenel fut le ez az ag
							else if(tiles.get(ii).get(jj).getType() == 2) {
								String message = "Do you want to build an obstacle?";
								Object[] options = { "Yes", "No" };
								int number = JOptionPane.showOptionDialog(frame, message, "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
								
								if(number == JOptionPane.OK_OPTION) {
									Obstacle obst = tiles.get(ii).get(jj).buildObstacle(main.getEngine().getPlayer());
									if(obst == null) { //Ha nincs eleg varazsero
										message = "You don't have enough magicpower.";
										JOptionPane.showMessageDialog(frame, "You don't have enough magicpower.", "Warning", JOptionPane.WARNING_MESSAGE);
									}
									else {
										for(int i = 0; i < main.getEngine().getPlayer().getArea().getRoad().size(); i++) {
											if(main.getEngine().getPlayer().getArea().getRoad().get(i).getPos().getX() == obst.getPos().getX() && main.getEngine().getPlayer().getArea().getRoad().get(i).getPos().getY() == obst.getPos().getY()) {
												System.out.println(main.getEngine().getPlayer().getArea().getRoad().get(i).getNextRoad().get(0).getPos().getY());
												main.getEngine().getPlayer().getArea().getObstacle().add(obst);
												main.getEngine().getPlayer().getArea().changeReferenceFrom(obst.getPos(), main.getEngine().getPlayer().getArea().getRoad().get(i).getNextRoad());
												main.getEngine().getPlayer().getArea().isBuildable(obst);
												main.getEngine().getPlayer().getArea().changeReferenceTo(main.getEngine().getPlayer().getArea().getRoad().get(i-1).getPos(), obst.getPos());
											}
										}
									}
									/*for(int i = 0; i < main.getEngine().getPlayer().getArea().getRoad().size(); i++) {
										if(main.getEngine().getPlayer().getArea().getRoad().get(i).getPos().getX() == 6 && main.getEngine().getPlayer().getArea().getRoad().get(i).getPos().getY() == 3) {
											for(int j = 0; j < main.getEngine().getPlayer().getArea().getRoad().get(i).getNextRoad().size(); j++) {
												System.out.println(main.getEngine().getPlayer().getArea().getRoad().get(i).getNextRoad().get(j).getClass());
												System.out.println(main.getEngine().getPlayer().getArea().getRoad().get(i).getNextRoad().get(j).getPos().getX() + ", " + main.getEngine().getPlayer().getArea().getRoad().get(i).getNextRoad().get(j).getPos().getY());
											}
										}
									}*/
								}
								if(number == JOptionPane.NO_OPTION) {
									// close
								}
							}
							
						// Akadaly fejlesztesenel fut le ez az ag
							else if(tiles.get(ii).get(jj).getType() == 3) {
								String message = "Do you want to upgrade this obstacle?";
								Object[] options = { "Yes", "No" };
								int number = JOptionPane.showOptionDialog(frame, message, "",
							            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
								if(number == JOptionPane.OK_OPTION && (main.getEngine().getPlayer().getMagicPower() >= 10)) {
									Obstacle o = (Obstacle) tiles.get(ii).get(jj);
									o.wantToUpgrade(main.getEngine().getPlayer());
								}
								
								// Ha nincs eleg varazsero
								if(main.getEngine().getPlayer().getMagicPower() < 10){
									message = "You don't have enough magicpower.";
									JOptionPane.showMessageDialog(frame, "You don't have enough magicpower.", "Warning", JOptionPane.WARNING_MESSAGE);
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
	
	/**
	 * Jatek vege uzenet. Ha egy ellensek elerte a hegyet akkor ugrik fel.
	 */
	public static void endGameMessage(){
		if(end == true)
			JOptionPane.showMessageDialog(frame, "Victory!", "EndGame",JOptionPane.INFORMATION_MESSAGE);
		else if(end == false)
			JOptionPane.showMessageDialog(frame, "Defeat!", "EndGame",JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * A felhasznaloi interfeszt hozza letre
	 * @param tiles - a csempek listaja
	 */
	public static void createAndShowGUI(ArrayList<ArrayList<Tile>> tiles) {
        frame = new JFrame("Tower defense");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        tilesDraw(tiles);
        clickHandling(tiles);
        frame.pack();
        frame.setVisible(true);
    }
	
	/**
	 * A program belepesi pontja
	 * @param args - parancssori argumentumok
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		main = new Main();
		main.draw();
		main.loadMap();
		main.getEngine().run();
	}
}
