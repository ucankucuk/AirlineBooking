package com.ucankucuk.AirlineBooking.util;

public final class ApiPaths {
    public static final String BASE_PATH = "/api";

    public static final class AirlineCompany {
        public static final String CONTROLLER = BASE_PATH + "/airlineCompany";
    }

    public static final class Airport {
        public static final String CONTROLLER = BASE_PATH + "/airport";
    }

    public static final class Flight {
        public static final String CONTROLLER = BASE_PATH + "/flight";
    }

    public static final class Route {
        public static final String CONTROLLER = BASE_PATH + "/route";
    }

    public static final class Ticket {
        public static final String CONTROLLER = BASE_PATH + "/ticket";
    }
}
