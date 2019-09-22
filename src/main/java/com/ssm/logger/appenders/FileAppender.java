package com.ssm.logger.appenders;

import com.ssm.logger.context.LoggerContext;
import com.ssm.logger.formatters.Formatter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author smustafov
 */
public class FileAppender extends BaseAppender {

    private File file;

    public FileAppender(Formatter formatter, File file) {
        super(formatter);
        this.file = file;
    }

    @Override
    protected void doAppend(LoggerContext context, String formattedMessage) {
        formattedMessage = addNewLine(formattedMessage);
        appendToFile(formattedMessage);
    }

    private void appendToFile(String formattedMessage) {
        try {
            Path path = Paths.get(file.getAbsolutePath());
            Files.write(path, formattedMessage.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String addNewLine(String formattedMessage) {
        return String.format("%s%n", formattedMessage);
    }

}
