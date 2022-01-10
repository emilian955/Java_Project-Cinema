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

import static com.example.config.Logger.log;

@Path("/rooms")
@ApplicationScoped
public class ViewRoomsService {
    @EJB
    private RoomRepository roomRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoomEntity> getAllProjections() {
        log("GET service called with path: http://localhost:8080/Cinema_Application-1.0-SNAPSHOT/resources/rooms");
        return roomRepo.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RoomEntity findByID(@PathParam("id") Integer id) {
        log("GET service called with path: http://localhost:8080/Cinema_Application-1.0-SNAPSHOT/resources/projections/" + id.toString());
        return roomRepo.findByID(id);
    }
}
