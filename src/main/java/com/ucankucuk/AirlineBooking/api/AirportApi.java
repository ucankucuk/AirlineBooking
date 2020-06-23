package com.ucankucuk.AirlineBooking.api;


import com.ucankucuk.AirlineBooking.dto.AirportDto;
import com.ucankucuk.AirlineBooking.serviceImpl.AirportService;
import com.ucankucuk.AirlineBooking.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.Airport.CONTROLLER)
public class AirportApi {
    private final AirportService airportService;


    public AirportApi(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportDto> getAirlineCompanyById(@PathVariable(value = "id", required = true) Long id) {
        AirportDto airportDto = airportService.getAirportById(id);
        return ResponseEntity.ok(airportDto);
    }

    @PostMapping
    public ResponseEntity<AirportDto> addAirlineCompany(@RequestBody AirportDto airportDto) {
        return ResponseEntity.ok(airportService.addAirport(airportDto));
    }
}
