package com.dagestan.airline;

import com.dagestan.airline.model.Flight;
import com.dagestan.airline.repository.IFlightsRepository;

import java.util.List;

public class FlightTest implements IFlightsRepository {

    private List<Flight> flights;

    public FlightTest(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public List<Flight> getFlights() {
        return flights;
    }
}
