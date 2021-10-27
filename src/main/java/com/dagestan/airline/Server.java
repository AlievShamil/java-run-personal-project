package com.dagestan.airline;

import com.dagestan.airline.handler.FlightRequestHandler;
import com.dagestan.airline.handler.ViewHandler;
import com.dagestan.airline.repository.FlightsRepository;
import com.dagestan.airline.service.FlightService;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Logger;

public class Server {
    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());
    private final HttpServer server;

    public Server(int port, int backlog) throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), backlog);
    }

    public void start() {
        server.start();

        LOGGER.info("Сервер запущен");
    }

    public void createContext(String path, HttpHandler handler) {
        server.createContext(path, handler);
    }

    public void stop(int delay) {
        server.stop(delay);
    }

    private FlightRequestHandler getFlightRequestHandler() {
        FlightsRepository flightsRepository = new FlightsRepository();
        FlightService flightService = new FlightService(flightsRepository);
        return new FlightRequestHandler(flightService);
    }
}
