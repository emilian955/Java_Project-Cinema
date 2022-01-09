package com.example.repositories;

import com.example.entities.RoomEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class RoomRepository {

    @Inject
    protected EntityManager cinemaPU;

    public RoomRepository() {
    }

    public void save(RoomRepository room) {
        cinemaPU.getTransaction().begin();
        cinemaPU.persist(room);
        cinemaPU.getTransaction().commit();
    }

    public List<RoomEntity> getAll() {
        Query query = cinemaPU.createNamedQuery("Rooms.getAll");
        return ((Collection<RoomEntity>) query.getResultList()).stream().collect(Collectors.toList());
    }

    //might not work, must test
    public RoomEntity findByID(Integer id) {
        Query query = cinemaPU.createNamedQuery("Rooms.findByID");
        //id is integer here, but method "setParameter" might take only Strings
        query.setParameter("id", id);

        Collection roomResults = query.getResultList();
        return (RoomEntity) roomResults.iterator().next();
    }

    public boolean remove(Integer id) {
        try {
            Query query = cinemaPU.createNamedQuery("Rooms.findByID");
            query.setParameter("id", id);

            RoomEntity entryToBeRemoved = findByID(id);
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
