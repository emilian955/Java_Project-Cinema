package com.example.services.views;

import com.example.entities.ProjectionEntity;
import com.example.entities.TicketEntity;
import com.example.repositories.ProjectionRepository;
import com.example.repositories.TicketRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.example.config.Logger.log;

@Path("/projections")
@ApplicationScoped
public class ViewProjectionsService {

    @EJB
    private ProjectionRepository projectionsRepo;
    @EJB
    private TicketRepository ticketsRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProjectionEntity> getAllProjections() {
        log("GET service called with path: http://localhost:8080/Cinema_Application-1.0-SNAPSHOT/resources/projections");
        return projectionsRepo.getAll();
    }

    @GET
    @Path("/soldTickets/{movie}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TicketEntity> getSoldTickets(@PathParam("movie") String movie) {
        log("GET service called with path: http://localhost:8080/Cinema_Application-1.0-SNAPSHOT/resources/projections/soldTickets/" + movie);
        return ticketsRepo.findByMovie(movie);
    }

    @GET
    @Path("/findById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProjectionEntity findById(@PathParam("id") Integer id) {
        log("GET service called with path: http://localhost:8080/Cinema_Application-1.0-SNAPSHOT/resources/projections/findById/" + id.toString());
        return projectionsRepo.findByID(id);
    }

    @GET
    @Path("/findByName/{movieName}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProjectionEntity findByMovie(@PathParam("movieName") String movieName) {
        log("GET service called with path: http://localhost:8080/Cinema_Application-1.0-SNAPSHOT/resources/projections/findByName/" + movieName);
        return projectionsRepo.findByName(movieName);
    }
}
