package com.example.mars.rover.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.example.mars.rover.core.factory.WalkToFactory;

import lombok.Data;

@Component
@Data
public class Rover {

	private static final Logger log = LogManager.getLogger(Rover.class.getName());
	
	private Point point;
	
	WalkingTo walk;
	
	public Rover (int initX, int initY, char lookInDirection) {
		point = new Point(initX, initY);
		walk = WalkToFactory.getWalkingTo(lookInDirection, point);
	}
	
	public void procesMovements(char[] movements) {
		for(int index = 0 ; index<movements.length ; index++) {
			if(!walk.hasObstacle())
				walk.move(movements[index]);
			else
				log.error("I have found an obstacle my last coordinate is ({},{}) ",
						walk.getFuturePoint().getPositionLatitude(), 
						walk.getFuturePoint().getPositionLongitude());
				
		}
	}
	
	
}
