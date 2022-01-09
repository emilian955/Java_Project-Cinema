package com.example.config;

import com.example.services.CORSFilter;
import com.example.services.ViewProjectionsService;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/resources")
@ApplicationScoped
public class ServicesConfig extends Application {
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ViewProjectionsService.class);
        resources.add(CORSFilter.class);
    }

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
}
