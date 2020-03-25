package com.example.mars.rover.core.puntos.cardinales;

import java.awt.Point;

import com.example.mars.rover.core.Mapa;

public abstract class Movements implements PuntoCardinal{

	public abstract void aplicaReglaDeAvance(Point currentPoint, Mapa mapa);
	
	@Override
	public void advance(Point point, Mapa mapa) {
		aplicaReglaDeAvance(point, mapa);
	}

	@Override
	public Point getNextPosition(Point currentPoint, Mapa mapa){

		Point nextPoint = (Point) currentPoint.clone();
		aplicaReglaDeAvance(nextPoint, mapa);
		return nextPoint;
	}
	
	
	
}
