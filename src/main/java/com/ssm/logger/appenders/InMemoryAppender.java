package com.ssm.logger.appenders;

import com.ssm.logger.LogLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * In memory implementation of {@link Appender}.
 *
 * @author smustafov
 */
public class InMemoryAppender implements Appender {

    private Map<String, LogLevel> messageMap = new HashMap<>();

    public LogLevel getLogLevel(String message) {
        return messageMap.get(message);
    }

    @Override
    public void append(LogLevel logLevel, String message) {
        messageMap.put(message, logLevel);
    }
}
