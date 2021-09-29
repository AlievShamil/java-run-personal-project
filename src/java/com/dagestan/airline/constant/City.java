package com.dagestan.airline.constant;

public enum City {
    MOSCOW("Moscow"),
    LONDON("London"),
    DUBAI("Dubai"),
    ANKARA("Ankara"),
    BARCELONA("Barcelona");

    private final String description;

    City(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }}
