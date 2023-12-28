package com.khadri.log4j.swiggy.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppLogger {

	private static Logger errorLogger;
	private static Logger serverLogger;
	private static Logger payloadLogger;

	private enum LogLevels {
		FATAL, ERROR, WARN, INFO, DEBUG, TRACE;
	}

	static {
		errorLogger = LogManager.getLogger("error.logger");
		serverLogger = LogManager.getLogger("server.logger");
		payloadLogger = LogManager.getLogger("swiggy.logger");
	}

	private AppLogger() {
	}

	private static void log(LogLevels logLevel, String message, Exception exception) {
		switch (logLevel) {
		case INFO:
			payloadLogger.info(message);
			break;
		case DEBUG:
			serverLogger.debug(message);
			break;
		case WARN:
			errorLogger.warn(message, exception);
			break;
		case ERROR:
			errorLogger.error(message, exception);
			break;
		default:
			break;
		}
	}

	public static void debug(String message) {
		log(LogLevels.DEBUG, message, null);
	}

	public static void info(String message) {
		log(LogLevels.INFO, message, null);
	}

	public static void trace(String message) {
		log(LogLevels.TRACE, message, null);
	}

	public static void warn(String message, Exception exception) {
		log(LogLevels.WARN, message, exception);
	}

	public static void error(String message, Exception exception) {
		log(LogLevels.ERROR, message, exception);
	}

	public static void swiggyInOutMessage(String message) {
		payloadLogger.info(message);
	}
}
