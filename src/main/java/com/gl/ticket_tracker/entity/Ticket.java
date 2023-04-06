package com.gl.ticket_tracker.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;

    @Column(name = "ticket_title")
    private String ticketTitle;

    @Column(name = "ticket_short_description")
    private String ticketShortDescription;

    @Column(name = "content")
    private String content;

    @Column(name = "ticket_created_on")
    private Date date = new Date(System.currentTimeMillis());




}
