package com.ucankucuk.AirlineBooking.service;

import com.ucankucuk.AirlineBooking.dto.FlightDto;
import com.ucankucuk.AirlineBooking.dto.FlightQuotaUpdateDto;

public interface IFlightService {

    FlightDto getFlightById(Long id);

    FlightDto addFlight(FlightDto flightDto);

    FlightQuotaUpdateDto updateQuota(FlightQuotaUpdateDto flightQuotaUpdateDto);
}
