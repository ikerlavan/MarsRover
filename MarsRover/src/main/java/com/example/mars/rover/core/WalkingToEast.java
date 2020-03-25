package com.example.mars.rover.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WalkingToEast extends WalkingTo {
	
	public WalkingToEast(Point point) {
		super(point);
	}

	private static final Logger log = LogManager.getLogger(WalkingToEast.class.getName());
	
	@Override
	public void move(char step) {
		if(step == 'f') {
			log.debug("Forward [][+1]");
			execute(Operacion.AFTER, Axis.LATITUDE);
		}
		
		else if(step == 'b') {
			log.debug("Backward [][-1]");
			execute(Operacion.BEFORE, Axis.LATITUDE);
		}
				
		else if(step == 'l') {
			log.debug("Left [-1][]");
			execute(Operacion.BEFORE, Axis.LONGITUDE);
		}
					
		else if(step == 'r') {
			log.debug("Right [+1][]");
			execute(Operacion.AFTER, Axis.LONGITUDE);
		}
	}


}
