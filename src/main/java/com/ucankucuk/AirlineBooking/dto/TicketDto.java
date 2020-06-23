package com.ucankucuk.AirlineBooking.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TicketDto {
    private Long id;
    private String customerNameSurname;
    private String customerTckn;
    private String creditCardNumber;
    private Long flightId;
    private String flightCode;
    private Date flightDate;
    private String routeCode;
    private String departure;
    private String landing;
    private Date buyDate;
    private String status;
}
