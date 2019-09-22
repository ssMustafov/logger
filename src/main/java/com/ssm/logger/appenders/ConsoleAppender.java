package com.ssm.logger.appenders;

import com.ssm.logger.LogLevel;
import com.ssm.logger.formatters.Formatter;

import java.util.Date;

/**
 * @author smustafov
 */
public class ConsoleAppender implements Appender {

    private Formatter formatter;

    public ConsoleAppender(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void append(LogLevel logLevel, String message) {
        String formatted = formatter.format(new Date(), logLevel, message);
        System.out.println(formatted);
    }

}
