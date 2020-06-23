package com.ucankucuk.AirlineBooking.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class FlightDto {

    private Long id;
    private String flightCode;
    private Date flightDate;
    private BigDecimal price;
    private Integer quota;
    private String departure;
    private String landing;
    private Long airlineCompanyId;
    private String airlineCompanyName;
    private Long routeId;
    private Long airportId;

}
