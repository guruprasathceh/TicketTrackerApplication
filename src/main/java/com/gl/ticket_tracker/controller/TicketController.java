package com.gl.ticket_tracker.controller;

import com.gl.ticket_tracker.entity.Ticket;
import com.gl.ticket_tracker.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @RequestMapping("/tickets")
    public String showTicketDetails(Model model) {
        List<Ticket> ticket = ticketService.displayTicketDetails();
        model.addAttribute("tickets", ticket);
        return "listtickets";
    }

    @RequestMapping("/delete/{ticketId}")
    public String deleteTicket(@PathVariable("ticketId") Integer ticketId) {
        ticketService.deleteTicketByTicketId(ticketId);
        return "redirect:/tickets";
    }

    @RequestMapping("/update/{ticketId}")
    public String updateTicketForm(@PathVariable("ticketId") Integer ticketId, Model model) {
        Ticket ticketData = ticketService.getTicketByTicketId(ticketId);
        model.addAttribute("updatetickets", ticketData);
        return "updateticketForm";
    }

    @RequestMapping("/success")
    public String saveTicket(@ModelAttribute Ticket tickets, Model model) {
        ticketService.saveTicketDetails(tickets);
        return "redirect:/tickets";
    }


    @RequestMapping("/newTicket")
    public String createNewTicket(Model model) {
        Ticket tickets = new Ticket();
        model.addAttribute("tickets", tickets);
        return "createticket";
    }

    @RequestMapping("/view/{ticketid}")
    public String showTicketContent(@PathVariable("ticketid") Integer ticketId, Model model) {

        Ticket ticket = ticketService.getTicketByTicketId(ticketId);
        model.addAttribute("tickets", ticket);
        return "contentpage";

    }

    @RequestMapping("/search")
    public String findTicketsByTicketShortDescription(@Param("keyword") String keyword, Model model) {
        if (keyword != null) {

            Ticket ticketDesc = ticketService.findTicketsByTicketShortDescriptionIgnoreCaseAndAndTicketTitle(keyword, keyword);
            model.addAttribute("tickets", ticketDesc);
        } else {
            List<Ticket> ticket1 = ticketService.displayTicketDetails();
            model.addAttribute("tickets", "ticket1");
        }

        return "listtickets";
    }

}
