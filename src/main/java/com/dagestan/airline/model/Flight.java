package com.dagestan.airline.model;

import com.dagestan.airline.constant.Airline;
import com.dagestan.airline.constant.City;
import com.dagestan.airline.constant.FlightClass;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public final class Flight {
    private BigDecimal price;
    private  Airline airline;
    private  City departAirport;
    private  City arriveAirport;
    private  LocalDate departDate;
    private  LocalDate arriveDate;
    private  FlightClass flightClass;

    private Flight() {
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

    public static Builder newBuilder() {
        return new Flight().new Builder();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(price, flight.price) && airline == flight.airline && departAirport == flight.departAirport && arriveAirport == flight.arriveAirport && Objects.equals(departDate, flight.departDate) && Objects.equals(arriveDate, flight.arriveDate) && flightClass == flight.flightClass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, airline, departAirport, arriveAirport, departDate, arriveDate, flightClass);
    }

    public class Builder {

        private Builder() {
        }

        public Builder setPrice(BigDecimal price) {
            Flight.this.price = price;

            return this;
        }

        public Builder setAirline(Airline airline) {
            Flight.this.airline = airline;

            return this;
        }

        public Builder setDepartAirport(City departAirport) {
            Flight.this.departAirport = departAirport;

            return this;
        }

        public Builder setArriveAirport(City arriveAirport) {
            Flight.this.arriveAirport = arriveAirport;

            return this;
        }

        public Builder setDepartDate(LocalDate departDate) {
            Flight.this.departDate = departDate;

            return this;
        }

        public Builder setArriveDate(LocalDate arriveDate) {
            Flight.this.arriveDate = arriveDate;

            return this;
        }

        public Builder setFlightClass(FlightClass flightClass) {
            Flight.this.flightClass = flightClass;

            return this;
        }

        public Flight build() {
            return Flight.this;
        }
    }
}
