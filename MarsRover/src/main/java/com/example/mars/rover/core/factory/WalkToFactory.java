package com.example.mars.rover.core.factory;

import com.example.mars.rover.core.Point;
import com.example.mars.rover.core.WalkingTo;
import com.example.mars.rover.core.WalkingToEast;
import com.example.mars.rover.core.WalkingToNorth;
import com.example.mars.rover.core.WalkingToNull;
import com.example.mars.rover.core.WalkingToSouth;
import com.example.mars.rover.core.WalkingToWest;
import com.example.mars.rover.core.enumeration.CardinalPoints;

public class WalkToFactory {

	private WalkToFactory() {
		throw new IllegalStateException("Factory class");
	}
	
	public static WalkingTo getWalkingTo(char lookToDirection, Point point) {

		if (lookToDirection == CardinalPoints.NORTH.getAcronym())
			return new WalkingToNorth(point);
		
		else if(lookToDirection == CardinalPoints.SOUTH.getAcronym())
			return new WalkingToSouth(point);
		
		else if(lookToDirection == CardinalPoints.EAST.getAcronym())
			return new WalkingToEast(point);
		
		else if(lookToDirection == CardinalPoints.WEST.getAcronym())
			return new WalkingToWest(point);
		
		else
			return new WalkingToNull(point);
		
	}
}
