package com.dagestan.airline.model;

public class FlightRequest {
    private String price;
    private String airline;
    private String arriveAirport;
    private String departAirport;
    private String arriveDate;
    private String departDate;
    private String flightClass;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getArriveAirport() {
        return arriveAirport;
    }

    public void setArriveAirport(String arriveAirport) {
        this.arriveAirport = arriveAirport;
    }

    public String getDepartAirport() {
        return departAirport;
    }

    public void setDepartAirport(String departAirport) {
        this.departAirport = departAirport;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    @Override
    public String toString() {
        return "FlightRequest{" +
                "price='" + price + '\'' +
                ", airline='" + airline + '\'' +
                ", arriveAirport='" + arriveAirport + '\'' +
                ", departAirport='" + departAirport + '\'' +
                ", arriveDate='" + arriveDate + '\'' +
                ", departDate='" + departDate + '\'' +
                ", flightClass='" + flightClass + '\'' +
                '}';
    }
}
