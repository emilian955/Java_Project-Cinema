package com.example.Beans;

import com.example.entities.ProjectionEntity;
import com.example.entities.RoomEntity;
import com.example.entities.TicketEntity;
import com.example.repositories.ProjectionRepository;
import com.example.repositories.RoomRepository;
import com.example.repositories.TicketRepository;
import org.primefaces.model.DualListModel;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "PickListRoomBean")
public class PickListRoomBean {
    private DualListModel<RoomEntity> listModel;
    @EJB
    private ProjectionRepository projectionRepo;
    @EJB
    private RoomRepository roomRepo;
    @EJB
    private TicketRepository ticketRepo;

    @PostConstruct
    public void init() {
        //initial unselected list
        List<RoomEntity> sourceList = new ArrayList<RoomEntity>(roomRepo.getAll());

        //initial selected list
        List<RoomEntity> destinationList = new ArrayList<>();

        listModel = new DualListModel<>(new ArrayList<>(sourceList), destinationList);
    }

    public DualListModel<RoomEntity> getListModel() {
        return listModel;
    }

    public void setListModel(DualListModel<RoomEntity> listModel) {
        this.listModel = listModel;
    }

    public void remove(PickListRoomBean room){
        List<RoomEntity> temp = room.listModel.getTarget();
        for(RoomEntity k : temp){
            List<ProjectionEntity> projectionsToBeDeleted = projectionRepo.getAll();
            for(ProjectionEntity t: projectionsToBeDeleted){
                List<TicketEntity> ticketsToBeDeleted = ticketRepo.findByMovie(t.getMovieTitle());
                for(TicketEntity z: ticketsToBeDeleted){
                    ticketRepo.remove(z.getId());
                }
                projectionRepo.remove(t.getId());
            }
            roomRepo.remove(k.getId());
        }
        List<RoomEntity> sourceList = new ArrayList<>(roomRepo.getAll());
        List<RoomEntity> destinationList = new ArrayList<>();
        listModel = new DualListModel<>(new ArrayList<>(sourceList), destinationList);
    }

}
