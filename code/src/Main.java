import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
		try {
			main.loadInputLanguage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadInputLanguage() throws IOException {
		FileReader fileReader = new FileReader("input.txt");
		BufferedReader reader = new BufferedReader(fileReader);
		String line = reader.readLine();
		while(line!=null) {
			String[] command = line.split(" ");
			if(command[0].equals("buildTower")) {
				Tower t = engine.getPlayer().getArea().getGeometry().getTiles().get(Integer.parseInt(command[1])).get(Integer.parseInt(command[2])).buildTower(engine.getPlayer());
				engine.getPlayer().getArea().addTower(t);
				System.out.println("[" + Integer.parseInt(command[1]) + ":" + t.getClass().getName() + "] has been built on the Tile(Position(" + Integer.parseInt(command[1]) + "," + Integer.parseInt(command[2]) + ")");
			}
			else if(command[0].equals("buildObstacle")) {
				Obstacle o = engine.getPlayer().getArea().getGeometry().getTiles().get(Integer.parseInt(command[1])).get(Integer.parseInt(command[2])).buildObstacle(engine.getPlayer());
				System.out.println("[" + Integer.parseInt(command[1]) + ":" + o.getClass().getName() + "] has been built on the Road(Position(" + Integer.parseInt(command[1]) + "," + Integer.parseInt(command[2]) + ")");
			}
			else if(command[0].equals("upgradeTower")) {
				Tower t = engine.getPlayer().getArea().getTower().get(Integer.parseInt(command[1]));
				t.upgrade(engine.getPlayer().getArea().getTower().get(Integer.parseInt(command[1])).getMagicRock().get(Integer.parseInt(command[2])));
				System.out.println("[1:Player]" + " has been upgrade [" + Integer.parseInt(command[1]) + ":" + t.getClass().getName() + "]");
			}
			else if(command[0].equals("upgradeObstacle")) {
				Obstacle o = engine.getPlayer().getArea().getObstacle().get(Integer.parseInt(command[1]));
				o.upgrade(engine.getPlayer().getArea().getObstacle().get(Integer.parseInt(command[1])).getMagicRock().get(Integer.parseInt(command[2])));
				System.out.println("[1:Player]" + " has been upgrade [" + Integer.parseInt(command[1]) + ":" + o.getClass().getName() + "]");
			}
			else if(command[0].equals("step")) {
				System.out.println("[Step: " + Integer.parseInt(command[1]) + "]");
				for(int i=0; i<10*Integer.parseInt(command[1]); i++) {
					engine.run();
				}
			}
			else if(command[0].equals("getTowerInfo")) {
				Tower t = engine.getPlayer().getArea().getTower().get(Integer.parseInt(command[1]));
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
				Obstacle o = engine.getPlayer().getArea().getObstacle().get(Integer.parseInt(command[1]));
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
						Tower t = new Tower(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
						engine.getPlayer().getArea().addTower(t);
					}
					else if(word[0].equals("Obstacle")) {
						Obstacle o = new Obstacle(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
						engine.getPlayer().getArea().addObstacle(o);
					}
					else if(word[0].equals("Source")) {
						Source s = new Source(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
						engine.getPlayer().getArea().getSource().add(s);
					}
					else if(word[0].equals("Road")) {
						//Road r = new Road(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
						//r.setNextRoad(new Road(new Position(Integer.parseInt(word[3]), Integer.parseInt(word[4]))));
						//engine.getPlayer().getArea().getRoad().add(r);
					}
					else if(word[0].equals("Mountain")) {
						Mountain m = new Mountain(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
						m.setNextRoad(new Road(new Position(-1, -1)));
						engine.getPlayer().getArea().setMountain(m);
					}
					else if(word[0].equals("Hobbit")) {
						Hobbit h = new Hobbit(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
						engine.getFellowship().getActive().add(h);
					}
					else if(word[0].equals("Human")) {
						Human h = new Human(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
						engine.getFellowship().getActive().add(h);
					}
					else if(word[0].equals("Dwarf")) {
						Dwarf d = new Dwarf(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
						engine.getFellowship().getActive().add(d);
					}
					else if(word[0].equals("Elf")) {
						Elf e = new Elf(new Position(Integer.parseInt(word[1]), Integer.parseInt(word[2])));
						engine.getFellowship().getActive().add(e);
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
