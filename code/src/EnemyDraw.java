import java.awt.Component;
import java.util.Observable;
import java.util.Observer;


/**
 * Az ellenseg kirajzolasaert felelos osztaly.
 * Egy observert valosit meg
 * Ez az osztaly fog ertesulni minden egyes enemy valtozasarol
 * Amikor egy enemy lep, az osztaly ujra rajzolja a jatekteren
 * az adott ellenseget
 * Ha az adott ellenseg eppen a forrasrol erkezik
 * akkor azt kulon agban fogjok kezelni
 * mivel ilyenkor nem kell az ellenseget az elozo
 * poziciojarol letorolni
 */
public class EnemyDraw implements Observer {
	
	
	/**
	 * Enemy notifyObservers() metodusanak hatasara hivokdik meg a fuggveny.
	 * Attol fuggoen, hogy milyen bemeneti parametert kapott a meghivasakor,
	 * azaz parameterul kapott megfigyelheto objektum milyen tipusu ellenseg.
	 * Igy 4 nagy if-es reszre bonthato az update metodus.
	 */
	@Override
	public void update(Observable o, Object arg) {
		
		// Ha az parameterul kapott megfigyelheto objektum egy hobbit
		//toroljuk az eloz csempet
		//athelyezzuk az ujra
		//es ujrafestjuk
		if(o instanceof Hobbit) {
			Hobbit hobbit = (Hobbit)o;
			/**
			 * ... akkor a Road poziciojara rajzolodjon ki az adott elleseg, melyet
			 * a GraphicsArea osztaly tile (JPanel tomb) valzotojanak megfelelo ertekehez valo
			 * hozzaadassal erunk el, ezutan validalnunk, azaz ervenyesiteni kell az eddigi
			 * kirajzolast, igy fogja tudni a GraphicsArea osztaly, hogy az ellenseg ki kell
			 * kirajzolni. 
			 * A kapott objektum Road tipusu, ebbol adodoan az ellenseg mar nem a Forrason fog 
			 * allni, igy az ellenseg objektum isSource tagvaltozojat hamisra allitjuk.
			 */
			if(hobbit.isSource) {
				if (arg instanceof Road) {
					Road road = (Road)arg;
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(hobbit.picLabel, 0);
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].validate();
					hobbit.setSource(false);
				}
			}
			/**
			 * Ha az ellenseg a Uton allo es van kovetkezo Ut
			 */
			else {
				/**
				 * ... akkor a Road poziciojara rajzolodjon ki az adott elleseg, a regi helyerol torolje
				 * majd az ujonnan kapott ut poziciojara rajzolodjon ki ujra
				 */
				if (arg instanceof Road) {
					Road road = (Road)arg;
							
					if(hobbit.getPreviousRoad() != null) {
						Component[] comp = GraphicsArea.tile[hobbit.getPreviousRoad().getPos().getX()][hobbit.getPreviousRoad().getPos().getY()].getComponents();
						for(int i = 0; i < comp.length; i++) {
							if(comp[i] == hobbit.picLabel) {
								GraphicsArea.tile[hobbit.getPreviousRoad().getPos().getX()][hobbit.getPreviousRoad().getPos().getY()].remove(i);
								GraphicsArea.tile[hobbit.getPreviousRoad().getPos().getX()][hobbit.getPreviousRoad().getPos().getY()].repaint();
							}
						}
					}
					
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(hobbit.picLabel, 0);
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].repaint();
				}
			}
	    }

		/**
		 * Ha az parameterul kapott megfigyelheto objektum egy human, akkor
		  * a masik parameterben kapott objektum, ez esetben Road...
		 */
		else if(o instanceof Human) {
			Human human = (Human) o;
			/**
			 * Ha az ellenseg a Forrason all
			 */
			if(human.isSource) {
				/**
				 * ... akkor a Road poziciojara rajzolodjon ki az adott elleseg, melyet
				 * a GraphicsArea osztaly tile (JPanel tomb) valzotojanak megfelelo ertekehez valo
				 * hozzaadassal erunk el, ezutan validalnunk, azaz ervenyesiteni kell a 
				 * kirajzolast, igy fogja tudni a GraphicsArea osztaly, hogy az ellenseg ki kell
				 * kirajzolni. 
				 * Mivel a kapott objektum Road tipusu, ebbol adodoan az ellenseg mar nem a Forrason fog 
				 * allni, igy az ellenseg objektum isSource tagvaltozojat hamisra allitjuk.
				 */
				if (arg instanceof Road) {
					Road road = (Road)arg;
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(human.picLabel, 0);
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].validate();
					human.setSource(false);
				}
			}
			else {
				/**
				 * Ha az ellenseg a Uton allo
				 */
				if (arg instanceof Road) {
					/**
					 * ... akkor a Road poziciojara rajzolodjon ki az adott elleseg, a regi helyerol torolje
					 * majd az ujonnan kapott ut poziciojara rajzolodjon ki ujra
					 */
					Road road = (Road)arg;
					
					if(human.getPreviousRoad() != null) {
						Component[] comp = GraphicsArea.tile[human.getPreviousRoad().getPos().getX()][human.getPreviousRoad().getPos().getY()].getComponents();
						for(int i = 0; i < comp.length; i++) {
							if(comp[i] == human.picLabel) {
								GraphicsArea.tile[human.getPreviousRoad().getPos().getX()][human.getPreviousRoad().getPos().getY()].remove(i);
								GraphicsArea.tile[human.getPreviousRoad().getPos().getX()][human.getPreviousRoad().getPos().getY()].repaint();
							}
						}
					}
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(human.picLabel, 0);
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].repaint();
				}
			}
	    }

		/**
		 * Ha az parameterul kapott megfigyelheto objektum egy elf, akkor
		  * a masik parameterben kapott objektum, ez esetben Road...
		 */
		else if(o instanceof Elf) {
			Elf elf = (Elf) o;
			/**
			 * Ha az ellenseg a Forrason all
			 */
			if(elf.isSource) {
				/**
				 * ... akkor a Road poziciojara rajzolodjon ki az adott elleseg, melyet
				 * a GraphicsArea osztaly tile (JPanel tomb) valzotojanak megfelelo ertekehez valo
				 * hozzaadassal erunk el, ezutan validalnunk, azaz ervenyesiteni kell a 
				 * kirajzolast, igy fogja tudni a GraphicsArea osztaly, hogy az ellenseg ki kell
				 * kirajzolni. 
				 * Mivel a kapott objektum Road tipusu, ebbol adodoan az ellenseg mar nem a Forrason fog 
				 * allni, igy az ellenseg objektum isSource tagvaltozojat hamisra allitjuk.
				 */
				if (arg instanceof Road) {
					Road road = (Road)arg;
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(elf.picLabel, 0);
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].validate();
					elf.setSource(false);
				}
			}
			else {
				/**
				 * Ha az ellenseg a Uton allo
				 */
				if (arg instanceof Road) {
					/**
					 * ... akkor a Road poziciojara rajzolodjon ki az adott elleseg, a regi helyerol torolje
					 * majd az ujonnan kapott ut poziciojara rajzolodjon ki ujra
					 */
					Road road = (Road)arg;
					
					if(elf.getPreviousRoad() != null) {
						Component[] comp = GraphicsArea.tile[elf.getPreviousRoad().getPos().getX()][elf.getPreviousRoad().getPos().getY()].getComponents();
						for(int i = 0; i < comp.length; i++) {
							if(comp[i] == elf.picLabel) {
								GraphicsArea.tile[elf.getPreviousRoad().getPos().getX()][elf.getPreviousRoad().getPos().getY()].remove(i);
								GraphicsArea.tile[elf.getPreviousRoad().getPos().getX()][elf.getPreviousRoad().getPos().getY()].repaint();
							}
						}
					}
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(elf.picLabel, 0);
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].repaint();
				}
			}
	    }

		/**
		 * Ha az parameterul kapott megfigyelheto objektum egy dwarf, akkor
		  * a masik parameterben kapott objektum, ez esetben Road...
		 */
		else if(o instanceof Dwarf) {
			Dwarf dwarf = (Dwarf) o;
			/**
			 * Ha az ellenseg a Forrason all
			 */
			if(dwarf.isSource) {
				if (arg instanceof Road) {
					/**
					 * ... akkor a Road poziciojara rajzolodjon ki az adott elleseg, melyet
					 * a GraphicsArea osztaly tile (JPanel tomb) valzotojanak megfelelo ertekehez valo
					 * hozzaadassal erunk el, ezutan validalnunk, azaz ervenyesiteni kell a 
					 * kirajzolast, igy fogja tudni a GraphicsArea osztaly, hogy az ellenseg ki kell
					 * kirajzolni. 
					 * Mivel a kapott objektum Road tipusu, ebbol adodoan az ellenseg mar nem a Forrason fog 
					 * allni, igy az ellenseg objektum isSource tagvaltozojat hamisra allitjuk.
					 */
					Road road = (Road)arg;
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(dwarf.picLabel, 0);
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].validate();
					dwarf.setSource(false);
				}
			}
			else {
				/**
				 * Ha az ellenseg a Uton allo
				 */
				if (arg instanceof Road) {					
					/**
					 * ... akkor a Road poziciojara rajzolodjon ki az adott elleseg, a regi helyerol torolje
					 * majd az ujonnan kapott ut poziciojara rajzolodjon ki ujra
					 */
					Road road = (Road)arg;
					
					if(dwarf.getPreviousRoad() != null) {
						Component[] comp = GraphicsArea.tile[dwarf.getPreviousRoad().getPos().getX()][dwarf.getPreviousRoad().getPos().getY()].getComponents();
						for(int i = 0; i < comp.length; i++) {
							if(comp[i] == dwarf.picLabel) {
								GraphicsArea.tile[dwarf.getPreviousRoad().getPos().getX()][dwarf.getPreviousRoad().getPos().getY()].remove(i);
								GraphicsArea.tile[dwarf.getPreviousRoad().getPos().getX()][dwarf.getPreviousRoad().getPos().getY()].repaint();
							}
						}
					}
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].add(dwarf.picLabel, 0);
					GraphicsArea.tile[road.getPos().getX()][road.getPos().getY()].repaint();
				}
			}
	    }
	}

}
