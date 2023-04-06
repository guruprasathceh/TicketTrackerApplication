package com.gl.ticket_tracker.repository;

import com.gl.ticket_tracker.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    public Optional<Ticket> findTicketsByTicketShortDescriptionIgnoreCaseOrTicketTitle(String description,String ticketTitle);





}
