package com.ucankucuk.AirlineBooking.repository;

import com.ucankucuk.AirlineBooking.entity.AirlineCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany, Long> {

    AirlineCompany getAirlineCompaniesById(Long id);

}
