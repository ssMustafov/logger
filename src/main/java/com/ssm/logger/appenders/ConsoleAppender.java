package com.ssm.logger.appenders;

import com.ssm.logger.context.LoggerContext;
import com.ssm.logger.formatters.Formatter;

/**
 * @author smustafov
 */
public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Formatter formatter) {
        super(formatter);
    }

    @Override
    protected void doAppend(LoggerContext context, String formatted) {
        System.out.println(formatted);
    }

}
