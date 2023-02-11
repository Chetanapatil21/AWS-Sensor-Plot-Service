package com.aqms.sensorplot.advice;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aqms.sensorplot.FileUtil;
import com.aqms.sensorplot.controller.SensorPlotController;
import com.aqms.sensorplot.exception.ResourceNotFoundException;

@RestControllerAdvice
public class ServiceExceptionHandler {
	
	// Logger instantiation for class SensorPlotController
	Logger log = FileUtil.getLogger(SensorPlotController.class);
	// Exception handler for bad request, when the data doesn't pass the validations
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidInput(MethodArgumentNotValidException ex) {
		// Create a map to store error messages
		Map<String, String> errorMap = new HashMap<>();
		// Loop through the validation errors and add them to the map
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		// Log the error messages
		log.info("Bad Data given with the following errors:\n\n" + errorMap);
		// Return the error messages
		return errorMap;
	}

	// Exception handler for resource not found, when the requested data doesn't exist in the database
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ResourceNotFoundException.class)
	public Map<String, String> handleResourceNotFoundException(ResourceNotFoundException ex) {
		// Create a map to store error messages
		Map<String, String> errorMap = new HashMap<>();
		// Add the error message to the map
		errorMap.put("errorMessage", ex.getResourceName()+" of sensor :"+ex.getFieldValue()+" Not found");
		// Log the error message
		log.info("No Data found with the following errors:\n\n" + errorMap);
		// Return the error message
		return errorMap;
	}

	// Exception handler for bad request, when a value cannot be contained in the required data type
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Map<String, String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		// Create a map to store error messages
		Map<String, String> errorMap = new HashMap<>();
		// Add the error message to the map
		errorMap.put("errorMessage", ex.getMessage());
		// Log the error message
		log.info("Not Readable Exception with the following errors:\n\n" + errorMap);
		// Return the error message
		return errorMap;
	}

	// Generic exception handler for any unhandled exceptions
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String genericExceptionHandler(Exception ex) {
		// Log the generic exception
		log.info("Generic Exception");
		// Return a generic error message
		return "Generic Exception: Request Failed";
	}
}