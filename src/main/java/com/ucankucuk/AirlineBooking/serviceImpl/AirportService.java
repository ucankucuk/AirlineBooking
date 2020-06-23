package com.ucankucuk.AirlineBooking.serviceImpl;

import com.ucankucuk.AirlineBooking.dto.AirportDto;
import com.ucankucuk.AirlineBooking.entity.Airport;
import com.ucankucuk.AirlineBooking.repository.AirportRepository;
import com.ucankucuk.AirlineBooking.service.IAirportService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AirportService implements IAirportService {

    private final AirportRepository airportRepository;
    private final ModelMapper modelMapper;


    public AirportService(AirportRepository airportRepository, ModelMapper modelMapper) {
        this.airportRepository = airportRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AirportDto getAirportById(Long id) {
        Airport airport = airportRepository.getAirportById(id);
        return modelMapper.map(airport, AirportDto.class);
    }

    @Override
    public AirportDto addAirport(AirportDto airportDto) {
        Airport airport = modelMapper.map(airportDto, Airport.class);
        airport = airportRepository.save(airport);
        if (airport == null || airport.getId() == null) {
            throw new RuntimeException("An Error Occured : Airport Cannot Be Created ! ");
        }
        airportDto.setId(airport.getId());

        return airportDto;
    }
}
