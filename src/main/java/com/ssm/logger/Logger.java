package com.ssm.logger;

import com.ssm.logger.appenders.Appender;
import com.ssm.logger.context.LoggerContext;

import java.util.List;

/**
 * Main class used for logging messages.
 *
 * @author smustafov
 */
public class Logger {

    private List<Appender> appenders;

    public Logger(List<Appender> appenders) {
        this.appenders = appenders;
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }

    public void trace(String message) {
        log(LogLevel.TRACE, message);
    }

    private void log(LogLevel logLevel, String message) {
        appenders.forEach(appender -> appender.append(LoggerContext.build(logLevel, message)));
    }

}
