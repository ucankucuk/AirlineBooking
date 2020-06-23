package com.ucankucuk.AirlineBooking.api;

import com.ucankucuk.AirlineBooking.dto.FlightDto;
import com.ucankucuk.AirlineBooking.dto.FlightQuotaUpdateDto;
import com.ucankucuk.AirlineBooking.serviceImpl.FlightService;
import com.ucankucuk.AirlineBooking.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.Flight.CONTROLLER)
public class FlightApi {

    private final FlightService flightService;


    public FlightApi(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable(value = "id", required = true) Long id) {
        FlightDto flightDto = flightService.getFlightById(id);
        return ResponseEntity.ok(flightDto);
    }

    @PostMapping
    public ResponseEntity<FlightDto> addAirlineCompany(@RequestBody FlightDto flightDto) {
        return ResponseEntity.ok(flightService.addFlight(flightDto));
    }

    @PutMapping
    public ResponseEntity<FlightQuotaUpdateDto> addFlight(@RequestBody FlightQuotaUpdateDto flightQuotaUpdateDto) {
        return ResponseEntity.ok(flightService.updateQuota(flightQuotaUpdateDto));
    }
}
