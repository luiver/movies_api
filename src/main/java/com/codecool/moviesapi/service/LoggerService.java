package com.codecool.moviesapi.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;

@Service
public class LoggerService {
    private final String DEFAULT_LOG_FILE_NAME = "logs.log";


    public String getTenLastRowsFromLogFile() {
        File logFile = new File(getLogFilePath());
        return readLastNLinesFromFile(logFile,10);
    }

    private String getLogFilePath() {
        ClassLoader classLoader = LoggerService.class.getClassLoader();
        return Paths.get(classLoader.getResource(DEFAULT_LOG_FILE_NAME).getFile()).toString();
    }

    private String readLastNLinesFromFile(File file, int lines) {
        RandomAccessFile fileHandler = null;
        try {
            fileHandler =
                    new RandomAccessFile(file, "r");
            long fileLength = fileHandler.length() - 1;
            StringBuilder sb = new StringBuilder();
            int line = 0;

            for (long filePointer = fileLength; filePointer != -1; filePointer--) {
                fileHandler.seek(filePointer);
                int readByte = fileHandler.readByte();

                if (readByte == 0xA) {
                    if (filePointer < fileLength) {
                        line = line + 1;
                    }
                } else if (readByte == 0xD) {
                    if (filePointer < fileLength - 1) {
                        line = line + 1;
                    }
                }
                if (line >= lines) {
                    break;
                }
                sb.append((char) readByte);
            }

            String lastLine = sb.reverse().toString();
            return lastLine;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (fileHandler != null)
                try {
                    fileHandler.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}
