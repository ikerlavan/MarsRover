package com.example.mars.rover.core.puntos.cardinales;

import java.awt.Point;

import com.example.mars.rover.core.Mapa;
import com.example.mars.rover.core.enumeration.CardinalPoints;


public class Oeste extends Movements{

	public static final char WEST = 'W';
	
	@Override
	public void aplicaReglaDeAvance(Point currentPoint, Mapa mapa){
		
		if (mapa.isBorder(currentPoint, WEST))
			currentPoint.x = mapa.crossTheBorderLine(WEST);
		else
			currentPoint.x -= 1;
	}
	
	@Override
	public PuntoCardinal left() {
		return CardinalPoints.SOUTH.getPuntoCardinal();
	}

	@Override
	public PuntoCardinal right() {
		return CardinalPoints.NORTH.getPuntoCardinal();
	}

}
