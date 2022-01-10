package com.example.services.adds;

import com.example.entities.ProjectionEntity;
import com.example.entities.TicketEntity;
import com.example.repositories.ProjectionRepository;
import com.example.repositories.TicketRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

import static com.example.config.Logger.log;

@Path("/tickets")
@ApplicationScoped
public class AddTicketService {
    @EJB
    private TicketRepository ticketRepo;
    @EJB
    private ProjectionRepository projectionRepo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTicketAndResponse(TicketEntity ticket) {
        ticketRepo.save(ticket);
        ProjectionEntity projectToBeUpdated = projectionRepo.findByID(ticket.getIdProjection().getId());
        projectionRepo.updateAvailableSeats(projectToBeUpdated);
        URI uri = UriBuilder.fromResource(this.getClass()).path("" + ticket.getId()).build();
        log("POST service called with path: http://localhost:8080/Cinema_Application-1.0-SNAPSHOT/resources/tickets");
        return Response.created(uri).entity(ticket).build();
    }
}
