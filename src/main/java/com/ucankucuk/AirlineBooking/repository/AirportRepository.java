package com.ucankucuk.AirlineBooking.repository;

import com.ucankucuk.AirlineBooking.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    Airport getAirportById(Long id);

}
