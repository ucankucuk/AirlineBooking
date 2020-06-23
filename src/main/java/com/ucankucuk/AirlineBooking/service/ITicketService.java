package com.ucankucuk.AirlineBooking.service;

import com.ucankucuk.AirlineBooking.dto.CanceledTicketDto;
import com.ucankucuk.AirlineBooking.dto.TicketDto;

public interface ITicketService {
    TicketDto getTicketById(Long id);

    TicketDto buyTicket(TicketDto ticketDto);

    CanceledTicketDto cancelTicket(CanceledTicketDto canceledTicketDto);
}
