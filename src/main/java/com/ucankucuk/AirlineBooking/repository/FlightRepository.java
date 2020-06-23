package com.ucankucuk.AirlineBooking.repository;

import com.ucankucuk.AirlineBooking.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Flight getFlightById(Long id);

}
