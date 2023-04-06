package com.gl.ticket_tracker.service;

import com.gl.ticket_tracker.entity.Ticket;
import com.gl.ticket_tracker.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public List<Ticket> displayTicketDetails() {
        List<Ticket> tickets =  ticketRepository.findAll();
        return tickets;
    }

    @Override
    public Ticket getTicketByTicketId(Integer ticketId) {
        Optional<Ticket> tickets = ticketRepository.findById(ticketId);
        return tickets.get();
    }

    @Override
    public void saveTicketDetails(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public Ticket findTicketsByTicketShortDescriptionIgnoreCaseAndAndTicketTitle(String description,String ticketTitle) {
        return ticketRepository.findTicketsByTicketShortDescriptionIgnoreCaseOrTicketTitle(description,ticketTitle).get();
    }


    @Override
    public void deleteTicketByTicketId(Integer ticketId) {
        ticketRepository.deleteById(ticketId);
    }
}
