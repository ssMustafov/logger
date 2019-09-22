package com.ssm.logger;

import com.ssm.logger.appenders.InMemoryAppender;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class LoggerTest {

    private InMemoryAppender appender;
    private Logger logger;

    @Before
    public void beforeEach() {
        appender = new InMemoryAppender();
        logger = new Logger(Collections.singletonList(appender));
    }

    @Test
    public void shouldLogInfo() {
        logger.info("Success!");

        LogLevel logLevel = appender.getLogLevel("Success!");
        assertEquals(LogLevel.INFO, logLevel);
    }

    @Test
    public void shouldLogDebug() {
        logger.debug("Debug message");

        LogLevel logLevel = appender.getLogLevel("Debug message");
        assertEquals(LogLevel.DEBUG, logLevel);
    }

    @Test
    public void shouldLogError() {
        logger.error("Error message");

        LogLevel logLevel = appender.getLogLevel("Error message");
        assertEquals(LogLevel.ERROR, logLevel);
    }

    @Test
    public void shouldLogWarn() {
        logger.warn("Warn message");

        LogLevel logLevel = appender.getLogLevel("Warn message");
        assertEquals(LogLevel.WARN, logLevel);
    }

    @Test
    public void shouldLogFatal() {
        logger.fatal("Fatal message");

        LogLevel logLevel = appender.getLogLevel("Fatal message");
        assertEquals(LogLevel.FATAL, logLevel);
    }

    @Test
    public void shouldLogTrace() {
        logger.trace("Trace message");

        LogLevel logLevel = appender.getLogLevel("Trace message");
        assertEquals(LogLevel.TRACE, logLevel);
    }

}
