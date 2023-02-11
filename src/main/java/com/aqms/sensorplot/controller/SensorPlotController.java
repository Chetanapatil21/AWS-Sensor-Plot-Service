package com.aqms.sensorplot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aqms.sensorplot.FileUtil;
import com.aqms.sensorplot.model.SensorPlot;
import com.aqms.sensorplot.service.SensorPlotService;

import jakarta.validation.Valid;

// Rest Controller for Sensor Plot

@RestController
@RequestMapping("/SensorPlot")
//This class acts as the Controller in the MVC architecture and handles incoming HTTP requests
public class SensorPlotController {
	// Controller Level Logging
	// Logger to log information, warnings, and errors
	private Logger log = FileUtil.getLogger(SensorPlotController.class);

	// SensorPlotService instance to perform business logic related to SensorPlot
	private SensorPlotService sensorPlotService;

	// Constructor to initialize the SensorPlotService instance
	public SensorPlotController(SensorPlotService sensorPlotService) {
		super();
		this.sensorPlotService = sensorPlotService;
	}

	// This method maps the incoming HTTP POST request to "/post" and saves the SensorPlot data in the database
	@PostMapping("/post")
	@ResponseBody
	public SensorPlot saveSensorPlotControl(@RequestBody @Valid SensorPlot sensorPlot) {
		log.info("Sensor Details is being saved with data:\n" + sensorPlot);
		return sensorPlotService.saveSensorPlot(sensorPlot);
	}

	// This method maps the incoming HTTP GET request to "/all" and returns all the SensorPlot data from the database
	@GetMapping("/all")
	@ResponseBody
	public List<SensorPlot> getSensorPlotAllControl(){
		log.info("Getting all Sensor Details");
		return sensorPlotService.getSensorPlotAll();
	}

	// This method maps the incoming HTTP GET request to "/find/{sensorid}" and returns the SensorPlot data for the given sensorid from the database
	@GetMapping("/find/{sensorid}")
	@ResponseBody
	public SensorPlot getSensorPlotUsingIdControl(@PathVariable("sensorid") String sensorid) {
		log.info("Getting the sensor details of the sensor with id: "+sensorid);
		return sensorPlotService.getSensorPlotById(sensorid);
	}
}