package com.ssm.logger.formatters;

import com.ssm.logger.context.LoggerContext;

/**
 * @author smustafov
 */
public interface Formatter {

    String format(LoggerContext context);

}
