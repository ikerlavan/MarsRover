package com.example.mars.rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.mars.rover.core.Rover2;
import com.example.mars.rover.core.puntos.cardinales.Este;
import com.example.mars.rover.core.puntos.cardinales.Norte;
import com.example.mars.rover.core.puntos.cardinales.Oeste;
import com.example.mars.rover.core.puntos.cardinales.Sur;

class MarsRoverTests {

	Rover2 rover;
	
	@BeforeEach
	public void load() {
		rover = new Rover2(0, 0, new Norte());
	}
		
	@Test
	void shouldMoveToNorth() {
		rover.getLookInDirection().advance(rover.getPoint(), rover.getMapa());
		assertEquals(1, rover.getPoint().y);
		assertEquals(0, rover.getPoint().x);
	}
	
	@Test
	void shouldMoveToWest() {
		rover = new Rover2(0, 0, new Oeste());
		rover.getLookInDirection().advance(rover.getPoint(), rover.getMapa());
		assertEquals(0, rover.getPoint().y);
		assertEquals(5, rover.getPoint().x);
	}
	
	@Test
	void shouldBackToInit() {
		rover = new Rover2(0, 0, new Sur());
		rover.getLookInDirection().advance(rover.getPoint(), rover.getMapa());
		assertEquals(4, rover.getPoint().y);
		assertEquals(0, rover.getPoint().x);
	}
	
	@Test
	void shouldMoveToWestFrom_1_0() {
		rover = new Rover2(1, 0, new Oeste());
		rover.getLookInDirection().advance(rover.getPoint(), rover.getMapa());
		assertEquals(0, rover.getPoint().y);
		assertEquals(0, rover.getPoint().x);
	}
	
	@Test
	void shoulWalkPath() {
		char[] steps = {'f','r','f','l', 'l', 'f', 'l', 'f'};
		rover.procesMovements(steps);
		assertEquals(0, rover.getPoint().y);
		assertEquals(0, rover.getPoint().x);
	}
	
	@Test
	void shouldWalkPathWest() {
		rover = new Rover2(0, 0, new Oeste());
		char[] steps = {'f','f','r','f','r','f'};
		rover.procesMovements(steps);
		assertEquals(1, rover.getPoint().y);
		assertEquals(5, rover.getPoint().x);
	}
	
	@Test
	void shouldImpactWithObstacle() {
		rover = new Rover2(0, 2, new Este());
		char[] steps = {'f','f','f','f'};
		rover.procesMovements(steps);
		assertEquals(2, rover.getPoint().y);
		assertEquals(1, rover.getPoint().x);
//		assertEquals(2, rover.getObstaclePoint().x);
	}

}
