package com.dagestan.airline;

import java.io.InputStream;
import java.util.logging.LogManager;

public class LoggerConfiguration {
    public static void init() {
        ClassLoader classLoader = LoggerConfiguration.class.getClassLoader();
        try (InputStream ins = classLoader.getResourceAsStream("logger.properties")) {
            LogManager.getLogManager().readConfiguration(ins);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}