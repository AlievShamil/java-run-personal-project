package com.dagestan.airline.repository;

import com.dagestan.airline.model.Flight;

import java.util.List;

public interface IFlightsRepository {

    List<Flight> getFlights();
}
