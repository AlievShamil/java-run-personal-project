package com.dagestan.airline.service;

import com.dagestan.airline.model.FlightRequest;
import com.dagestan.airline.repository.FlightsRepository;
import com.dagestan.airline.model.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FlightService {
    private static final Logger LOGGER = Logger.getLogger(FlightService.class.getName());

    public List<Flight> searchFlights(FlightRequest flightRequest) {
        LOGGER.info("Выполняем поиск " + flightRequest);
        List<Flight> listResult = new ArrayList<>();
        for (Flight flight : FlightsRepository.flights) {
            if (flight.getPrice().equalsIgnoreCase(flightRequest.getPrice())
                    || flight.getAirline().equalsIgnoreCase(flightRequest.getAirline())
                    || flight.getArriveAirport().equalsIgnoreCase(flightRequest.getArriveAirport())
                    || flight.getDepartAirport().equalsIgnoreCase(flightRequest.getDepartAirport())
                    || flight.getArriveDate().equalsIgnoreCase(flightRequest.getArriveDate())
                    || flight.getDepartDate().equalsIgnoreCase(flightRequest.getDepartDate())
                    || flight.getFlightClass().getDescription().equalsIgnoreCase(flightRequest.getFlightClass())) {
                listResult.add(flight);
            }
        }
        LOGGER.info("Результат поиска " + listResult);
        return listResult;
    }

}
