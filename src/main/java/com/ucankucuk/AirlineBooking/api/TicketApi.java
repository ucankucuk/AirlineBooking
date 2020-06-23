package com.ucankucuk.AirlineBooking.api;

import com.ucankucuk.AirlineBooking.dto.CanceledTicketDto;
import com.ucankucuk.AirlineBooking.dto.TicketDto;
import com.ucankucuk.AirlineBooking.serviceImpl.TicketService;
import com.ucankucuk.AirlineBooking.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.Ticket.CONTROLLER)
public class TicketApi {

    private final TicketService ticketService;

    public TicketApi(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getRouteById(@PathVariable(value = "id", required = true) Long id) {
        TicketDto ticketDto = ticketService.getTicketById(id);
        return ResponseEntity.ok(ticketDto);
    }

    @PostMapping
    public ResponseEntity<TicketDto> addRouteCompany(@RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(ticketService.buyTicket(ticketDto));
    }

    @PutMapping
    public ResponseEntity<CanceledTicketDto> addFlight(@RequestBody CanceledTicketDto canceledTicketDto) {
        return ResponseEntity.ok(ticketService.cancelTicket(canceledTicketDto));
    }
}
