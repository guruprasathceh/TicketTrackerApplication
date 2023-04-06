package com.gl.ticket_tracker.service;

import com.gl.ticket_tracker.entity.Ticket;

import java.util.List;

public interface TicketService {

    public List<Ticket> displayTicketDetails();

    public Ticket getTicketByTicketId(Integer ticketId);

    public void saveTicketDetails(Ticket ticket);

    public Ticket findTicketsByTicketShortDescriptionIgnoreCaseAndAndTicketTitle(String description,String ticketTitle);



    public void deleteTicketByTicketId(Integer ticketId);



}
