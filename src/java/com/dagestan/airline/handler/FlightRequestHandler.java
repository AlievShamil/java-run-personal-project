package com.dagestan.airline.handler;

import com.dagestan.airline.model.FlightRequest;
import com.dagestan.airline.model.Flight;
import com.dagestan.airline.service.FlightService;
import com.dagestan.airline.util.Utils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class FlightRequestHandler implements HttpHandler {
    private static final Logger LOGGER = Logger.getLogger(FlightRequestHandler.class.getName());

    private final FlightService flightService;

    public FlightRequestHandler(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        LOGGER.info("Обрабатываем запрос: " + exchange.getRequestURI());

        String query = exchange.getRequestURI().getRawQuery().toUpperCase();
        FlightRequest flightRequest = getFlightRequest(query);
        List<Flight> listResult = flightService.searchFlights(flightRequest);
        handleResponse(exchange, listResult.toString());
    }

    private void handleResponse(HttpExchange httpExchange, String responseBody) throws IOException {
        LOGGER.info("Запрос обработан успешно");

        OutputStream outputStream = httpExchange.getResponseBody();
        httpExchange.sendResponseHeaders(200, responseBody.length());
        outputStream.write(responseBody.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }

    private FlightRequest getFlightRequest(String query) {
        Map<String, String> parameters = Utils.queryToMap(query);
        LOGGER.info("Параметры запроса " + parameters);

        FlightRequest flightRequest = new FlightRequest();
        flightRequest.setPrice(parameters.get(RequestParameters.PRICE));
        flightRequest.setAirline(parameters.get(RequestParameters.AIRLINE));
        flightRequest.setArriveAirport(parameters.get(RequestParameters.ARRIVE_AIRPORT));
        flightRequest.setDepartAirport(parameters.get(RequestParameters.DEPART_AIRPORT));
        flightRequest.setArriveDate(parameters.get(RequestParameters.ARRIVE_DATE));
        flightRequest.setDepartDate(parameters.get(RequestParameters.DEPART_DATE));
        flightRequest.setFlightClass(parameters.get(RequestParameters.FLIGHT_CLASS));

        return flightRequest;
    }

    private static class RequestParameters {
        private static final String PRICE = "PRICE";
        private static final String AIRLINE = "AIRLINE";
        private static final String ARRIVE_AIRPORT = "ARRIVEAIRPORT";
        private static final String DEPART_AIRPORT = "DEPARTAIRPORT";
        private static final String ARRIVE_DATE = "ARRIVEDATE";
        private static final String DEPART_DATE = "DEPARTDATE";
        private static final String FLIGHT_CLASS = "FLIGHTCLASS";
    }
}
