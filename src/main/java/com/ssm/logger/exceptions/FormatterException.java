package com.ssm.logger.exceptions;

/**
 * @author smustafov
 */
public class FormatterException extends RuntimeException {

    public FormatterException() {
    }

    public FormatterException(String message) {
        super(message);
    }

    public FormatterException(String message, Throwable cause) {
        super(message, cause);
    }
}
