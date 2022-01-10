package com.example.services.views;

import com.example.entities.TicketEntity;
import com.example.repositories.TicketRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static com.example.config.Logger.log;

@Path("/tickets")
@ApplicationScoped
public class ViewTicketsService {
    @EJB
    private TicketRepository ticketsRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TicketEntity> getAllProjections() {
        log("GET service called with path: http://localhost:8080/Cinema_Application-1.0-SNAPSHOT/resources/tickets");
        return ticketsRepo.getAll();
    }

    @GET
    @Path("/findById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TicketEntity findByID(@PathParam("id") Integer id) {
        log("GET service called with path: http://localhost:8080/Cinema_Application-1.0-SNAPSHOT/resources/tickets/findById/" + id.toString());
        return ticketsRepo.findByID(id);
    }

    @GET
    @Path("/findByEmail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<TicketEntity> findByEmail(@PathParam("email") String email) {
        log("GET service called with path: http://localhost:8080/Cinema_Application-1.0-SNAPSHOT/resources/tickets/findByEmail/" + email);
        return ticketsRepo.findByEmail(email);
    }

    @GET
    @Path("/findByMovie/{movie}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<TicketEntity> findByMovie(@PathParam("movie") String movie) {
        log("GET service called with path: http://localhost:8080/Cinema_Application-1.0-SNAPSHOT/resources/tickets/findByMovie/" + movie);
        return ticketsRepo.findByMovie(movie);
    }
}
