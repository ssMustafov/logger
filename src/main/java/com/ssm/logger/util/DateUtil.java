package com.ssm.logger.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author smustafov
 */
public final class DateUtil {

    private DateUtil() {
    }

    public static Date buildDate(int year, int month, int day, int hour, int minute, int seconds, int milliseconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, seconds);
        calendar.set(Calendar.MILLISECOND, milliseconds);
        return calendar.getTime();
    }

}
