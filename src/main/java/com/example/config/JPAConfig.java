package com.example.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class JPAConfig {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamManagerPU");

    @Produces
    public EntityManager createEM(){
        return emf.createEntityManager();
    }
}