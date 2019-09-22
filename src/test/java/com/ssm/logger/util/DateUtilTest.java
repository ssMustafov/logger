package com.ssm.logger.util;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author smustafov
 */
public class DateUtilTest {

    @Test
    public void shouldBuildDate() {
        Date date = DateUtil.buildDate(2019, 8, 20, 14, 33, 28, 311);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        assertEquals(2019, calendar.get(Calendar.YEAR));
        assertEquals(8, calendar.get(Calendar.MONTH));
        assertEquals(20, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(14, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(33, calendar.get(Calendar.MINUTE));
        assertEquals(28, calendar.get(Calendar.SECOND));
        assertEquals(311, calendar.get(Calendar.MILLISECOND));
    }

}
