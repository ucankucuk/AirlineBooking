package com.ucankucuk.AirlineBooking.service;

import com.ucankucuk.AirlineBooking.dto.AirportDto;

public interface IAirportService {
    AirportDto getAirportById(Long id);

    AirportDto addAirport(AirportDto airportDto);
}
