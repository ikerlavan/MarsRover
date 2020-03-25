package com.example.mars.rover;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.mars.rover.core.Rover;
import com.example.mars.rover.core.enumeration.CardinalPoints;

@SpringBootApplication
public class MarsRoverApplication implements CommandLineRunner{

	private static final Logger log = LogManager.getLogger(MarsRoverApplication.class.getName());

	@Autowired
	Rover rover;
	
	public static void main(String[] args) {
		SpringApplication.run(MarsRoverApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		new Rover(1, 1, CardinalPoints.NORTH.getAcronym());
		
	}

}
