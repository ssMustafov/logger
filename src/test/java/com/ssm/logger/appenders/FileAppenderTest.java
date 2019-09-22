package com.ssm.logger.appenders;

import com.ssm.logger.LogLevel;
import com.ssm.logger.context.LoggerContext;
import com.ssm.logger.formatters.SimpleFormatter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author smustafov
 */
public class FileAppenderTest {

    private File logFile;

    @Before
    public void beforeEach() throws IOException {
        logFile = File.createTempFile("FileAppenderTest", ".log");
    }

    @After
    public void afterEach() {
        logFile.delete();
    }

    @Test
    public void shouldAppendToFile() throws IOException {
        Date date = buildDate();

        Appender appender = new FileAppender(new SimpleFormatter(), logFile);
        appender.append(LoggerContext.build(date, LogLevel.INFO, "Application started!"));
        appender.append(LoggerContext.build(date, LogLevel.TRACE, "Connection acquired successfully"));
        appender.append(LoggerContext.build(date, LogLevel.ERROR, "Failed to contact database"));

        Path path = Paths.get(logFile.getAbsolutePath());
        List<String> lines = Files.readAllLines(path);
        assertFalse("The log file should not be empty", lines.isEmpty());
        assertEquals("The log file should contain 3 lines", 3, lines.size());
        assertEquals("2019-09-22 14:30:46,453  INFO  Application started!", lines.get(0));
        assertEquals("2019-09-22 14:30:46,453  TRACE  Connection acquired successfully", lines.get(1));
        assertEquals("2019-09-22 14:30:46,453  ERROR  Failed to contact database", lines.get(2));
    }

    private Date buildDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 8);
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 46);
        calendar.set(Calendar.MILLISECOND, 453);
        return calendar.getTime();
    }

}
