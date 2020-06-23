package com.ucankucuk.AirlineBooking.serviceImpl;

import com.ucankucuk.AirlineBooking.dto.AirlineCompanyDto;
import com.ucankucuk.AirlineBooking.entity.AirlineCompany;
import com.ucankucuk.AirlineBooking.repository.AirlineCompanyRepository;
import com.ucankucuk.AirlineBooking.service.IAirlineCompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AirlineCompanyService implements IAirlineCompanyService {

    private final AirlineCompanyRepository airlineCompanyRepository;
    private final ModelMapper modelMapper;

    public AirlineCompanyService(AirlineCompanyRepository airlineCompanyRepository, ModelMapper modelMapper) {
        this.airlineCompanyRepository = airlineCompanyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AirlineCompanyDto getAirlineCompanyById(Long id) {
        AirlineCompany airlineCompany = airlineCompanyRepository.getAirlineCompaniesById(id);
        return modelMapper.map(airlineCompany, AirlineCompanyDto.class);
    }

    @Override
    public AirlineCompanyDto addAirlineCompany(AirlineCompanyDto airlineCompanyDto) {
        AirlineCompany airlineCompany = modelMapper.map(airlineCompanyDto, AirlineCompany.class);
        airlineCompany = airlineCompanyRepository.save(airlineCompany);
        if (airlineCompany == null || airlineCompany.getId() == null) {
            throw new RuntimeException("An Error Occured : Airline Company Cannot Be Created ! ");
        }
        airlineCompanyDto.setId(airlineCompany.getId());

        return airlineCompanyDto;
    }

}
