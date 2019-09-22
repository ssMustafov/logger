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
    protected void doAppend(LoggerContext context, String formatted) {
        formatted = String.format("%s%n", formatted);

        try {
            Path path = Paths.get(file.getAbsolutePath());
            Files.write(path, formatted.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
