package com.dagestan.airline.handler;

import com.dagestan.airline.model.FlightRequest;
import com.dagestan.airline.model.Flight;
import com.dagestan.airline.service.FlightService;
import com.dagestan.airline.util.Utils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static com.dagestan.airline.constant.FlightRequestParameters.*;

public class FlightRequestHandler implements HttpHandler {
    private static final Logger LOGGER = Logger.getLogger(FlightRequestHandler.class.getName());

    private final FlightService flightService;

    public FlightRequestHandler(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        LOGGER.info("Обрабатываем запрос: " + exchange.getRequestURI());
        FlightRequest flightRequest = getFlightRequest(exchange);
        List<Flight> listResult = flightService.searchFlights(flightRequest);
        handleResponse(exchange, listResult.toString());
    }

    private void handleResponse(HttpExchange httpExchange, String responseBody) throws IOException {
        LOGGER.info("Запрос обработан успешно");
        OutputStream outputStream = httpExchange.getResponseBody();
        httpExchange.sendResponseHeaders(200, responseBody.length());
        outputStream.write(responseBody.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    private FlightRequest getFlightRequest(HttpExchange exchange) {
        String query = exchange.getRequestURI().getRawQuery().toUpperCase();
        Map<String, String> parameters = Utils.queryToMap(query);
        LOGGER.info("Параметры запроса " + parameters);

        FlightRequest flightRequest = new FlightRequest();
        flightRequest.setPrice(parameters.get(PRICE));
        flightRequest.setAirline(parameters.get(AIRLINE));
        flightRequest.setArriveAirport(parameters.get(ARRIVE_AIRPORT));
        flightRequest.setDepartAirport(parameters.get(DEPART_AIRPORT));
        flightRequest.setArriveDate(parameters.get(ARRIVE_DATE));
        flightRequest.setDepartDate(parameters.get(DEPART_DATE));
        flightRequest.setFlightClass(parameters.get(FLIGHT_CLASS));
        return flightRequest;
    }
}
