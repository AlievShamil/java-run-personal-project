package com.dagestan.airline.service;

import com.dagestan.airline.repository.FlightsRepository;
import com.dagestan.airline.model.FlightRequest;
import com.dagestan.airline.model.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FlightService {
    private static final Logger LOGGER = Logger.getLogger(FlightService.class.getName());
    private final FlightsRepository flightsRepository;

    public FlightService(FlightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    public List<Flight> searchFlights(FlightRequest flightRequest) {
        LOGGER.info("Выполняем поиск " + flightRequest);

        List<Flight> listResult = new ArrayList<>();
        for (Flight flight : flightsRepository.getFlights()) {
            if (compareRequest(flight, flightRequest)) {
                listResult.add(flight);
            }
        }

        LOGGER.info("Результат поиска " + listResult);
        return listResult;
    }

    private boolean compareRequest(Flight flight, FlightRequest flightRequest) {
        return compare(flight.getPrice().toString(), flightRequest.getPrice())
                && compare(flight.getAirline().getDescription(), flightRequest.getAirline())
                && compare(flight.getArriveAirport().getDescription(), flightRequest.getArriveAirport())
                && compare(flight.getDepartAirport().getDescription(), flightRequest.getDepartAirport())
                && compare(flight.getArriveDate().toString(), flightRequest.getArriveDate())
                && compare(flight.getDepartDate().toString(), flightRequest.getDepartDate())
                && compare(flight.getFlightClass().getDescription(), flightRequest.getFlightClass());
    }

    private boolean compare(String sourceParam, String requestParam) {
        return requestParam == null || requestParam.isEmpty() || sourceParam.equalsIgnoreCase(requestParam);
    }
}
