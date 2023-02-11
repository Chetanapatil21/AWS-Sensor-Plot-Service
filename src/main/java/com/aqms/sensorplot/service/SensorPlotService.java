package com.aqms.sensorplot.service;

import java.util.List;

import com.aqms.sensorplot.model.SensorPlot;

//Interface for Sensor Plot Service
public interface SensorPlotService {
	
	// Method to save a sensor plot data
	SensorPlot saveSensorPlot(SensorPlot sensorPlot);

	// Method to retrieve all sensor plot data from the database
	List<SensorPlot> getSensorPlotAll();

	// Method to retrieve a specific sensor plot data based on the given sensor id
	SensorPlot getSensorPlotById(String sensorid);

	
}
