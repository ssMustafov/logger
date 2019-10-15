package com.ssm.logger.appenders;

import com.ssm.logger.LogLevel;
import com.ssm.logger.context.LoggerContext;
import com.ssm.logger.formatters.Formatter;

/**
 * @author smustafov
 */
public abstract class BaseAppender implements ThresholdableAppender {

    protected Formatter formatter;

    protected LogLevel thresholdLevel;

    public BaseAppender(Formatter formatter) {
        this.formatter = formatter;
        this.thresholdLevel = LogLevel.TRACE;
    }

    public BaseAppender(Formatter formatter, LogLevel thresholdLevel) {
        this.formatter = formatter;
        this.thresholdLevel = thresholdLevel;
    }

    @Override
    public void append(LoggerContext context) {
        if (context.getLogLevel().getOrder() >= thresholdLevel.getOrder()) {
            String formattedMessage = formatter.format(context);
            doAppend(context, formattedMessage);
        }
    }

    protected abstract void doAppend(LoggerContext context, String formattedMessage);

    @Override
    public LogLevel getThresholdLevel() {
        return thresholdLevel;
    }

    @Override
    public void setThresholdLevel(LogLevel thresholdLevel) {
        this.thresholdLevel = thresholdLevel;
    }
}
