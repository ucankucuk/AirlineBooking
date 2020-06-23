package com.ucankucuk.AirlineBooking.serviceImpl;

import com.ucankucuk.AirlineBooking.dto.FlightDto;
import com.ucankucuk.AirlineBooking.dto.FlightQuotaUpdateDto;
import com.ucankucuk.AirlineBooking.entity.AirlineCompany;
import com.ucankucuk.AirlineBooking.entity.Airport;
import com.ucankucuk.AirlineBooking.entity.Flight;
import com.ucankucuk.AirlineBooking.entity.Route;
import com.ucankucuk.AirlineBooking.repository.AirlineCompanyRepository;
import com.ucankucuk.AirlineBooking.repository.AirportRepository;
import com.ucankucuk.AirlineBooking.repository.FlightRepository;
import com.ucankucuk.AirlineBooking.repository.RouteRepository;
import com.ucankucuk.AirlineBooking.service.IFlightService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FlightService implements IFlightService {

    private final FlightRepository flightRepository;
    private final RouteRepository routeRepository;
    private final AirlineCompanyRepository airlineCompanyRepository;
    private final AirportRepository airportRepository;
    private final ModelMapper modelMapper;

    public FlightService(FlightRepository flightRepository, RouteService routeService, AirlineCompanyService airlineCompanyService, AirportService airportService, RouteRepository routeRepository, AirlineCompanyRepository airlineCompanyRepository, AirportRepository airportRepository, ModelMapper modelMapper) {
        this.flightRepository = flightRepository;
        this.routeRepository = routeRepository;
        this.airlineCompanyRepository = airlineCompanyRepository;
        this.airportRepository = airportRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FlightDto getFlightById(Long id) {
        Flight flight = flightRepository.getFlightById(id);
        Route route = routeRepository.getOne(flight.getRoute().getId());
        AirlineCompany airlineCompany = airlineCompanyRepository.getOne(flight.getAirlineCompany().getId());
        Airport airport = airportRepository.getOne(flight.getAirport().getId());
        FlightDto flightDto = modelMapper.map(flight, FlightDto.class);
        if (route != null) {
            flightDto.setDeparture(route.getDeparture());
            flightDto.setLanding(route.getLanding());
            flightDto.setRouteId(route.getId());
        } else {
            throw new RuntimeException("An Error Occured : Wrong Route İnformation ! ");
        }
        if (airlineCompany != null) {
            flightDto.setAirlineCompanyName(airlineCompany.getCompanyName());
            flightDto.setAirlineCompanyId(airlineCompany.getId());
        } else {
            throw new RuntimeException("An Error Occured : Wrong AirlineCompany İnformation ! ");
        }
        if (airport != null) {
            flightDto.setAirportId(airport.getId());
        } else {
            throw new RuntimeException("An Error Occured : Wrong Airport İnformation ! ");
        }
        return flightDto;
    }

    @Override
    public FlightDto addFlight(FlightDto flightDto) {
        Flight flight = modelMapper.map(flightDto, Flight.class);
        if (flightDto == null) {
            throw new RuntimeException("An Error Occured : Wrong FlightDto İnformation ! ");
        }

        if (flightDto.getAirlineCompanyId() == null) {
            throw new RuntimeException("An Error Occured : Empty AirlineCompany ID ! ");
        }

        AirlineCompany airlineCompany = airlineCompanyRepository.getAirlineCompaniesById(flightDto.getAirlineCompanyId());
        if (airlineCompany == null || airlineCompany.getId() == null) {
            throw new RuntimeException("An Error Occured : Wrong  AirlineCompany ID ! ");
        }
        flight.setAirlineCompany(airlineCompany);

        if (flightDto.getRouteId() == null) {
            throw new RuntimeException("An Error Occured : Empty Route ID ! ");
        }
        Route route = routeRepository.getRouteById(flightDto.getRouteId());
        if (route == null || route.getId() == null) {
            throw new RuntimeException("An Error Occured : Wrong  Route ID ! ");
        }

        flight.setRoute(route);

        if (flightDto.getAirportId() == null) {
            throw new RuntimeException("An Error Occured : Airport ID ! ");

        }

        Airport airport = airportRepository.getAirportById(flightDto.getAirportId());
        if (airport == null || airport.getId() == null) {
            throw new RuntimeException("An Error Occured : Wrong  Airport ID ! ");
        }
        flight.setAirport(airport);

        flight = flightRepository.save(flight);

        if (flight == null || flight.getId() == null) {
            throw new RuntimeException("An Error Occured : Airport Cannot Be Created ! ");
        }
        flightDto.setId(flight.getId());

        return flightDto;
    }


    @Override
    public FlightQuotaUpdateDto updateQuota(FlightQuotaUpdateDto flightQuotaUpdateDto) {
        if (flightQuotaUpdateDto == null || flightQuotaUpdateDto.getFligtId() == null) {
            throw new RuntimeException("An Error Occured : Wrong Flight ID ! ");
        }
        if (flightQuotaUpdateDto.getQuotaUp() == null) {
            throw new RuntimeException("An Error Occured : QuotaUp is Mandatory ! ");
        }
        Flight flight = flightRepository.getOne(flightQuotaUpdateDto.getFligtId());

        BigDecimal price = flight.getPrice();
        int quota = flight.getQuota();
        flightQuotaUpdateDto.setOldPrice(price);
        flightQuotaUpdateDto.setOldQuota(quota);

        price = flightQuotaUpdateDto.getQuotaUp() ? price.multiply(new BigDecimal("1.1")) : price.multiply(new BigDecimal("0.9"));
        quota = flightQuotaUpdateDto.getQuotaUp() ? quota + 10 : quota - 10;

        flightQuotaUpdateDto.setNewPrice(price);
        flightQuotaUpdateDto.setNewQuota(quota);

        flight.setPrice(price);
        flight.setQuota(quota);
        flightRepository.save(flight);

        return flightQuotaUpdateDto;
    }

}
