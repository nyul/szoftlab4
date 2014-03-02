void stepHandler(){
	
	for(Iterator<Enemy> i = fellowship.wave.active.iterator(); i.hasNext(); ) {
	    Enemy e = i.next();
	    Pos p = i.currentPos();

	    switch (i.isSlowed) { //vizsg�ljuk lassitva van-e egy ellenseg
	    
	    	case 0: { //ha nincs lassitva
		    	if(playingArea.area[p.x][p.y].getType == Obstacle){ //es akadalyon all akkor
		    		i.stepTimer+=playingArea.area[p.x][p.y].getSlowingFactor();  //noveljuk meg a stepTimeret az akadaly lassitasanak mertekevel
		    		i.isSlowed = 1; //es a vegen allitsuk be a flaget, hogy lassitva van
		    	} else if(playingArea.area[p.x][p.y].getType == Mountain){ //a hegyre l�p
				defeat(); //ez egy engine osztalybeli metodus, megallitja a futast �s kiirja, hogy vesztettel		    		
		    	} else { 
				i.move(); //ha nem akadalyon all akkor (de nincs lassitva ugye, mert az isSlowed itt meg mindig 0) akkor lepjen egyet
			}
		    	break;
	    	}
	    	
	    	case 1: { //ha lasssitva van
	    		if(i.stepTimer > 1){ //es a stepTimer nagyobb mint 1 tehat valoban lassitva van
	    			i.stepTimer-=1; //akkor a stepTimert csokkents�k egyel, ugye ez az egesz ag stepenkent 1x fut le, tehat minden tizedik tickben
	    		}
	    		break;
	    	}
	    	
	    }

	}
}
