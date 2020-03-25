package com.example.mars.rover.core.puntos.cardinales;

import java.awt.Point;

import com.example.mars.rover.core.Mapa;
import com.example.mars.rover.core.enumeration.CardinalPoints;


public class Este extends Movements {

	public static final char EAST = 'E';
	
	@Override
	public void aplicaReglaDeAvance(Point currentPoint, Mapa mapa){
		
		if (mapa.isBorder(currentPoint, EAST))
			currentPoint.x = mapa.crossTheBorderLine(EAST);
		else
			currentPoint.x += 1;
	}
	
	@Override
	public PuntoCardinal left() {
		return CardinalPoints.NORTH.getPuntoCardinal();
	}

	@Override
	public PuntoCardinal right() {
		return CardinalPoints.SOUTH.getPuntoCardinal();
	}

}
