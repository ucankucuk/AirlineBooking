package com.ucankucuk.AirlineBooking.api;

import com.ucankucuk.AirlineBooking.dto.AirlineCompanyDto;
import com.ucankucuk.AirlineBooking.serviceImpl.AirlineCompanyService;
import com.ucankucuk.AirlineBooking.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.AirlineCompany.CONTROLLER)
public class AirlineCompanyApi {

    private final AirlineCompanyService airlineCompanyService;

    public AirlineCompanyApi(AirlineCompanyService airlineCompanyService) {
        this.airlineCompanyService = airlineCompanyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirlineCompanyDto> getAirlineCompanyById(@PathVariable(value = "id", required = true) Long id) {
        AirlineCompanyDto airlineCompanyDto = airlineCompanyService.getAirlineCompanyById(id);
        return ResponseEntity.ok(airlineCompanyDto);
    }

    @PostMapping
    public ResponseEntity<AirlineCompanyDto> addAirlineCompany(@RequestBody AirlineCompanyDto airlineCompanyDto) {
        return ResponseEntity.ok(airlineCompanyService.addAirlineCompany(airlineCompanyDto));
    }
}
