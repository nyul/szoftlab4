import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


public class Main implements Serializable {
	
	/**
	 * engine - engine osztaly referenciaja
	 * outputNumber - azt tarolja, hogy melyik input fajlt toltottuk be
	 */
	private static final long serialVersionUID = 1L;
	private Engine engine;
	PlayerDraw playerDraw;
	GraphicsArea graphics;
	private static String outputNumber = "";
	BufferedReader reader;
	
	public Main() {
		engine = new Engine();
		Writer.writeText = new ArrayList<String>();
	}
	
	public Engine getEngine() {
		return engine;
	}

	void draw() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GraphicsArea.createAndShowGUI(engine.getPlayer().getArea().getGeometry().getTiles());
            }
        });
		PlayerDraw player = new PlayerDraw();
		engine.getPlayer().registerObserver(player);
		GeometryDraw geoDraw = new GeometryDraw();
		engine.getPlayer().getArea().getGeometry().registerObserver(geoDraw);
		EngineDraw engineDraw = new EngineDraw();
		engine.registerObserver(engineDraw);
		FellowshipDraw fellowshipDraw = new FellowshipDraw();
		engine.getFellowship().registerObserver(fellowshipDraw);
	}

	public void loadMap(String name)  {
		/**
		 * Egy inputxx.txt fajlt var a felhasznalotol
		 * Ha olyan fajlt adunk meg, ami nem letezik, akkor egy invalid input filename szoveget dob a konzolra
		 */
		try  {
			/**
			 * Fajl megnyitasa
			 */
			FileReader fileReader = new FileReader(name);
			reader = new BufferedReader(fileReader);
						
			/**
			 * fajl tartalmank sorokra tordelese
			 */
			String line = reader.readLine();
			
			outputNumber = name.substring(5, 7);
		
			/**
			 * amig van nem ures sor a fajlban, addig lepunk
			 */			
			while(line!=null) {
				/**
				 * sorok szavakra tordelese
				*/
				String[] word = line.split(" ");
				/**
				* letesz egy tornyot a megadott pozicioju csempere
				*/
				if(word[0].equals("Tower")) {
					Tower tower = new Tower(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
					/**
					* megvizsgalja, hogy lerakhato-e a torony a megadott csempere
					*/
					engine.getPlayer().getArea().isBuildable(tower);
				}
				/**
				* letesz egy akadalyt a megadott pozicioju csempere
				*/
				else if(word[0].equals("Obstacle")) {
					if(!word[1].equals("ref")) {
						Obstacle obst = new Obstacle(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
						/**
						 * megvizsgalja, hogy lerakhato-e az akadaly a megadott csempere
						*/
						engine.getPlayer().getArea().isBuildable(obst);
					}
					else {
						engine.getPlayer().getArea().addReference(new Position(Integer.parseInt(word[2]), Integer.parseInt(word[3])), new Position(Integer.parseInt(word[4]), Integer.parseInt(word[5])), new Position(Integer.parseInt(word[6]), Integer.parseInt(word[7])));
					}
				}
				/**
				* letesz egy forrast a megadott pozicioju csempere
				*/
				else if(word[0].equals("Source")) {
					if(!word[1].equals("ref")) {
						Source source = new Source(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
						/**
						* megvizsgalja, hogy lerakhato-e a forras a megadott csempere
						*/
						engine.getPlayer().getArea().isBuildable(source);	
					}
					else {
						engine.getPlayer().getArea().addReference(new Position(Integer.parseInt(word[2]), Integer.parseInt(word[3])), new Position(Integer.parseInt(word[4]), Integer.parseInt(word[5])), new Position(Integer.parseInt(word[6]), Integer.parseInt(word[7])));
					}
				}
				/**
				* letesz egy ut-csempet a megadott pozicioju csempere
				*/
				else if(word[0].equals("Road")) {
					if(!word[1].equals("ref")) {
						Road road = new Road(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
						/**
						* megvizsgalja, hogy lerakhato-e az ut a megadott csempere
						*/
						engine.getPlayer().getArea().isBuildable(road);
					}
					else {
						engine.getPlayer().getArea().addReference(new Position(Integer.parseInt(word[2]), Integer.parseInt(word[3])), new Position(Integer.parseInt(word[4]), Integer.parseInt(word[5])), new Position(Integer.parseInt(word[6]), Integer.parseInt(word[7])));
					}
				}
				/**
				* letesz egy hegyet a megadott pozicioju csempere
				*/
				else if(word[0].equals("Mountain")) {
					if(!word[1].equals("ref")) {
						Mountain mountain = new Mountain(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
						/**
						 * megvizsgalja, hogy lerakhato-e a hegy a megadott csempere
						 */
						engine.getPlayer().getArea().isBuildable(mountain);
					}
					else {
						engine.getPlayer().getArea().addReference(new Position(Integer.parseInt(word[2]), Integer.parseInt(word[3])), new Position(Integer.parseInt(word[4]), Integer.parseInt(word[5])), new Position(Integer.parseInt(word[6]), Integer.parseInt(word[7])));
					}
				}
				/**
				* kovetkezo sor
				*/
				line = reader.readLine();
			}	
		
		} catch(FileNotFoundException e) {
			System.out.println("Invalid input file name.");
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			/**
			 * fajl bezarasa
			 */
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * kiirja az eredmenyt a megadott nevu fajlba
	 * @param filename - kimeneti fajl neve
	 * @throws IOException
	 */
	public void writeOutputLanguage(String filename) throws IOException {
		if(outputNumber != "") {
			FileWriter fileWriter = new FileWriter(filename);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			for(int i = 0; i < Writer.writeText.size(); i++) {
				writer.write(Writer.writeText.get(i) + System.getProperty( "line.separator"));
			}
			writer.close();
		}
	}
}
