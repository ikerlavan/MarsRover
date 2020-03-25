package com.example.mars.rover.core.puntos.cardinales;

import java.awt.Point;

import com.example.mars.rover.core.Mapa;
import com.example.mars.rover.core.enumeration.CardinalPoints;


public class Sur extends Movements {

	public static final char SOUTH = 'S';
	
	@Override
	public void aplicaReglaDeAvance(Point currentPoint, Mapa mapa){
		
		if (mapa.isBorder(currentPoint, SOUTH))
			currentPoint.y = mapa.crossTheBorderLine(SOUTH);
		else
			currentPoint.y -= 1;
	}
	
	public PuntoCardinal left() {
		return CardinalPoints.EAST.getPuntoCardinal();
	}

	public PuntoCardinal right() {
		return CardinalPoints.WEST.getPuntoCardinal();
	}

}
