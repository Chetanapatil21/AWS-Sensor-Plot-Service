package com.aqms.sensorplot.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aqms.sensorplot.exception.ResourceNotFoundException;
import com.aqms.sensorplot.model.SensorPlot;
import com.aqms.sensorplot.repository.SensorPlotRepo;
import com.aqms.sensorplot.service.SensorPlotService;

// The implementation of the service interface
@Service
public class SensorPlotServiceImplement implements SensorPlotService {
	private SensorPlotRepo sensorPlotRepository;

	// Constructor to initialize the repository
	public SensorPlotServiceImplement(SensorPlotRepo sensorPlotRepository) {
		super();
		this.sensorPlotRepository = sensorPlotRepository;
	}

	// Method to save the sensor plot data into the database
	@Override
	public SensorPlot saveSensorPlot(SensorPlot sensorPlot) {
		return sensorPlotRepository.save(sensorPlot);
	}

	// Method to retrieve all the sensor plot data from the database
	@Override
	public List<SensorPlot> getSensorPlotAll() {
		return sensorPlotRepository.findAll();
	}

	// Method to retrieve a specific sensor plot data based on the sensor id
	@Override
	public SensorPlot getSensorPlotById(String sensorid) {
		SensorPlot sensorPlot = sensorPlotRepository.findById(sensorid);
		if(sensorPlot == null) {
			// If the sensor plot is not found in the database, a custom exception is thrown
			throw new ResourceNotFoundException("SensorPlot","SensorID",sensorid);
		}
		return sensorPlot;
	}
}