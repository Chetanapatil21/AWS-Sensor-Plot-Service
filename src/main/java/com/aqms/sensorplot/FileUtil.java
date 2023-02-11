package com.aqms.sensorplot;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Utility Class

/**
 * FileUtil is a Utility class containing helper methods for various purposes.
 */
public final class FileUtil {

	/**
	 * A constant that defines the maximum number of floors in a building.
	 * This value can be changed based on business requirements.
	 */
	public static final int maxFloor = 3;

	/**
	 * A constant that defines the maximum number of rooms in a building.
	 * This value can be changed based on business requirements.
	 */
	public static final int maxRoom = 8;

	/**
	 * Private constructor to prevent instantiation of this class.
	 * This class should only be used to access its static methods.
	 */
	private FileUtil() {
	}

	/**
	 * A method to get a logger instance for a class.
	 *
	 * @param clas The class for which a logger instance needs to be obtained.
	 * @return The logger instance for the given class.
	 */
	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class clas) {
		Logger logger = LoggerFactory.getLogger(clas);
		return logger;
	}
}
