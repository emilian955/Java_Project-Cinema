package com.example.Beans;

import com.example.entities.TicketEntity;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.faces.bean.ViewScoped;

import static com.example.config.Logger.log;

@Stateless
@ViewScoped
public class NotificationBean {

    public void ticketsBoughtNotification(@Observes TicketEntity ticket){
        log("A ticket has been reserved:");
        log("id: " + ticket.getId().toString());
        log("email: " + ticket.getEmail());
        log("buyer: " +ticket.getNameBuyer());
    }
}
