package com.example.mars.rover.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.Data;

@Data
public abstract class WalkingTo {

	private static final Logger log = LogManager.getLogger(WalkingTo.class.getName());

	public static final char OBSTACLE = 'X';

	protected char[][] mars = { 
			{ ' ', ' ', ' ', ' ' }, 
			{ ' ', ' ', ' ', ' ' }, 
			{ ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', OBSTACLE } 
			};

	public enum Operacion {
		AFTER, BEFORE
	}
	
	public enum Axis {
		LONGITUDE, LATITUDE
	}

	private Point point;
	
	private Point futurePoint;
	
	private boolean seeObstacle = false;

	abstract void move(char step);
	
	
	public WalkingTo (Point point) {
		this.point = point;
	}
	
	public boolean hasObstacle() {
		return seeObstacle;
	}

	protected void execute(Operacion operacion, Axis axis) {
		futurePoint = point.clone(point);
		
		if (Operacion.AFTER == operacion) {
			
			if(Axis.LATITUDE == axis) {
				futurePoint.sumLatitude();
				simulateAdvanceLatitude();
				
			}else {
				futurePoint.sumLongitude();
				simulateAdvanceLongitude();
			}
		}

		if (Operacion.BEFORE == operacion) {
			
			if(Axis.LATITUDE == axis) {
				futurePoint.substractLatitude();
				simulateBackLatitude();
				
			}else {
				futurePoint.substractLongitude();
				simulateBackLongitude();
			}
		}
	}
	
	private void simulateAdvanceLatitude() {
		
		if (futurePoint.getPositionLatitude() >= mars.length &&
				!existObstacle( new Point(0, futurePoint.getPositionLongitude()) ) )
			point.setPositionLatitude(0);
		
		else if (!existObstacle(futurePoint))
			point.setPositionLatitude(futurePoint.getPositionLatitude());
		
	}
	
	private void simulateBackLatitude() {
		int newLatitude = mars.length - 1;
		
		if (futurePoint.getPositionLatitude() < 0  &&
				!existObstacle( new Point(newLatitude, futurePoint.getPositionLongitude()) ) )
			
			point.setPositionLatitude(newLatitude);
			
		else if (!existObstacle(futurePoint))
			point.substractLatitude();
	}

	private void simulateAdvanceLongitude() {
		
		if (futurePoint.getPositionLongitude() >= mars[point.getPositionLongitude()].length  &&
				!existObstacle( new Point(futurePoint.getPositionLatitude(), 0) ) )
			point.setPositionLongitude(0);

		else if (!existObstacle(futurePoint))
			point.sumLongitude();
	}
		
	private void simulateBackLongitude() {
		int newLongitude = mars[point.getPositionLatitude()].length - 1;
		
		if (futurePoint.getPositionLongitude() < 0  &&
				!existObstacle( new Point(futurePoint.getPositionLatitude(), newLongitude) ) )
			
			point.setPositionLongitude(newLongitude);

		else if (!existObstacle(futurePoint))
			point.substractLongitude();
	}
	
	private boolean existObstacle(Point futurePosiblePoint) {
		log.debug("Coordenadas de Rover: ({}, {})", point.getPositionLatitude(), point.getPositionLongitude());

		if (mars[futurePosiblePoint.getPositionLatitude()][futurePosiblePoint.getPositionLongitude()] == OBSTACLE) {

			log.warn("Obstáculo en el punto {}, {}", futurePoint.getPositionLatitude(), futurePoint.getPositionLongitude());

			seeObstacle = true;
			futurePoint = futurePosiblePoint;

			return seeObstacle;
		}
		return false;
	}


	
}
