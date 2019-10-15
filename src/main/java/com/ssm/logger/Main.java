package com.ssm.logger;

import com.ssm.logger.appenders.Appender;
import com.ssm.logger.appenders.ConsoleAppender;
import com.ssm.logger.appenders.FileAppender;
import com.ssm.logger.appenders.ThresholdableAppender;
import com.ssm.logger.formatters.Formatter;
import com.ssm.logger.formatters.PatternFormatter;
import com.ssm.logger.formatters.SimpleFormatter;

import java.io.File;
import java.util.Arrays;

/**
 * @author smustafov
 */
public class Main {

    public static void main(String[] args) {
        Formatter simpleFormatter = new SimpleFormatter();
        Formatter patternFormatter = new PatternFormatter("{date:yyyy/MM/dd HH:mm:ss,SSS} - {level} | {message}");

        ThresholdableAppender consoleAppender = new ConsoleAppender(simpleFormatter);
        consoleAppender.setThresholdLevel(LogLevel.INFO);

        Appender fileAppender = new FileAppender(patternFormatter, new File("C:\\Users\\ssmus\\Desktop\\app.log"));

        Logger logger = new Logger(Arrays.asList(consoleAppender, fileAppender));
        logger.trace("Starting app...");
        logger.info("Successfully released change log lock");
        logger.warn("Found more than one value for field [lastPublishedRevision]");
        logger.error("javax.resource.ResourceException: IJ000451: The connection manager is shutdown");
        logger.debug("Retrieved connection");
    }

}
