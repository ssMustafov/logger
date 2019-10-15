package com.ssm.logger;

/**
 * @author smustafov
 */
public enum LogLevel {
    TRACE(0),
    DEBUG(1),
    INFO(2),
    WARN(3),
    ERROR(4),
    FATAL(5);

    private int order;

    LogLevel(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}
