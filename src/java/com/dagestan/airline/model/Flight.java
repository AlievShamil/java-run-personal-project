package com.dagestan.airline.model;

import com.dagestan.airline.constant.Airline;
import com.dagestan.airline.constant.City;
import com.dagestan.airline.constant.FlightClass;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class Flight {
    private final BigDecimal price;
    private final Airline airline;
    private final City departAirport;
    private final City arriveAirport;
    private final LocalDate departDate;
    private final LocalDate arriveDate;
    private final FlightClass flightClass;

    public Flight(BigDecimal price, Airline airline,
                  City departAirport, City arriveAirport,
                  LocalDate departDate, LocalDate arriveDate,
                  FlightClass flightClass) {
        this.price = price;
        this.airline = airline;
        this.arriveAirport = arriveAirport;
        this.departAirport = departAirport;
        this.arriveDate = arriveDate;
        this.departDate = departDate;
        this.flightClass = flightClass;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Airline getAirline() {
        return airline;
    }

    public City getDepartAirport() {
        return departAirport;
    }

    public City getArriveAirport() {
        return arriveAirport;
    }

    public LocalDate getDepartDate() {
        return departDate;
    }

    public LocalDate getArriveDate() {
        return arriveDate;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    @Override
    public String toString() {
        return "{" +
                "\"price\": " + price + "," +
                "\"airline\": " + "\"" + airline + "\"," +
                "\"departAirport\": " + "\"" + departAirport + "\"," +
                "\"arriveAirport\": " + "\"" + arriveAirport + "\"," +
                "\"departDate\": " + "\"" + departDate + "\"," +
                "\"arriveDate\": " + "\"" + arriveDate + "\"," +
                "\"flightClass\": " + "\"" + flightClass + "\"}";
    }
}
