package com.example.repositories;

import com.example.entities.TicketEntity;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class TicketRepository {

    @Inject
    protected EntityManager cinemaPU;

//    protected @Inject
//    Event<TicketEntity> ticketEvent;

    public TicketRepository() {
    }

    public void save(TicketEntity ticket) {
        cinemaPU.getTransaction().begin();
        cinemaPU.persist(ticket);
//        ticketEvent.fire(ticket);
        cinemaPU.getTransaction().commit();
    }

    public List<TicketEntity> getAll() {
        Query query = cinemaPU.createNamedQuery("Ticket.getAll");
        return ((Collection<TicketEntity>) query.getResultList()).stream().collect(Collectors.toList());
    }

    public List<TicketEntity> getFreeTickets() {
        Query query = cinemaPU.createNamedQuery("Ticket.getFreeTickets");
        return ((Collection<TicketEntity>) query.getResultList()).stream().collect(Collectors.toList());
    }

    public ArrayList<TicketEntity> findByEmail(String email) {
        Query query = cinemaPU.createNamedQuery("Ticket.findByEmail");
        query.setParameter("email", email);

        ArrayList<TicketEntity> ticketsForCertainMail = new ArrayList<>();

        Collection ticketResults = query.getResultList();
        Iterator<TicketEntity> ticketIterator = ticketResults.iterator();
        while (ticketIterator.hasNext()) {
            ticketsForCertainMail.add(ticketIterator.next());
        }
        return ticketsForCertainMail;
    }

    public void remove(String email){
        Query query = cinemaPU.createNamedQuery("Ticket.findByEmail");
        query.setParameter("email", email);
        ArrayList<TicketEntity> ticketsForCertainMail = findByEmail(email);
        cinemaPU.getTransaction().begin();
        for (TicketEntity ticket : ticketsForCertainMail){
            cinemaPU.remove(ticket);
        }
        cinemaPU.getTransaction().commit();
    }
}