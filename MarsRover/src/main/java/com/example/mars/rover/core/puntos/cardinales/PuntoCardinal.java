package com.example.mars.rover.core.puntos.cardinales;

import java.awt.Point;

import com.example.mars.rover.core.Mapa;

public interface PuntoCardinal {

	void advance(Point point, Mapa map);
	
	Point getNextPosition(Point currentPoint, Mapa mapa);
	
	PuntoCardinal left();
	
	PuntoCardinal right();
}
