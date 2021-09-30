package com.dagestan.airline.repository;

import com.dagestan.airline.constant.Airline;
import com.dagestan.airline.constant.City;
import com.dagestan.airline.constant.FlightClass;
import com.dagestan.airline.model.Flight;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class FlightsRepository {
    private final List<Flight> flights = Arrays.asList(new Flight(
                    new BigDecimal("5000"),
                    Airline.S7,
                    City.MOSCOW,
                    City.LONDON,
                    LocalDate.parse("2021-09-10"),
                    LocalDate.parse("2021-09-15"),
                    FlightClass.ECONOMY),
            new Flight(
                    new BigDecimal("15000"),
                    Airline.EMIRATES,
                    City.MOSCOW,
                    City.DUBAI,
                    LocalDate.parse("2021-09-10"),
                    LocalDate.parse("2021-09-15"),
                    FlightClass.BUSINESS),
            new Flight(
                    new BigDecimal("9500.50"),
                    Airline.PEGASUS,
                    City.ANKARA,
                    City.MOSCOW,
                    LocalDate.parse("2021-09-11"),
                    LocalDate.parse("2021-09-15"),
                    FlightClass.ECONOMY),
            new Flight(
                    new BigDecimal("80000"),
                    Airline.POBEDA,
                    City.MOSCOW,
                    City.LONDON,
                    LocalDate.parse("2021-09-13"),
                    LocalDate.parse("2021-09-15"),
                    FlightClass.BUSINESS));

    public List<Flight> getFlights() {
        return flights;
    }
}
