package com.ssm.logger.formatters;

import com.ssm.logger.LogLevel;
import com.ssm.logger.context.LoggerContext;
import com.ssm.logger.exceptions.FormatterException;
import com.ssm.logger.util.DateUtil;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author smustafov
 */
public class PatternFormatterTest {

    @Test
    public void shouldFormat() {
        Date date = DateUtil.buildDate(2019, 8, 22, 20, 37, 12, 601);

        PatternFormatter formatter = new PatternFormatter("{date:yyyy/MM/dd HH:mm:ss,SSS} - {level} | {message}");
        String result = formatter.format(LoggerContext.build(date, LogLevel.INFO, "OK!"));
        assertEquals("2019/09/22 20:37:12,601 - INFO | OK!", result);
    }

    @Test(expected = FormatterException.class)
    public void shouldThrowException_MissingDateFormat() {
        new PatternFormatter("{date} - {level} | {message}");
    }

    @Test(expected = FormatterException.class)
    public void shouldThrowException_CorruptDateFormat() {
        new PatternFormatter("{date:} | {level}  {message}");
    }

    @Test(expected = FormatterException.class)
    public void shouldThrowException_MissingDate() {
        new PatternFormatter("{level}: {message}");
    }

    @Test(expected = FormatterException.class)
    public void shouldThrowException_MissingLevel() {
        new PatternFormatter("{message}: {date:yyyy}");
    }

    @Test(expected = FormatterException.class)
    public void shouldThrowException_MissingMessage() {
        new PatternFormatter("{level}: {date:yyyy/MM/dd HH:mm:ss,SSS}");
    }

    @Test(expected = FormatterException.class)
    public void shouldThrowException_WithEmptyPattern() {
        new PatternFormatter("");
    }

}
