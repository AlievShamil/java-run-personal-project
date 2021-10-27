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

    public static void main(String[] args) throws IOException {
        LoggerConfiguration.init();
        Server httpServer = new Server(8080,0);

        FlightRequestHandler flightRequestHandler = new FlightRequestHandler(new FlightService(new FlightsRepository()));
        httpServer.createContext("/tickets/search", flightRequestHandler);
        httpServer.createContext("/tickets", new ViewHandler());
        httpServer.start();
    }
}
