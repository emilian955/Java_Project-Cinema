package com.example.repositories;

import com.example.entities.AdminEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class AdminRepository {

    @Inject
    protected EntityManager cinemaPU;

    public AdminRepository() {
    }

    public void save(AdminRepository admin) {
        cinemaPU.getTransaction().begin();
        cinemaPU.persist(admin);
        cinemaPU.getTransaction().commit();
    }

    public List<AdminEntity> getAll() {
        Query query = cinemaPU.createNamedQuery("Admins.getAll");
        return ((Collection<AdminEntity>) query.getResultList()).stream().collect(Collectors.toList());
    }

    public AdminEntity findByID(Integer id) {
        Query query = cinemaPU.createNamedQuery("Admins.findByID");
        //id is integer here, but method "setParameter" might take only Strings
        query.setParameter("id", id);
        Collection projectionResults = query.getResultList();
        return (AdminEntity) projectionResults.iterator().next();
    }

    public boolean remove(Integer id) {
        try {
            Query query = cinemaPU.createNamedQuery("Admins.findByID");
            query.setParameter("id", id);
            AdminEntity entryToBeRemoved = findByID(id);
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
