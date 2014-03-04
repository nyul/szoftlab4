void stepHandler(){
	
char ures = 0;
char ut = 1;
char akadaly = 2;
char hegy = 3;
char source = 4;
	
	for(Iterator<Enemy> i = fellowship.wave.active.iterator(); i.hasNext(); ) {
	    Enemy e = i.next(); //aktualis ellenseg
	    Pos cp = i.currentPos(); //currentPos
	    Tile type = area.tiles.get(p.x).get(p.y).getType();

	    switch (i.isSlowed) { //vizsgáljuk lassitva van-e egy ellenseg
	    
	    	case 0: { //ha nincs lassitva
		    	if(tpye == akadaly){ //es akadalyon all akkor
		    		i.stepTimer+=playingArea.area[p.x][p.y].getSlowingFactor();  //noveljuk meg a stepTimeret az akadaly lassitasanak mertekevel
		    		i.isSlowed = 1; //es a vegen allitsuk be a flaget, hogy lassitva van
		    	} else if(type == hegy){ //a hegyre lép
				defeat(); //ez egy engine osztalybeli metodus, megallitja a futast és kiirja, hogy vesztettel		    		
		    	} else {
				i.move(np); //ha nem akadalyon all akkor (de nincs lassitva ugye, mert az isSlowed itt meg mindig 0) akkor lepjen egyet
			}
		    	break;
	    	}
	    	
	    	case 1: { //ha lasssitva van
	    		if(i.stepTimer > 1){ //es a stepTimer nagyobb mint 1 tehat valoban lassitva van
	    			i.stepTimer-=1; //akkor a stepTimert csokkentsük egyel, ugye ez az egesz ag stepenkent 1x fut le, tehat minden tizedik tickben
	    		}
	    		break;
	    	}
	    	
	    }

	}
}
