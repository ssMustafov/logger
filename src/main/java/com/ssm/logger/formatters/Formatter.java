package com.ssm.logger.formatters;

import com.ssm.logger.context.LoggerContext;

/**
 * Used for formatting the log messages per {@link com.ssm.logger.appenders.Appender}.
 *
 * @author smustafov
 */
public interface Formatter {

    String format(LoggerContext context);

}
