package com.example.mars.rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.mars.rover.core.Rover;
import com.example.mars.rover.core.enumeration.CardinalPoints;


class MarsRoverApplicationTests {

	Rover rover;
	
	@BeforeEach
	public void load() {
//		rover = new Rover(0, 0, CardinalPoints.NORTH.getAcronym());
	}
	
//	@Test
//	void contextLoads() {
//	}

	@Test
	@DisplayName("Robot Rover 2 forward and 1 left")
	void shouldWalkThreeSteps() {
		
		char[] steps = {'f','f','r'};
		
		rover = new Rover(1, 0, CardinalPoints.EAST.getAcronym());
		rover.procesMovements(steps);
		
		assertEquals(3, rover.getPoint().getPositionLatitude());
		assertEquals(1, rover.getPoint().getPositionLongitude());
	}
	
	@Test
	@DisplayName("Robot Rover encuentra un obstaculo")
	void shouldMeetObstacle() {
		
		char[] steps = {'f','f','f'};
		
		rover = new Rover(1, 3, CardinalPoints.EAST.getAcronym());
		rover.procesMovements(steps);
		
		System.out.println(rover.getPoint().toString());
		assertEquals(2, rover.getPoint().getPositionLatitude());
		assertEquals(3, rover.getPoint().getPositionLongitude());
	}
}
