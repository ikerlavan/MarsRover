package com.example.mars.rover.core;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Point {
	
	private static final int UNO = 1; 
	
	private int positionLatitude;
	private int positionLongitude;
	
	public Point(int positionLatitude, int positionLongitude) {
		this.positionLatitude = positionLatitude;
		this.positionLongitude = positionLongitude;
	}
	
	public void substractLongitude() {
		positionLongitude -= UNO;
	}
	
	public void sumLongitude() {
		positionLongitude += UNO;
	}
	
	public void substractLatitude() {
		positionLatitude -= UNO;
	}
	
	public void sumLatitude() {
		positionLatitude += UNO;
	}

	public Point clone(Point point) {
		return new Point(point.positionLatitude, point.positionLongitude);
	}
}
