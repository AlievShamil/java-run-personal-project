package com.dagestan.airline.constant;

public enum FlightClasses {
    ECONOMY("economy"),
    BUSINESS("business");

    private final String description;

    FlightClasses(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
