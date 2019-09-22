package com.ssm.logger.formatters;

import com.ssm.logger.LogLevel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author smustafov
 */
public class SimpleFormatter implements Formatter {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

    @Override
    public String format(Date date, LogLevel logLevel, String message) {
        String formattedDate = DATE_FORMAT.format(date);
        return String.format("%s  %s  %s", formattedDate, logLevel, message);
    }

}
