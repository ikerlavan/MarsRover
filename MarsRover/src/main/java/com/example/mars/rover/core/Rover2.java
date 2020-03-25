package com.example.mars.rover.core;

import java.awt.Point;

import org.springframework.stereotype.Component;

import com.example.mars.rover.core.puntos.cardinales.PuntoCardinal;

import lombok.Data;

@Component
@Data
public class Rover2 {

	private Point point;
	
	PuntoCardinal lookInDirection;
	
	Mapa mapa;
	
	public Rover2(int initX, int initY, PuntoCardinal lookInDirection) {
		point = new Point(initX, initY);
		this.lookInDirection = lookInDirection;
		mapa = new Mapa();
	}

	public void move(char step) {
		
		if (step == 'f')
			lookInDirection.advance(point, mapa);

		else if (step == 'l')
			lookInDirection = lookInDirection.left();

		else if (step == 'r') 
			lookInDirection = lookInDirection.right();

	}
	
	public void procesMovements(char[] movements) {
		for(int index = 0 ; index<movements.length ; index++) 
			if(!mapa.existObstacle(this.getLookInDirection().getNextPosition(point, mapa)))
				move(movements[index]);
	}

}
