package com.example.services.adds;

import com.example.entities.ProjectionEntity;
import com.example.repositories.ProjectionRepository;

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

@Path("/projections")
@ApplicationScoped
public class AddProjectionService {
    @EJB
    private ProjectionRepository projectionRepo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProjectionAndResponse(ProjectionEntity projection) {
        projectionRepo.save(projection);
        URI uri = UriBuilder.fromResource(this.getClass()).path("" + projection.getId()).build();
        log("POST service called with path: http://localhost:8080/Cinema_Application-1.0-SNAPSHOT/resources/projections");
        return Response.created(uri).entity(projection).build();
    }
}
