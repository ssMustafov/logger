package com.ssm.logger.appenders;

import com.ssm.logger.context.LoggerContext;
import com.ssm.logger.formatters.Formatter;

/**
 * @author smustafov
 */
public abstract class BaseAppender implements Appender {

    protected Formatter formatter;

    public BaseAppender(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void append(LoggerContext context) {
        String formatted = formatter.format(context);
        doAppend(context, formatted);
    }

    protected abstract void doAppend(LoggerContext context, String formatted);
}
