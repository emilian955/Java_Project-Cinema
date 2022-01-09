package com.example.config;


import com.example.services.adds.AddProjectionService;
import com.example.services.adds.AddRoomService;
import com.example.services.adds.AddTicketService;
import com.example.services.views.ViewProjectionsService;
import com.example.services.views.ViewRoomsService;
import com.example.services.views.ViewTicketsService;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/resources")
@ApplicationScoped
public class ServicesConfig extends Application {
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ViewProjectionsService.class);
        resources.add(ViewTicketsService.class);
        resources.add(ViewRoomsService.class);
        resources.add(AddProjectionService.class);
        resources.add(AddRoomService.class);
        resources.add(AddTicketService.class);
        resources.add(CORSFilter.class);
    }

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
}
