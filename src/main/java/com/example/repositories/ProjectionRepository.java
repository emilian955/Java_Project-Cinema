package com.example.repositories;

import com.example.entities.ProjectionEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ProjectionRepository {

    @Inject
    protected EntityManager cinemaPU;

    public ProjectionRepository() {
    }

    public void save(ProjectionEntity projection) {
        cinemaPU.getTransaction().begin();
        cinemaPU.persist(projection);
        cinemaPU.getTransaction().commit();
    }

    public List<ProjectionEntity> getAll() {
        Query query = cinemaPU.createNamedQuery("Projections.getAll");
        return ((Collection<ProjectionEntity>) query.getResultList()).stream().collect(Collectors.toList());
    }

    //might not work, must test
    public ProjectionEntity findByID(Integer id) {
        Query query = cinemaPU.createNamedQuery("Projections.findByID");
        //id is integer here, but method "setParameter" might take only Strings
        query.setParameter("id", id);

        Collection projectionResults = query.getResultList();
        return (ProjectionEntity) projectionResults.iterator().next();
    }

    public ProjectionEntity findByName(String name) {
        Query query = cinemaPU.createNamedQuery("Projections.findByName");
        query.setParameter("name", name);

        Collection projectionResults = query.getResultList();
        return (ProjectionEntity) projectionResults.iterator().next();
    }

    public boolean remove(String name) {
        try {
            Query query = cinemaPU.createNamedQuery("Projections.findByName");
            query.setParameter("name", name);

            ProjectionEntity entryToBeRemoved = findByName(name);
            cinemaPU.getTransaction().begin();
            cinemaPU.remove(entryToBeRemoved);
            cinemaPU.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean remove(Integer id) {
        try {
            Query query = cinemaPU.createNamedQuery("Projections.findByID");
            query.setParameter("id", id);

            ProjectionEntity entryToBeRemoved = findByID(id);
            cinemaPU.getTransaction().begin();
            cinemaPU.remove(entryToBeRemoved);
            cinemaPU.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
