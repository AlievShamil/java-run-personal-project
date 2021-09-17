package com.dagestan.airline;

import com.dagestan.airline.handler.FlightRequestHandler;
import com.dagestan.airline.service.FlightService;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Logger;

public class Application {
    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());

    public static final String TICKETS_SEARCH = "/tickets/search";

    public static void main(String[] args) throws IOException {
        LoggerConfiguration.init();
        startApplication();
    }

    private static void startApplication() throws IOException {
        int port = 8080;
        LOGGER.info("Создаем HttpServer, порт: " + port);
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        FlightService flightService = new FlightService();
        server.createContext(TICKETS_SEARCH, new FlightRequestHandler(flightService));
        server.start();
        LOGGER.info("Сервер запущен");
    }
}
