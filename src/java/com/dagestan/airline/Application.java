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

    public static void main(String[] args) throws IOException {
        LoggerConfiguration.init();
        startApplication();
    }

    private static void startApplication() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/tickets/search", getFlightRequestHandler());
        server.createContext("/tickets", new ViewHandler());
        server.start();

        LOGGER.info("Сервер запущен");
    }

    private static FlightRequestHandler getFlightRequestHandler() {
        FlightsRepository flightsRepository = new FlightsRepository();
        FlightService flightService = new FlightService(flightsRepository);
        return new FlightRequestHandler(flightService);
    }
}
