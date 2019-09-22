package com.ssm.logger.formatters;

import com.ssm.logger.LogLevel;
import com.ssm.logger.context.LoggerContext;
import com.ssm.logger.util.DateUtil;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author smustafov
 */
public class SimpleFormatterTest {

    @Test
    public void shouldFormat() {
        Date date = buildDate();

        Formatter formatter = new SimpleFormatter();
        String formatted = formatter.format(LoggerContext.build(date, LogLevel.INFO, "Sample message"));

        assertEquals("2019-09-22 14:30:46,453  INFO  Sample message", formatted);
    }

    @Test
    public void shouldFormatWithError() {
        Date date = buildDate();

        Formatter formatter = new SimpleFormatter();
        String formatted = formatter.format(LoggerContext.build(date, LogLevel.ERROR, "Connection failed"));

        assertEquals("2019-09-22 14:30:46,453  ERROR  Connection failed", formatted);
    }

    private Date buildDate() {
        return DateUtil.buildDate(2019, 8, 22, 14, 30, 46, 453);
    }

}
