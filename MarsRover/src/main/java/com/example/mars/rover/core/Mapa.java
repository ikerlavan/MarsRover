package com.example.mars.rover.core;

import java.awt.Point;

public class Mapa {

	public static final int OBSTACLE = 1;

	int[][] mapa = {
			{0,0,0,0,0,0},
			{0,0,0,0,0,0},
			{0,0,OBSTACLE,0,0,0},
			{0,0,0,0,0,0},
			{0,0,0,0,0,0}
	};
	
	public int[][] getMapa() {
		return mapa;
	}
	
	
	public boolean existObstacle(Point nextPosition) {
		if( OBSTACLE == mapa[nextPosition.y][nextPosition.x])
			return true;
		
		return false;
	}
	
	public boolean isBorder(Point currentPosition, char direction) {
		
		switch(direction) {
			case 'E':
				return currentPosition.x == mapa[0].length - 1;
			case 'W':
				return currentPosition.x == 0;
			case 'N':
				return currentPosition.y == mapa.length -1;
			case 'S':
				return currentPosition.y == 0;
			default:
				return false;
		}
		
	}
	
	public int crossTheBorderLine( char direction ) {
		
		if (direction == 'E')
			return 0;
		
		else if (direction == 'W')
			return mapa[0].length - 1;
		
		else if (direction == 'N')
			return 0;
		
		else 
			return mapa.length - 1;

	}
	
}
