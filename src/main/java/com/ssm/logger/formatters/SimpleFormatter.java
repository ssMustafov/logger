package com.ssm.logger.formatters;

import com.ssm.logger.context.LoggerContext;

import java.text.SimpleDateFormat;

/**
 * @author smustafov
 */
public class SimpleFormatter implements Formatter {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

    @Override
    public String format(LoggerContext context) {
        String formattedDate = DATE_FORMAT.format(context.getDate());
        return String.format("%s  %s  %s", formattedDate, context.getLogLevel(), context.getMessage());
    }

}
