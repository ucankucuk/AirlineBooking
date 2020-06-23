package com.ucankucuk.AirlineBooking.serviceImpl;


import com.ucankucuk.AirlineBooking.dto.RouteDto;
import com.ucankucuk.AirlineBooking.entity.Route;
import com.ucankucuk.AirlineBooking.repository.RouteRepository;
import com.ucankucuk.AirlineBooking.service.IRouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RouteService implements IRouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public RouteService(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RouteDto getRouteById(Long id) {
        Route route = routeRepository.getRouteById(id);
        return modelMapper.map(route, RouteDto.class);
    }

    @Override
    public RouteDto addRoute(RouteDto routeDto) {
        Route route = modelMapper.map(routeDto, Route.class);
        route = routeRepository.save(route);
        if (route == null || route.getId() == null) {
            throw new RuntimeException("An Error Occured : Route Cannot Be Created ! ");
        }
        routeDto.setId(route.getId());
        return routeDto;
    }

}
