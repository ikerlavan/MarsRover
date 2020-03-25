package com.example.mars.rover.core.abstraction;

import com.example.mars.rover.core.Point;

public class PointX implements Substrable {

	int positionX;
	
	public PointX(int positionX) {
		
	}

	@Override
	public void removeFrom(Point point) {
		point.substractLatitude();
		
	}

	
}
