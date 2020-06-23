package com.ucankucuk.AirlineBooking.service;

import com.ucankucuk.AirlineBooking.dto.RouteDto;

public interface IRouteService {
    RouteDto getRouteById(Long id);

    RouteDto addRoute(RouteDto routeDto);
}
