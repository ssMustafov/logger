package com.ssm.logger.formatters;

import com.ssm.logger.LogLevel;

import java.util.Date;

/**
 * @author smustafov
 */
public interface Formatter {

    String format(Date date, LogLevel info, String message);

}
