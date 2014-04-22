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
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Engine engine;
	private BufferedReader br;
	
	public Main() {
		engine = new Engine();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.loadInputLanguage();
	}


	public void loadInputLanguage()  {
		
		System.out.println("Give the full input file name with extension!");
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		try  {
			String s = bufferRead.readLine();
			FileReader fileReader = new FileReader(s);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = reader.readLine();
		
			while(line!=null) {
				String[] command = line.split(" ");
				if(command[0].equals("buildTower")) {
					Tower t = engine.getPlayer().getArea().getGeometry().getTiles().get(Integer.parseInt(command[1])).get(Integer.parseInt(command[2])).buildTower(engine.getPlayer());
					engine.getPlayer().getArea().addTower(t);
					System.out.println("[" + Integer.parseInt(command[1]) + ":" + t.getClass().getName() + "] has been built on the Tile(" + Integer.parseInt(command[1]) + "," + Integer.parseInt(command[2]) + ")");
				}
				else if(command[0].equals("buildObstacle")) {			
					for(int i = 0; i < engine.getPlayer().getArea().getRoad().size(); i++){
						if(engine.getPlayer().getArea().getRoad().get(i).pos.getX() == Integer.parseInt(command[1]) && engine.getPlayer().getArea().getRoad().get(i).pos.getY() == Integer.parseInt(command[2])){
							Obstacle o = engine.getPlayer().getArea().getRoad().get(i).buildObstacle(engine.getPlayer());
							//engine.getPlayer().getArea().getGeometry().getTiles().get(Integer.parseInt(command[1])).get(Integer.parseInt(command[2])).buildObstacle(engine.getPlayer());
							engine.getPlayer().getArea().addObstacle(o);
							System.out.println("[" + Integer.parseInt(command[1]) + ":" + o.getClass().getName() + "] has been built on the Road(Position(" + o.getPos().getX() + "," + o.getPos().getY() + ")");
						}
					}				
				}
				else if(command[0].equals("upgradeTower")) {
					Tower t = engine.getPlayer().getArea().getTower().get(Integer.parseInt(command[1])-1);
					System.out.println("Choose a magicrock from the list!");
					for(int i = 0; i < MagicRock.getName().size(); i++) {
						System.out.println(i + ": " + MagicRock.getName().get(i));
					}
					bufferRead = new BufferedReader(new InputStreamReader(System.in));
				    s = bufferRead.readLine();
					t.upgrade(engine.getPlayer().getArea().getTower().get(Integer.parseInt(command[1])-1).getMagicRock().get(Integer.parseInt(command[2])));
					System.out.println("[1:Player]" + " has been upgrade [" + Integer.parseInt(command[1]) + ":" + t.getClass().getName() + "]");
				}
				else if(command[0].equals("upgradeObstacle")) {
					Obstacle o = engine.getPlayer().getArea().getObstacle().get(Integer.parseInt(command[1]));
					o.upgrade(engine.getPlayer().getArea().getObstacle().get(Integer.parseInt(command[1])).getMagicRock().get(Integer.parseInt(command[2])));
					System.out.println("[1:Player]" + " has been upgrade [" + Integer.parseInt(command[1]) + ":" + o.getClass().getName() + "]");
				}
				else if(command[0].equals("step")) {
					System.out.println("[Step:" + Integer.parseInt(command[1]) + "]");
					for(int i=0; i < 10*Integer.parseInt(command[1]); i++) {
						engine.run();
					}
				}
				else if(command[0].equals("getTowerInfo")) {
					Tower t = engine.getPlayer().getArea().getTower().get(Integer.parseInt(command[1])-1);
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
				else if(command[0].equals("getObstacleInfo")) {
					Obstacle o = engine.getPlayer().getArea().getObstacle().get(Integer.parseInt(command[1])-1);
					System.out.println("[" + Integer.parseInt(command[1]) + ":" + o.getClass().getName() + "]");
					System.out.println("slowingFactor: " + o.getSlowingFactor());
					System.out.println("magicRockNumber: " + o.getMagicRockNumber());
				}
				else if(command[0].equals("getEnemyInfo")) {
					Enemy e = engine.getFellowship().getActiveEnemies().get(Integer.parseInt(command[1])-1);
					if(e instanceof Human) {
						Human h = (Human) e;
						System.out.println("[" + Integer.parseInt(command[1]) + ":" + h.getClass().getName() + "]");
						System.out.println("lifePower: " + h.getLifePower());
						System.out.println("stepTime: " + h.getStepTime());
						System.out.println("pause: " + h.getPause());
						System.out.println("position: (" + h.getRoad().getPos().getX() + "," + h.getRoad().getPos().getY() + ")");
						System.out.println("isActive: " + h.isActive());
						System.out.println("isDuplicated: " + h.isDuplicated());
					}
					else if(e instanceof Hobbit) {
						Hobbit h = (Hobbit) e;
						System.out.println("[" + Integer.parseInt(command[1]) + ":" + h.getClass().getName() + "]");
						System.out.println("lifePower: " + h.getLifePower());
						System.out.println("stepTime: " + h.getStepTime());
						System.out.println("pause: " + h.getPause());
						System.out.println("position: (" + h.getRoad().getPos().getX() + "," + h.getRoad().getPos().getY() + ")");
						System.out.println("isActive: " + h.isActive());
						System.out.println("isDuplicated: " + h.isDuplicated());
					}
					else if(e instanceof Dwarf) {
						Dwarf d = (Dwarf) e;
						System.out.println("[" + Integer.parseInt(command[1]) + ":" + d.getClass().getName() + "]");
						System.out.println("lifePower: " + d.getLifePower());
						System.out.println("stepTime: " + d.getStepTime());
						System.out.println("pause: " + d.getPause());
						System.out.println("position: (" + d.getRoad().getPos().getX() + "," + d.getRoad().getPos().getY() + ")");
						System.out.println("isActive: " + d.isActive());
						System.out.println("isDuplicated: " + d.isDuplicated());
					}
					else if(e instanceof Elf) {
						Elf elf = (Elf) e;
						System.out.println("[" + Integer.parseInt(command[1]) + ":" + elf.getClass().getName() + "]");
						System.out.println("lifePower: " + elf.getLifePower());
						System.out.println("stepTime: " + elf.getStepTime());
						System.out.println("pause: " + elf.getPause());
						System.out.println("position: (" + elf.getRoad().getPos().getX() + "," + elf.getRoad().getPos().getY() + ")");
						System.out.println("isActive: " + elf.isActive());
						System.out.println("isDuplicated: " + elf.isDuplicated());
					}
				}
				else if(command[0].equals("getPlayerInfo")) {
					Player p = engine.getPlayer();
					System.out.println("[1:" + p.getClass().getName() + "]");
					System.out.println("magicPower: " + p.getMagicPower());
				}
				else if(command[0].equals("fogOn")) {
					ArrayList<Tower> t = engine.getPlayer().getArea().getTower();
					for(int i = 0; i < t.size(); i++) {
						t.get(i).fogOn();
					}
				}
				else if(command[0].equals("fogOff")) {
					ArrayList<Tower> t = engine.getPlayer().getArea().getTower();
					for(int i = 0; i < t.size(); i++) {
						t.get(i).fogOff();
					}
				}
				else if(command[0].equals("randomOn")) {
					//...
				}
				else if(command[0].equals("randomOff")) {
					//...
				}
				else if(command[0].equals("loadMap")) {
					FileReader fr = new FileReader(command[1].toString());
					br = new BufferedReader(fr);
					String row = br.readLine();
					while(row!=null) {
						String[] word = row.split(" ");
						if(word[0].equals("Tower")) {
							Tower tower = new Tower(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
							for(int i = 0; i < engine.getPlayer().getArea().getGeometry().getTiles().size(); i++) {
								for(int j = 0; j < engine.getPlayer().getArea().getGeometry().getTiles().get(i).size(); j++) {
									if(engine.getPlayer().getArea().getGeometry().getTiles().get(i).get(j).getType() == 0) {
										if(engine.getPlayer().getArea().getGeometry().getTiles().get(i).get(j).getPos().getX() == Integer.parseInt(word[1])
												&& engine.getPlayer().getArea().getGeometry().getTiles().get(i).get(j).getPos().getY() == Integer.parseInt(word[2])) {
											engine.getPlayer().getArea().addTower(tower);
											engine.getPlayer().getArea().getGeometry().getTiles().get(i).set(j, tower);
										}
									}
									else {
										System.out.println("Load map is unsuccessful.");
										System.out.println("Error: (" + Integer.parseInt(word[1]) + "," + Integer.parseInt(word[2]) + ") tile is not a unbuiltable.");
										System.exit(0);
									}
								}
							}
						}
						else if(word[0].equals("Obstacle")) {
							if(!word[1].equals("ref")) {
								Obstacle obst = new Obstacle(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
								for(int i = 0; i < engine.getPlayer().getArea().getGeometry().getTiles().size(); i++) {
									for(int j = 0; j < engine.getPlayer().getArea().getGeometry().getTiles().get(i).size(); j++) {
										if(engine.getPlayer().getArea().getGeometry().getTiles().get(i).get(j).getType() == 2) {
											if(engine.getPlayer().getArea().getGeometry().getTiles().get(i).get(j).getPos().getX() == Integer.parseInt(word[1])
													&& engine.getPlayer().getArea().getGeometry().getTiles().get(i).get(j).getPos().getY() == Integer.parseInt(word[2])) {
												engine.getPlayer().getArea().getObstacle().add(obst);
												engine.getPlayer().getArea().getGeometry().getTiles().get(i).set(j, obst);
											}
										}
										else {
											System.out.println("Load map is unsuccessful.");
											System.out.println("Error: (" + Integer.parseInt(word[1]) + "," + Integer.parseInt(word[2]) + ") tile is not a road.");
											System.exit(0);
										}
									}
								}
							}
							else {
								engine.getPlayer().getArea().addReference(new Position(Integer.parseInt(word[2]), Integer.parseInt(word[3])), new Position(Integer.parseInt(word[4]), Integer.parseInt(word[5])));
							}
						}
						else if(word[0].equals("Source")) {
							if(!word[1].equals("ref")) {
								Source source = new Source(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
								for(int i = 0; i < engine.getPlayer().getArea().getGeometry().getTiles().size(); i++) {
									for(int j = 0; j < engine.getPlayer().getArea().getGeometry().getTiles().get(i).size(); j++) {
										if(engine.getPlayer().getArea().getGeometry().getTiles().get(i).get(j).getType() == 0) {
											if(engine.getPlayer().getArea().getGeometry().getTiles().get(i).get(j).getPos().getX() == Integer.parseInt(word[1])
													&& engine.getPlayer().getArea().getGeometry().getTiles().get(i).get(j).getPos().getY() == Integer.parseInt(word[2])) {
												engine.getPlayer().getArea().getSource().add(source);
												engine.getPlayer().getArea().getGeometry().getTiles().get(i).set(j, source);
											}
										}
										else {
											System.out.println("Load map is unsuccessful.");
											System.out.println("Error: (" + Integer.parseInt(word[1]) + "," + Integer.parseInt(word[2]) + ") tile is unbuiltable.");
											System.exit(0);
										}
									}
								}
							}
							else {
								engine.getPlayer().getArea().addReference(new Position(Integer.parseInt(word[2]), Integer.parseInt(word[3])), new Position(Integer.parseInt(word[4]), Integer.parseInt(word[5])));
							}
						}
						else if(word[0].equals("Road")) {
							if(!word[1].equals("ref")) {
								Road road = new Road(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
								
							}
							else {
								engine.getPlayer().getArea().addReference(new Position(Integer.parseInt(word[2]), Integer.parseInt(word[3])), new Position(Integer.parseInt(word[4]), Integer.parseInt(word[5])));
							}
						}
						else if(word[0].equals("Mountain")) {
							Mountain mountain = new Mountain(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
							for(int i = 0; i < engine.getPlayer().getArea().getGeometry().getTiles().size(); i++) {
								for(int j = 0; j < engine.getPlayer().getArea().getGeometry().getTiles().get(i).size(); j++) {
									if(engine.getPlayer().getArea().getGeometry().getTiles().get(i).get(j).getType() == 0) {
										if(engine.getPlayer().getArea().getGeometry().getTiles().get(i).get(j).getPos().getX() == Integer.parseInt(word[1])
												&& engine.getPlayer().getArea().getGeometry().getTiles().get(i).get(j).getPos().getY() == Integer.parseInt(word[2])) {
											engine.getPlayer().getArea().setMountain(mountain);
											engine.getPlayer().getArea().getGeometry().getTiles().get(i).set(j, mountain);
										}
									}
									else {
										System.out.println("Load map is unsuccessful.");
										System.out.println("Error: (" + Integer.parseInt(word[1]) + "," + Integer.parseInt(word[2]) + ") tile is unbuiltable.");
										System.exit(0);
									}
								}
							}
						}
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
						row = br.readLine();
					}
					br.close();	
				}
				else if(command[0].equals("getEntityInfo")) {
					//...
				}
				else if(command[0].equals("exit")) {
					System.exit(0);
				}
				line = reader.readLine();
			}
			reader.close();
		
		} catch(FileNotFoundException e) {
			System.out.println("Invalid input file name.");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void writeOutputLanguage() throws IOException {
		FileWriter fileWriter = new FileWriter("output.txt");
		BufferedWriter writer = new BufferedWriter(fileWriter);
		for(int i = 0; i < Writer.getWriteText().size(); i++) {
			writer.write(Writer.getWriteText().get(i));
		}
		writer.close();
	}
}
