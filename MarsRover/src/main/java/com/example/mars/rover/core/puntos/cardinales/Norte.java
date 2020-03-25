package com.example.mars.rover.core.puntos.cardinales;

import java.awt.Point;

import com.example.mars.rover.core.Mapa;
import com.example.mars.rover.core.enumeration.CardinalPoints;

public class Norte extends Movements{
	
	public static final char NORTH = 'N';
	
	@Override
	public void aplicaReglaDeAvance(Point currentPoint, Mapa mapa){
		
		if (mapa.isBorder(currentPoint, NORTH))
			currentPoint.y = mapa.crossTheBorderLine(NORTH);
		else
			currentPoint.y += 1;
	}
	
	@Override
	public PuntoCardinal left() {
		return CardinalPoints.WEST.getPuntoCardinal();
	}
	
	@Override
	public PuntoCardinal right() {
		return CardinalPoints.EAST.getPuntoCardinal();
	}

}

