package com.example.services.adds;

import com.example.entities.RoomEntity;
import com.example.repositories.RoomRepository;

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

@Path("/rooms")
@ApplicationScoped
public class AddRoomService {
    @EJB
    private RoomRepository roomRepo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRoomAndResponse(RoomEntity room) {
        roomRepo.save(room);
        URI uri = UriBuilder.fromResource(this.getClass()).path("" + room.getId()).build();
        log("POST service called with path: http://localhost:8080/Cinema_Application-1.0-SNAPSHOT/resources/rooms");
        return Response.created(uri).entity(room).build();
    }
}
