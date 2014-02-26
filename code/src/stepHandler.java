void stepHandler(){
	
	for(Iterator<Enemy> i = association.member.active.iterator(); i.hasNext(); ) {
	    Enemy e = i.next();
	    Pos p = i.currentPos();

	    switch (i.isSlowed) { //vizsgáljuk lassitva van-e egy ellenseg
	    
	    	case 0: { //ha nincs lassitva
		    	if(playingArea.area[p.x][p.y].getType == Obstacle){ //es akadalyon all akkor
		    		i.stepTimer+=playingArea.area[p.x][p.y].getSlowingFactor();  //noveljuk meg a stepTimeret az akadaly lassitasanak mertekevel
		    		// ezt nem lattam az Obstacle osztalyban, ezert neveztem igy, de lenyegeben 
		    		// a lassitas merteke a varazskovet is beleszamitva ha van
		    		i.isSlowed = 1; //es a vegen allitsuk be a flaget, hogy lassitva van
		    	} else {
		    		i.move(); //ha nem akadalyon all akkor (de nincs lassitva ugye, mert az isSlowed itt meg mindig 0) akkor lepjen egyet
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
