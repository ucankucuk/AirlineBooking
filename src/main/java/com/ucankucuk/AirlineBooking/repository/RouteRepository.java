package com.ucankucuk.AirlineBooking.repository;

import com.ucankucuk.AirlineBooking.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    Route getRouteById(Long id);

}
