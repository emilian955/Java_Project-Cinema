package com.example.config;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public static void log(String message) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        FileWriter writer = null;
        try {
            writer = new FileWriter("C:\\logs\\cinemaLogFile.log", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(dtf.format(now) + message + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
