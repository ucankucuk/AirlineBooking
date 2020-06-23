package com.ucankucuk.AirlineBooking.dto;

import lombok.Data;

@Data
public class RouteDto {

    private Long id;
    private String routeCode;
    private String departure;
    private String landing;

}
