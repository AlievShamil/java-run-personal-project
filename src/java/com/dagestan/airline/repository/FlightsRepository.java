package com.dagestan.airline.repository;

import com.dagestan.airline.constant.FlightClasses;
import com.dagestan.airline.model.Flight;

public class FlightsRepository {
    public static final Flight[] flights = new Flight[]{
            new Flight(
                    "5000",
                    "s7",
                    "moscow",
                    "london",
                    "2021-09-10",
                    "2021-09-15",
                    FlightClasses.ECONOMY),

            new Flight(
                    "15000",
                    "emirates",
                    "moscow",
                    "dubai",
                    "2021-09-10",
                    "2021-09-15",
                    FlightClasses.BUSINESS),

            new Flight(
                    "9500.50",
                    "pegasus",
                    "ankara",
                    "moscow",
                    "2021-09-11",
                    "2021-09-15",
                    FlightClasses.ECONOMY),

            new Flight(
                    "80000",
                    "pobeda",
                    "moscow",
                    "london",
                    "2021-09-13",
                    "2021-09-15",
                    FlightClasses.BUSINESS),
    };
}
