package com.dagestan.airline.repository;

import com.dagestan.airline.constant.Airline;
import com.dagestan.airline.constant.City;
import com.dagestan.airline.constant.FlightClass;
import com.dagestan.airline.model.Flight;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class FlightsRepository implements IFlightsRepository {

    private final List<Flight> flights = Arrays.asList(
            Flight.newBuilder()
                    .setPrice(new BigDecimal("5000"))
                    .setAirline(Airline.S7)
                    .setDepartAirport(City.MOSCOW)
                    .setArriveAirport(City.LONDON)
                    .setDepartDate(LocalDate.parse("2021-09-10"))
                    .setArriveDate(LocalDate.parse("2021-09-15"))
                    .setFlightClass(FlightClass.ECONOMY)
                    .build(),

            Flight.newBuilder()
                    .setPrice(new BigDecimal("15000"))
                    .setAirline(Airline.EMIRATES)
                    .setDepartAirport(City.MOSCOW)
                    .setArriveAirport(City.DUBAI)
                    .setDepartDate(LocalDate.parse("2021-09-10"))
                    .setArriveDate(LocalDate.parse("2021-09-15"))
                    .setFlightClass(FlightClass.BUSINESS)
                    .build(),

            Flight.newBuilder()
                    .setPrice(new BigDecimal("9500.50"))
                    .setAirline(Airline.PEGASUS)
                    .setDepartAirport(City.ANKARA)
                    .setArriveAirport(City.MOSCOW)
                    .setDepartDate(LocalDate.parse("2021-09-11"))
                    .setArriveDate(LocalDate.parse("2021-09-15"))
                    .setFlightClass(FlightClass.ECONOMY)
                    .build(),

            Flight.newBuilder()
                    .setPrice(new BigDecimal("80000"))
                    .setAirline(Airline.POBEDA)
                    .setDepartAirport(City.MOSCOW)
                    .setArriveAirport(City.LONDON)
                    .setDepartDate(LocalDate.parse("2021-09-13"))
                    .setArriveDate(LocalDate.parse("2021-09-15"))
                    .setFlightClass(FlightClass.BUSINESS)
                    .build());

    public List<Flight> getFlights() {
        return flights;
    }
}
