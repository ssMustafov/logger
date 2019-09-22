package com.ssm.logger.formatters;

import com.ssm.logger.context.LoggerContext;
import com.ssm.logger.exceptions.FormatterException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Formatter which uses specific pattern. It has the following mandatory placeholders:
 * <pre>
 *     - {date:_format_} - placeholder for the date, where _format_ is the formatting pattern used by {@link SimpleDateFormat}
 *     - {level} - placeholder for the log level
 *     - {message} - placeholder for the log message
 * </pre>
 *
 * @author smustafov
 */
public class PatternFormatter implements Formatter {

    private static final String PLACEHOLDER_OPENING_BRACKET = "{";
    private static final String PLACEHOLDER_CLOSING_BRACKET = "}";
    private static final String DATE_OPENING_PLACEHOLDER = PLACEHOLDER_OPENING_BRACKET + "date:";
    private static final String LEVEL_PLACEHOLDER = "{level}";
    private static final String MESSAGE_PLACEHOLDER = "{message}";

    private String logPattern;
    private String datePattern;
    private DateFormat dateFormat;

    public PatternFormatter(String logPattern) {
        this.logPattern = Objects.requireNonNull(logPattern);
        validatePattern();
        extractDatePattern();
        buildDateFormat();
    }

    private void validatePattern() {
        if (!logPattern.contains(DATE_OPENING_PLACEHOLDER)) {
            throw new FormatterException("Date placeholder is mandatory");
        }

        if (!logPattern.contains(LEVEL_PLACEHOLDER)) {
            throw new FormatterException("Log level placeholder is mandatory");
        }

        if (!logPattern.contains(MESSAGE_PLACEHOLDER)) {
            throw new FormatterException("Message placeholder is mandatory");
        }
    }

    private void extractDatePattern() {
        int dateFormatStartIndex = findDateFormatStartIndex();
        int dateFormatEndIndex = findDateFormatEndIndex(dateFormatStartIndex);
        datePattern = logPattern.substring(dateFormatStartIndex, dateFormatEndIndex);

        if (datePattern.isEmpty()) {
            throw new FormatterException("Date format pattern must be provided");
        }
    }

    private int findDateFormatStartIndex() {
        return logPattern.indexOf(DATE_OPENING_PLACEHOLDER) + DATE_OPENING_PLACEHOLDER.length();
    }

    private int findDateFormatEndIndex(int dateFormatStartIndex) {
        return logPattern.indexOf(PLACEHOLDER_CLOSING_BRACKET, dateFormatStartIndex);
    }

    private void buildDateFormat() {
        dateFormat = new SimpleDateFormat(datePattern);
    }

    @Override
    public String format(LoggerContext context) {
        String result = replaceDate(context.getDate());

        result = result.replace(LEVEL_PLACEHOLDER, context.getLogLevel().toString());

        result = result.replace(MESSAGE_PLACEHOLDER, context.getMessage());

        return result;
    }

    private String replaceDate(Date date) {
        String formattedDate = dateFormat.format(date);
        return logPattern.replace(DATE_OPENING_PLACEHOLDER + datePattern + PLACEHOLDER_CLOSING_BRACKET, formattedDate);
    }

}
