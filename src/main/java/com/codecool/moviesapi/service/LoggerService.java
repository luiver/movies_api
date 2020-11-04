package com.codecool.moviesapi.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class LoggerService {
    private static final String DEFAULT_LOG_FILE_NAME = "src/main/resources/logs.log";

    public String getTenLastRowsFromLogFile() {
        StringBuilder lastTenLines = new StringBuilder();

        int linesCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(DEFAULT_LOG_FILE_NAME))) {
            while (br.readLine() != null) {
                ++linesCount;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(DEFAULT_LOG_FILE_NAME))) {
            for (String line; (line = br.readLine()) != null; ) {
                ++i;
                if (linesCount - i < 10) {
                    lastTenLines.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastTenLines.toString();
    }
}
