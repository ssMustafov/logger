package com.ssm.logger.appenders;

import com.ssm.logger.LogLevel;

/**
 * {@link Appender} which has threshold {@link LogLevel}.
 *
 * @author smustafov
 */
public interface ThresholdableAppender extends Appender {

    void setThresholdLevel(LogLevel logLevel);

    LogLevel getThresholdLevel();

}
