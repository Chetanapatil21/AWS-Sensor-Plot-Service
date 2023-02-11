package com.aqms.sensorplot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// Sensor Plot Application

//Annotation to declare this class as a spring boot application
@SpringBootApplication
//Annotation to enable discovery client for service registration and discovery
@EnableDiscoveryClient
public class SensorplotServiceApplication {

	public static void main(String[] args) {
		// Main method to run the spring application
		SpringApplication.run(SensorplotServiceApplication.class, args);
	}

}
