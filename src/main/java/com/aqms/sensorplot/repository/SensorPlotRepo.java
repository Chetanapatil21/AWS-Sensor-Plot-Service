package com.aqms.sensorplot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.aqms.sensorplot.model.SensorPlot;

@Repository
public class SensorPlotRepo {

	// Autowiring the DynamoDBMapper bean to perform operations in the database
	@Autowired
	DynamoDBMapper mapper;

	// Method to save the SensorPlot data to the database
	public SensorPlot save(SensorPlot sensorPlot) {
		// Persist the SensorPlot data to the database
		mapper.save(sensorPlot);
		return sensorPlot;
	}

	// Method to retrieve all the SensorPlot data from the database
	public List<SensorPlot> findAll() {
		// Scan the SensorPlot table in the database and return all the data
		return mapper.scan(SensorPlot.class, new DynamoDBScanExpression());
	}

	// Method to retrieve a specific SensorPlot data from the database using the Sensor ID
	public SensorPlot findById(String sensorid) {
		// Load the SensorPlot data from the database using the Sensor ID
		return mapper.load(SensorPlot.class,sensorid);
	}


}
