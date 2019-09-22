package com.ssm.logger.appenders;

import com.ssm.logger.LogLevel;

/**
 * Provides facility to append messages to a location. The location could be console, file, database, etc.
 *
 * @author smustafov
 */
public interface Appender {

    void append(LogLevel logLevel, String message);

}
