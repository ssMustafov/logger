package com.ssm.logger;

import com.ssm.logger.appenders.Appender;
import com.ssm.logger.appenders.ConsoleAppender;
import com.ssm.logger.formatters.Formatter;
import com.ssm.logger.formatters.SimpleFormatter;

import java.util.Collections;

/**
 * @author smustafov
 */
public class Main {

    public static void main(String[] args) {
        Formatter simpleFormatter = new SimpleFormatter();

        Appender consoleAppender = new ConsoleAppender(simpleFormatter);

        Logger logger = new Logger(Collections.singletonList(consoleAppender));
        logger.info("Successfully released change log lock");
        logger.warn("Found more than one value for field [lastPublishedRevision]");
        logger.error("javax.resource.ResourceException: IJ000451: The connection manager is shutdown");
        logger.debug("Retrieved connection");
    }

}
