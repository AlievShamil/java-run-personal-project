package com.dagestan.airline.constant;

public enum Airline {
    POBEDA("pobeda"),
    S7("s7"),
    AEROFLOT("aeroflot"),
    EMIRATES("emirates"),
    PEGASUS("pegasus");

    private final String description;

    Airline(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
