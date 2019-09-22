package com.ssm.logger.formatters;

import com.ssm.logger.LogLevel;
import org.junit.Test;

import java.util.Calendar;
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
        String formatted = formatter.format(date, LogLevel.INFO, "Sample message");

        assertEquals("2019-09-22 14:30:46,453  INFO  Sample message", formatted);
    }

    @Test
    public void shouldFormatWithError() {
        Date date = buildDate();

        Formatter formatter = new SimpleFormatter();
        String formatted = formatter.format(date, LogLevel.ERROR, "Connection failed");

        assertEquals("2019-09-22 14:30:46,453  ERROR  Connection failed", formatted);
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
