package com.ucankucuk.AirlineBooking.serviceImpl;

import com.ucankucuk.AirlineBooking.dto.CanceledTicketDto;
import com.ucankucuk.AirlineBooking.dto.TicketDto;
import com.ucankucuk.AirlineBooking.entity.Flight;
import com.ucankucuk.AirlineBooking.entity.Ticket;
import com.ucankucuk.AirlineBooking.repository.FlightRepository;
import com.ucankucuk.AirlineBooking.repository.TicketRepository;
import com.ucankucuk.AirlineBooking.service.ITicketService;
import com.ucankucuk.AirlineBooking.util.CreditCardValidator;
import com.ucankucuk.AirlineBooking.util.TicketStatus;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService {
    private final TicketRepository ticketRepository;
    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;

    public TicketService(TicketRepository ticketRepository, FlightRepository flightRepository, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.flightRepository = flightRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TicketDto getTicketById(Long id) {
        Ticket ticket = ticketRepository.getTicketById(id);
        Flight flight = flightRepository.getOne(ticket.getFlight().getId());
        TicketDto ticketDto = modelMapper.map(ticket, TicketDto.class);
        ticketDto.setFlightCode(flight.getFlightCode());
        ticketDto.setDeparture(flight.getRoute().getDeparture());
        ticketDto.setLanding(flight.getRoute().getLanding());
        ticketDto.setFlightDate(flight.getFlightDate());
        ticketDto.setRouteCode(flight.getRoute().getRouteCode());
        ticketDto.setStatus(ticket.getStatus());

        return ticketDto;
    }

    @Override
    public TicketDto buyTicket(TicketDto ticketDto) {
        Ticket ticket = modelMapper.map(ticketDto, Ticket.class);
        ticket.setStatus(TicketStatus.ACTIVE.toString());
        String creditCard = ticket.getCreditCardNumber();
        creditCard = CreditCardValidator.cardValidation(creditCard);
        ticket.setCreditCardNumber(creditCard);
        ticketDto.setCreditCardNumber(creditCard);
        Flight flight = flightRepository.getOne(ticketDto.getFlightId());
        ticketDto.setFlightCode(flight.getFlightCode());
        ticketDto.setDeparture(flight.getRoute().getDeparture());
        ticketDto.setLanding(flight.getRoute().getLanding());
        ticketDto.setFlightDate(flight.getFlightDate());
        ticketDto.setRouteCode(flight.getRoute().getRouteCode());
        ticket.setFlight(flight);
        ticket = ticketRepository.save(ticket);
        ticketDto.setId(ticket.getId());
        ticketDto.setBuyDate(ticket.getBuyDate());
        ticket.setStatus(TicketStatus.ACTIVE.toString());

        return ticketDto;
    }

    @Override
    public CanceledTicketDto cancelTicket(CanceledTicketDto canceledTicketDto){
        Ticket ticket = ticketRepository.getOne(canceledTicketDto.getId());
        ticket.setStatus(TicketStatus.CANCELED.toString());
        ticketRepository.save(ticket);
        canceledTicketDto.setStatus(TicketStatus.CANCELED.toString());

        return canceledTicketDto;
    }

}
