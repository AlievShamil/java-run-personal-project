package com.dagestan.airline.config;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerConfiguration {
    private static final Logger LOGGER = Logger.getLogger(LoggerConfiguration.class.getName());

    public static void init() {
        ClassLoader classLoader = LoggerConfiguration.class.getClassLoader();
        try (InputStream ins = classLoader.getResourceAsStream("logger.properties")) {
            LogManager.getLogManager().readConfiguration(ins);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Ошибка загрузки конфугураций логирования. Будут использованы стандартные настройки", e);
        }
    }
}
