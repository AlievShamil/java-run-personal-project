package com.dagestan.airline.model;

import com.dagestan.airline.constant.FlightClasses;

public final class Flight {
    private final String price;
    private final String airline;
    private final String arriveAirport;
    private final String departAirport;
    private final String arriveDate;
    private final String departDate;
    private final FlightClasses flightClass;

    public Flight(String price, String airline, String arriveAirport,
           String departAirport, String arriveDate, String departDate,
           FlightClasses flightClass) {
        this.price = price;
        this.airline = airline;
        this.arriveAirport = arriveAirport;
        this.departAirport = departAirport;
        this.arriveDate = arriveDate;
        this.departDate = departDate;
        this.flightClass = flightClass;
    }

    public String getPrice() {
        return price;
    }

    public String getAirline() {
        return airline;
    }

    public String getArriveAirport() {
        return arriveAirport;
    }

    public String getDepartAirport() {
        return departAirport;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public String getDepartDate() {
        return departDate;
    }

    public FlightClasses getFlightClass() {
        return flightClass;
    }

    @Override
    public String toString() {
        return "{" +
                "\"price\": " + price + "," +
                "\"airline\": " + "\"" + airline + "\"," +
                "\"arriveAirport\": " + "\"" + arriveAirport + "\"," +
                "\"departAirport\": " + "\"" + departAirport + "\"," +
                "\"arriveDate\": " + "\"" + arriveDate + "\"," +
                "\"departDate\": " + "\"" + departDate + "\"," +
                "\"flightClass\": " + "\"" + flightClass + "\"}";
    }
}
