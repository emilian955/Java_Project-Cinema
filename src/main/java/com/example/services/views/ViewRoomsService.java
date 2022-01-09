package com.example.services.views;

import com.example.entities.RoomEntity;
import com.example.repositories.RoomRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/rooms")
@ApplicationScoped
public class ViewRoomsService {
    @EJB
    private RoomRepository roomRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoomEntity> getAllProjections() {
        return roomRepo.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RoomEntity findByID(@PathParam("id") Integer id) {
        return roomRepo.findByID(id);
    }
}
