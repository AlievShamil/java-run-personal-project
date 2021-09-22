package com.dagestan.airline;

import com.dagestan.airline.config.LoggerConfiguration;
import com.dagestan.airline.handler.FlightRequestHandler;
import com.dagestan.airline.handler.ViewHandler;
import com.dagestan.airline.repository.FlightsRepository;
import com.dagestan.airline.service.FlightService;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Logger;

public class Application {
    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());
    private static final String TICKETS_SEARCH = "/tickets/search";
    private static final String TICKETS = "/tickets";

    public static void main(String[] args) throws IOException {
        LoggerConfiguration.init();
        startApplication();
    }

    private static void startApplication() throws IOException {
        int port = 8080;
        LOGGER.info("Создаем HttpServer, порт: " + port);
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        FlightsRepository flightsRepository = new FlightsRepository();
        FlightService flightService = new FlightService(flightsRepository);
        server.createContext(TICKETS_SEARCH, new FlightRequestHandler(flightService));
        server.createContext(TICKETS, new ViewHandler());
        server.start();
        LOGGER.info("Сервер запущен");
    }
}
