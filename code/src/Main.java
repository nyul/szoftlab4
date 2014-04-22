import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;


public class Main implements Serializable {
	
	/**
	 * engine - engine osztály referenciája
	 * outputNumber - azt tárolja, hogy melyik input fájlt töltöttük be
	 */
	private static final long serialVersionUID = 1L;
	private Engine engine;
	private BufferedReader br;
	private static String outputNumber = "";
	
	public Main() {
		engine = new Engine();
		Writer.writeText = new ArrayList<String>();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.loadInputLanguage();
	}

	/**
	 * A konzolon egy inputxx.txt fajlt ker, ami egy tesztesetet reprezental. A tesztesetet a metodus ertelmezni tudja es sikeres
	 * lefutas utan egy output.txt fajlba menti ki az eredmenyt.
	 */
	public void loadInputLanguage()  {
		/**
		 * Egy inputxx.txt fajlt var a felhasznalotol
		 * Ha olyan fajlt adunk meg, ami nem letezik, akkor egy invalid input filename szoveget dob a konzolra
		 */
		System.out.println("Give the full input file name with extension!");
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		try  {
			String s = bufferRead.readLine();
			/**
			 * Fajl megnyitasa
			 */
			FileReader fileReader = new FileReader(s);
			BufferedReader reader = new BufferedReader(fileReader);
			/**
			 * fajl tartalmank sorokra tordelese
			 */
			String line = reader.readLine();
			/**
			 * megnyitott fajl nevebol a 6 es 7-dik karaktert szedi ki, ami egy ketjegyu szam
			 */
			outputNumber = s.substring(5, 7);
		
			/**
			 * amig van nem ures sor a fajlban, addig lepunk
			 */
			while(line!=null) {			
				/**
				 * egy sorban levo szoveget feldarabolja a szokozok menten es egy tombbe rakja (szavakra darabolas)
				 */
				String[] command = line.split(" ");
				/**
				 * ha egy sor elso szava RANDOM_ON
				 */
				if(command[0].equals("RANDOM_ON")) {
					/**
					 * road random attributumanak true-ra allitasa
					 * ez az ut elagazas kezelesehez szukseges
					 */
					if(!engine.getPlayer().getArea().getRoad().isEmpty()){
						for(int i = 0 ; i < engine.getPlayer().getArea().getRoad().size(); i++){
							engine.getPlayer().getArea().getRoad().get(i).random = true;
						}
					}
					/**
					 * torony random attributumanak true-ra allitas
					 * tuzeles soran a ketteszakitashoz kell
					 */
					if(!engine.getPlayer().getArea().getTower().isEmpty()){
						for(int i = 0 ; i < engine.getPlayer().getArea().getTower().size(); i++){
							engine.getPlayer().getArea().getTower().get(i).random = true;
						}
					}
					if(!engine.getFellowship().getPassive().isEmpty()){
						for(int i = 0 ; i < engine.getFellowship().getPassive().size(); i++){
							engine.getFellowship().getPassive().get(i).random = true;
						}
					}
					if(!engine.getFellowship().getActive().isEmpty()){
						for(int i = 0 ; i < engine.getFellowship().getActive().size(); i++){
							engine.getFellowship().getActive().get(i).random = true;
						}
					}
					Writer.writeText.add("Random Numbers Enabled!");
					System.out.println("Random Numbers Enabled!");
				}
				/**
				 * ha sor elso szava SPLIT_ON
				 * ellenseg ketteszakitasahoz szukseges
				 */
				else if(command[0].equals("SPLIT_ON")) {
					if(!engine.getPlayer().getArea().getTower().isEmpty()){
						for(int i = 0 ; i < engine.getPlayer().getArea().getTower().size(); i++){
							engine.getPlayer().getArea().getTower().get(i).split = true;
						}
					}					
				}
				/**
				 * ha a sor elso szava buildTower
				 * adott csempere megprobal letenni egy tornyot
				 * ha sikeres a leteves, akkor meg hozza kell adni az ujonnan leterhozott tornyot a tower listahoz
				 */
				else if(command[0].equals("buildTower")) {
					Tower t = engine.getPlayer().getArea().getGeometry().getTiles().get(Integer.parseInt(command[1])).get(Integer.parseInt(command[2])).buildTower(engine.getPlayer());
					engine.getPlayer().getArea().addTower(t);
					
					Writer.writeText.add("[" + t.getMyId() + ":" + t.getClass().getName() + "] has been built on Tile(" + Integer.parseInt(command[1]) + "," + Integer.parseInt(command[2]) + ")");
					System.out.println("[" + t.getMyId() + ":" + t.getClass().getName() + "] has been built on Tile(" + Integer.parseInt(command[1]) + "," + Integer.parseInt(command[2]) + ")");

				}
				/**
				 * ha a sor elso szava buildObstacle
				 * adott ut-csempere megprobal letenni egy akadalyt
				 * ha sikeres a leteves, akkor meg hozza kell adni az ujonnan leterhozott akadalyt az obstacle listahoz
				 */
				else if(command[0].equals("buildObstacle")) {			
					for(int i = 0; i < engine.getPlayer().getArea().getRoad().size(); i++){
						if(engine.getPlayer().getArea().getRoad().get(i).pos.getX() == Integer.parseInt(command[1]) && engine.getPlayer().getArea().getRoad().get(i).pos.getY() == Integer.parseInt(command[2])){
							Obstacle o = engine.getPlayer().getArea().getRoad().get(i).buildObstacle(engine.getPlayer());
							engine.getPlayer().getArea().addObstacle(o);
							Writer.writeText.add("[" + Integer.parseInt(command[1]) + ":" + o.getClass().getName() + "] has been built on Road(" + o.getPos().getX() + "," + o.getPos().getY() + ")");
							System.out.println("[" + Integer.parseInt(command[1]) + ":" + o.getClass().getName() + "] has been built on Road(" + o.getPos().getX() + "," + o.getPos().getY() + ")");
						}
					}
				}
				/**
				 * ha a sor elso szava upgradeTower
				 *  adott tornyot megprobalja feljeszteni a jatekos altal kivalasztott varazskovel
				 */
				else if(command[0].equals("upgradeTower")) {
					Tower t = engine.getPlayer().getArea().getTower().get(Integer.parseInt(command[1]));
					t.wantToUpgrade(engine.getPlayer());
					Writer.writeText.add("[Player]" + " has upgraded [" + Integer.parseInt(command[1]) + ":" + t.getClass().getName() + "]");
				    System.out.println("[Player]" + " has upgraded [" + Integer.parseInt(command[1]) + ":" + t.getClass().getName() + "]");
				}
				/**
				 * ha a sor elso szava upgradeObstacle
				 *  adott akadalyt megprobalja feljeszteni a jatekos altal kivalasztott varazskovel
				 */
				else if(command[0].equals("upgradeObstacle")) {
					Obstacle o = engine.getPlayer().getArea().getObstacle().get(Integer.parseInt(command[1]));
					o.upgrade(engine.getPlayer().getArea().getObstacle().get(Integer.parseInt(command[1])).getMagicRock().get(Integer.parseInt(command[2])));
					Writer.writeText.add("[Player]" + " has upgraded [" + Integer.parseInt(command[1]) + ":" + o.getClass().getName() + "]");
					System.out.println("[Player]" + " has upgraded [" + Integer.parseInt(command[1]) + ":" + o.getClass().getName() + "]");
				}
				/**
				 * ha sor elso szava step
				 * 1-el leptetodik a rendszer, azaz 10 tick-el
				 */
				else if(command[0].equals("step")) {
					Writer.writeText.add("[Step:" + Integer.parseInt(command[1]) + "]");
					System.out.println("[Step:" + Integer.parseInt(command[1]) + "]");
					for(int i=0; i < 10*Integer.parseInt(command[1]); i++) {
						engine.run();
					}
				}
				/**
				 * adott id-ju torony adatainak kilistazasa
				 */
				else if(command[0].equals("getTowerInfo")) {
					Tower t = engine.getPlayer().getArea().getTower().get(Integer.parseInt(command[1]));
					Writer.writeText.add("[" + Integer.parseInt(command[1]) + ":" + t.getClass().getName() + "]");
					Writer.writeText.add("range: " + t.getRange());
					Writer.writeText.add("shootPeriod: " + t.getShootPeriod());
					Writer.writeText.add("damagePowerHuman: " + t.getDamagePowerHuman());
					Writer.writeText.add("damagePowerHobbit: " + t.getDamagePowerHobbit());
					Writer.writeText.add("damagePowerElf: " + t.getDamagePowerElf());
					Writer.writeText.add("damagePowerDwarf: " + t.getDamagePowerDwarf());
					Writer.writeText.add("magicRockNumber: " + t.getMagicRockNumber());
					System.out.println("[" + Integer.parseInt(command[1]) + ":" + t.getClass().getName() + "]");
					System.out.println("range: " + t.getRange());
					System.out.println("fogRange: " + t.getFogRange());
					System.out.println("shootPeriod: " + t.getShootPeriod());
					System.out.println("damagePowerHuman: " + t.getDamagePowerHuman());
					System.out.println("damagePowerHobbit: " + t.getDamagePowerHobbit());
					System.out.println("damagePowerElf: " + t.getDamagePowerElf());
					System.out.println("damagePowerDwarf: " + t.getDamagePowerDwarf());
					System.out.println("magicRockNumber: " + t.getMagicRockNumber());
				}
				/**
				 * adott id-ju akadaly adatainak kilistazasa
				 */
				else if(command[0].equals("getObstacleInfo")) {
					Obstacle o = engine.getPlayer().getArea().getObstacle().get(Integer.parseInt(command[1]));
					Writer.writeText.add("[" + Integer.parseInt(command[1]) + ":" + o.getClass().getName() + "]");
					Writer.writeText.add("slowingFactor: " + o.getSlowingFactor());
					Writer.writeText.add("magicRockNumber: " + o.getMagicRockNumber());
					System.out.println("[" + Integer.parseInt(command[1]) + ":" + o.getClass().getName() + "]");
					System.out.println("slowingFactor: " + o.getSlowingFactor());
					System.out.println("magicRockNumber: " + o.getMagicRockNumber());
				}
				/**
				 * adott id-ju ellenseg adatainak kilistazasa
				 */
				else if(command[0].equals("getEnemyInfo")) {
					Enemy e = engine.getFellowship().getActive().get(Integer.parseInt(command[1]));
					/**
					 * ha az ellenseg tipusa ember
					 */
					if(e instanceof Human) {
						Human h = (Human) e;
						Writer.writeText.add("[" + h.getMyId() + ":" + h.getClass().getName() + "]");
						Writer.writeText.add("lifePower: " + h.getLifePower());
						Writer.writeText.add("stepTime: " + h.getStepTime());
						Writer.writeText.add("pause: " + h.getPause());
						Writer.writeText.add("position: (" + h.getRoad().getPos().getX() + "," + h.getRoad().getPos().getY() + ")");
						Writer.writeText.add("isActive: " + h.isActive());
						Writer.writeText.add("isDuplicated: " + h.isDuplicated());
						System.out.println("[" + h.getMyId() + ":" + h.getClass().getName() + "]");
						System.out.println("lifePower: " + h.getLifePower());
						System.out.println("stepTime: " + h.getStepTime());
						System.out.println("pause: " + h.getPause());
						System.out.println("position: (" + h.getRoad().getPos().getX() + "," + h.getRoad().getPos().getY() + ")");
						System.out.println("isActive: " + h.isActive());
						System.out.println("isDuplicated: " + h.isDuplicated());
					}
					/**
					 * ha az ellenseg tipusa hobbit
					 */
					else if(e instanceof Hobbit) {
						Hobbit h = (Hobbit) e;
						Writer.writeText.add("[" + h.getMyId() + ":" + h.getClass().getName() + "]");
						Writer.writeText.add("lifePower: " + h.getLifePower());
						Writer.writeText.add("stepTime: " + h.getStepTime());
						Writer.writeText.add("pause: " + h.getPause());
						Writer.writeText.add("position: (" + h.getRoad().getPos().getX() + "," + h.getRoad().getPos().getY() + ")");
						Writer.writeText.add("isActive: " + h.isActive());
						Writer.writeText.add("isDuplicated: " + h.isDuplicated());
						System.out.println("[" + h.getMyId() + ":" + h.getClass().getName() + "]");
						System.out.println("lifePower: " + h.getLifePower());
						System.out.println("stepTime: " + h.getStepTime());
						System.out.println("pause: " + h.getPause());
						System.out.println("position: (" + h.getRoad().getPos().getX() + "," + h.getRoad().getPos().getY() + ")");
						System.out.println("isActive: " + h.isActive());
						System.out.println("isDuplicated: " + h.isDuplicated());
					}
					/**
					 * ha ellenseg tipusa torpe
					 */
					else if(e instanceof Dwarf) {
						Dwarf d = (Dwarf) e;
						Writer.writeText.add("[" + d.getMyId() + ":" + d.getClass().getName() + "]");
						Writer.writeText.add("lifePower: " + d.getLifePower());
						Writer.writeText.add("stepTime: " + d.getStepTime());
						Writer.writeText.add("pause: " + d.getPause());
						Writer.writeText.add("position: (" + d.getRoad().getPos().getX() + "," + d.getRoad().getPos().getY() + ")");
						Writer.writeText.add("isActive: " + d.isActive());
						Writer.writeText.add("isDuplicated: " + d.isDuplicated());
						System.out.println("[" + d.getMyId() + ":" + d.getClass().getName() + "]");
						System.out.println("lifePower: " + d.getLifePower());
						System.out.println("stepTime: " + d.getStepTime());
						System.out.println("pause: " + d.getPause());
						System.out.println("position: (" + d.getRoad().getPos().getX() + "," + d.getRoad().getPos().getY() + ")");
						System.out.println("isActive: " + d.isActive());
						System.out.println("isDuplicated: " + d.isDuplicated());
					}
					/**
					 * ha az ellenseg tipusa tunde
					 */
					else if(e instanceof Elf) {
						Elf elf = (Elf) e;
						Writer.writeText.add("[" + elf.getMyId() + ":" + elf.getClass().getName() + "]");
						Writer.writeText.add("lifePower: " + elf.getLifePower());
						Writer.writeText.add("stepTime: " + elf.getStepTime());
						Writer.writeText.add("pause: " + elf.getPause());
						Writer.writeText.add("position: (" + elf.getRoad().getPos().getX() + "," + elf.getRoad().getPos().getY() + ")");
						Writer.writeText.add("isActive: " + elf.isActive());
						Writer.writeText.add("isDuplicated: " + elf.isDuplicated());
						System.out.println("[" + elf.getMyId() + ":" + elf.getClass().getName() + "]");
						System.out.println("lifePower: " + elf.getLifePower());
						System.out.println("stepTime: " + elf.getStepTime());
						System.out.println("pause: " + elf.getPause());
						System.out.println("position: (" + elf.getRoad().getPos().getX() + "," + elf.getRoad().getPos().getY() + ")");
						System.out.println("isActive: " + elf.isActive());
						System.out.println("isDuplicated: " + elf.isDuplicated());
					}
				}
				/**
				 * jatekos adatainak kilistazasa
				 */
				else if(command[0].equals("getPlayerInfo")) {
					Player p = engine.getPlayer();
					Writer.writeText.add("[" + p.getClass().getName() + "]");
					Writer.writeText.add("magicPower: " + p.getMagicPower());
					System.out.println("[" + p.getClass().getName() + "]");
					System.out.println("magicPower: " + p.getMagicPower());
				}
				/**
				 * ha a sor elso szava fogOn
				 * minden toronyra leszall a kod
				 */
				else if(command[0].equals("fogOn")) {
					ArrayList<Tower> t = engine.getPlayer().getArea().getTower();
					for(int i = 0; i < t.size(); i++) {
						t.get(i).fogOn();
					}
				}
				/**
				 * ha a sor elso szava fogOff
				 * minden toronyrol felszall a kod
				 */
				else if(command[0].equals("fogOff")) {
					ArrayList<Tower> t = engine.getPlayer().getArea().getTower();
					for(int i = 0; i < t.size(); i++) {
						t.get(i).fogOff();
					}
				}
				/**
				 * inputxx.txt fajlhoz tartozo mapxx.txt beolvasasa
				 * ha a sor elso szava loadMap
				 */
				else if(command[0].equals("loadMap")) {
					/**
					 * sor masodik szava megadja a map nevet
					 * map megnyitasa, palya statikus betoltese
					 */
					FileReader fr = new FileReader(command[1].toString());
					br = new BufferedReader(fr);
					String row = br.readLine();
					/**
					 * amig van ures sor, addig megyunk
					 */
					while(row!=null) {
						/**
						 * sorok szavakra tordelese
						 */
						String[] word = row.split(" ");
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
								engine.getPlayer().getArea().addReference(new Position(Integer.parseInt(word[2]), Integer.parseInt(word[3])), new Position(Integer.parseInt(word[4]), Integer.parseInt(word[5])));
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
								engine.getPlayer().getArea().addReference(new Position(Integer.parseInt(word[2]), Integer.parseInt(word[3])), new Position(Integer.parseInt(word[4]), Integer.parseInt(word[5])));
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
								engine.getPlayer().getArea().addReference(new Position(Integer.parseInt(word[2]), Integer.parseInt(word[3])), new Position(Integer.parseInt(word[4]), Integer.parseInt(word[5])));
							}
						}
						/**
						 * letesz egy hegyet a megadott pozicioju csempere
						 */
						else if(word[0].equals("Mountain")) {
							Mountain mountain = new Mountain(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
							/**
							 * megvizsgalja, hogy lerakhato-e a hegy a megadott csempere
							 */
							engine.getPlayer().getArea().isBuildable(mountain);
						}
						/**
						 * lerak egy hobbitot a megadott pozicioju csempere
						 */
						else if(word[0].equals("Hobbit")) {
							for(int i = 0; i < engine.getPlayer().getArea().getRoad().size(); i++) {
								if(engine.getPlayer().getArea().getRoad().get(i).getPos().getX() == Integer.parseInt(word[1]) && engine.getPlayer().getArea().getRoad().get(i).getPos().getY() == Integer.parseInt(word[2])) {
									Hobbit h = new Hobbit(engine.getPlayer().getArea().getRoad().get(i));
									if( word.length == 4){
										h.setLifePower(Integer.parseInt(word[3]));
									}
									engine.getFellowship().getActive().add(h);
									engine.getFellowship().setNumber(engine.getFellowship().getNumber()+1);
								}
							}
						}
						/**
						 * lerak egy embert a megadott pozicioju csempere
						 */
						else if(word[0].equals("Human")) {
							for(int i = 0; i < engine.getPlayer().getArea().getRoad().size(); i++) {
								if(engine.getPlayer().getArea().getRoad().get(i).getPos().getX() == Integer.parseInt(word[1]) && engine.getPlayer().getArea().getRoad().get(i).getPos().getY() == Integer.parseInt(word[2])) {
									Human h = new Human(engine.getPlayer().getArea().getRoad().get(i));
									if( word.length == 4){
										h.setLifePower(Integer.parseInt(word[3]));
									}
									engine.getFellowship().getActive().add(h);
									engine.getFellowship().setNumber(engine.getFellowship().getNumber()+1);
								}
							}
						}
						/**
						 * lerak egy torpet a megadott pozicioju csempere
						 */
						else if(word[0].equals("Dwarf")) {
							for(int i = 0; i < engine.getPlayer().getArea().getRoad().size(); i++) {
								if(engine.getPlayer().getArea().getRoad().get(i).getPos().getX() == Integer.parseInt(word[1]) && engine.getPlayer().getArea().getRoad().get(i).getPos().getY() == Integer.parseInt(word[2])) {
									Dwarf d = new Dwarf(engine.getPlayer().getArea().getRoad().get(i));
									if( word.length == 4){
										d.setLifePower(Integer.parseInt(word[3]));
									}
									engine.getFellowship().getActive().add(d);
									engine.getFellowship().setNumber(engine.getFellowship().getNumber()+1);
								}
							}
						}
						/**
						 * lerak egy tundet a megadott pozicioju csempere
						 */
						else if(word[0].equals("Elf")) {
							for(int i = 0; i < engine.getPlayer().getArea().getRoad().size(); i++) {
								if(engine.getPlayer().getArea().getRoad().get(i).getPos().getX() == Integer.parseInt(word[1]) && engine.getPlayer().getArea().getRoad().get(i).getPos().getY() == Integer.parseInt(word[2])) {
									Elf elf = new Elf(engine.getPlayer().getArea().getRoad().get(i));
									if( word.length == 4){
										elf.setLifePower(Integer.parseInt(word[3]));
									}
									engine.getFellowship().getActive().add(elf);
									engine.getFellowship().setNumber(engine.getFellowship().getNumber()+1);
								}
							}
						}	
						/**
						 * kovetkezo sor
						 */
						row = br.readLine();
					}
					/**
					 * fajl bezarasa
					 */
					br.close();	
				}
				/**
				 * teszteset vege
				 * eredmeny kiiratasa az outputxx.txt fajlba
				 * kilepes a programbol
				 */
				else if(command[0].equals("exit")) {
					writeOutputLanguage("output" + outputNumber + ".txt");
					System.exit(0);
				}
				/**
				 * kovetkezo sor
				 */
				line = reader.readLine();
			}
			/**
			 * fajl bezarasa
			 */
			reader.close();
		
		} catch(FileNotFoundException e) {
			System.out.println("Invalid input file name.");
		} catch(Exception e) {
			e.printStackTrace();
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
