package com.example.repositories;

import com.example.entities.TicketEntity;

import javax.ejb.Stateless;
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
        Query query = cinemaPU.createNamedQuery("Tickets.getAll");
        return ((Collection<TicketEntity>) query.getResultList()).stream().collect(Collectors.toList());
    }

    public List<TicketEntity> getAvailableTickets() {
        Query query = cinemaPU.createNamedQuery("Tickets.getAvailableTickets");
        return ((Collection<TicketEntity>) query.getResultList()).stream().collect(Collectors.toList());
    }

    //might not work, must test
    public TicketEntity findByID(Integer id) {
        Query query = cinemaPU.createNamedQuery("Tickets.findByID");
        //id is integer here, but method "setParameter" might take only Strings
        query.setParameter("id", id);

        Collection ticketResults = query.getResultList();
        return (TicketEntity) ticketResults.iterator().next();
    }

    public ArrayList<TicketEntity> findByEmail(String email) {
        Query query = cinemaPU.createNamedQuery("Tickets.findByEmail");
        query.setParameter("email", email);

        ArrayList<TicketEntity> ticketsForCertainMail = new ArrayList<>();

        Collection ticketResults = query.getResultList();
        Iterator<TicketEntity> ticketIterator = ticketResults.iterator();
        while (ticketIterator.hasNext()) {
            ticketsForCertainMail.add(ticketIterator.next());
        }
        return ticketsForCertainMail;
    }

    public boolean remove(String email) {
        try {
            Query query = cinemaPU.createNamedQuery("Tickets.findByEmail");
            query.setParameter("email", email);
            ArrayList<TicketEntity> ticketsForCertainMail = findByEmail(email);
            cinemaPU.getTransaction().begin();
            for (TicketEntity ticket : ticketsForCertainMail) {
                cinemaPU.remove(ticket);
            }
            cinemaPU.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean remove(Integer id) {
        try {
            Query query = cinemaPU.createNamedQuery("Tickets.findByID");
            query.setParameter("id", id);

            TicketEntity entryToBeRemoved = findByID(id);
            cinemaPU.getTransaction().begin();
            cinemaPU.remove(entryToBeRemoved);
            cinemaPU.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}