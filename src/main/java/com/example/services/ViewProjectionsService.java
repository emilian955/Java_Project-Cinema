package com.example.services;

import com.example.entities.ProjectionEntity;
import com.example.repositories.ProjectionRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/projections")
@ApplicationScoped
public class ViewProjectionsService {
    @EJB
    private ProjectionRepository projectionsRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProjectionEntity> getAllProjections(){
        return projectionsRepo.getAll();
    }
}
