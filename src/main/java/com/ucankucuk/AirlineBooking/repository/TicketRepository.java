package com.ucankucuk.AirlineBooking.repository;

import com.ucankucuk.AirlineBooking.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket getTicketById(Long id);

}
