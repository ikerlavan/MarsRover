package com.example.mars.rover.core.enumeration;

import com.example.mars.rover.core.puntos.cardinales.*;

public enum CardinalPoints {
	NORTH(new Norte(), 'N'), SOUTH(new Sur(), 'S'), EAST(new Este(), 'E'), WEST(new Oeste(), 'O');
	
	private PuntoCardinal cardinalPoint;
	
	private char acronym;
	
	private CardinalPoints(PuntoCardinal cardinalPoint, char acronym) {
		this.cardinalPoint = cardinalPoint;
		this.acronym = acronym;
	}

	public PuntoCardinal getPuntoCardinal() {
		return cardinalPoint;
	}
	
	public char getAcronym() {
		return acronym;
	}
}
