package com.ucankucuk.AirlineBooking.service;

import com.ucankucuk.AirlineBooking.dto.AirlineCompanyDto;

public interface IAirlineCompanyService {
    AirlineCompanyDto getAirlineCompanyById(Long id);

    AirlineCompanyDto addAirlineCompany(AirlineCompanyDto airlineCompanyDto);
}
