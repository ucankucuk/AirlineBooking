package com.ucankucuk.AirlineBooking.api;

import com.ucankucuk.AirlineBooking.dto.RouteDto;
import com.ucankucuk.AirlineBooking.serviceImpl.RouteService;
import com.ucankucuk.AirlineBooking.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.Route.CONTROLLER)
public class RouteApi {

    private final RouteService routeService;

    public RouteApi(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteDto> getRouteById(@PathVariable(value = "id", required = true) Long id) {
        RouteDto routeDto = routeService.getRouteById(id);
        return ResponseEntity.ok(routeDto);
    }

    @PostMapping
    public ResponseEntity<RouteDto> addRouteCompany(@RequestBody RouteDto routeDto) {
        return ResponseEntity.ok(routeService.addRoute(routeDto));
    }
}
