package com.ssm.logger.context;

import com.ssm.logger.LogLevel;

import java.util.Date;

/**
 * @author smustafov
 */
public class LoggerContext {

    private Date date;
    private LogLevel logLevel;
    private String message;

    public static LoggerContext build(LogLevel logLevel, String message) {
        return build(new Date(), logLevel, message);
    }

    public static LoggerContext build(Date date, LogLevel logLevel, String message) {
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.date = date;
        loggerContext.logLevel = logLevel;
        loggerContext.message = message;
        return loggerContext;
    }

    public Date getDate() {
        return date;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getMessage() {
        return message;
    }
}
