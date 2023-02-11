package com.aqms.sensorplot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Resource Not Found Exception
@AllArgsConstructor
@Getter
//Class to handle resource not found exception
public class ResourceNotFoundException extends RuntimeException {
	// Serial version ID
	private static final long serialVersionUID = 1L;

	// Variables to store the name of the resource, field name, and field value
	private String resourceName;
	private String fieldName;
	private String fieldValue;

}

