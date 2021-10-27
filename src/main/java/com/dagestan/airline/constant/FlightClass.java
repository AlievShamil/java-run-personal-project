package com.dagestan.airline.constant;

public enum FlightClass {
    ECONOMY("economy"),
    BUSINESS("business");

    private final String description;

    FlightClass(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
