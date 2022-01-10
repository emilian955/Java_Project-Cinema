package com.example.Beans;

import com.example.entities.ProjectionEntity;
import com.example.entities.TicketEntity;
import com.example.repositories.ProjectionRepository;
import com.example.repositories.TicketRepository;
import org.primefaces.model.DualListModel;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "PickListProjectionBean")
public class PickListProjectionBean {
    private DualListModel<ProjectionEntity> listModel;
    @EJB
    private ProjectionRepository projectionRepo;
    @EJB
    private TicketRepository ticketRepo;

    @PostConstruct
    public void init() {
        //initial unselected list
        List<ProjectionEntity> sourceList = new ArrayList<ProjectionEntity>(projectionRepo.getAll());

        //initial selected list
        List<ProjectionEntity> destinationList = new ArrayList<>();

        listModel = new DualListModel<>(new ArrayList<>(sourceList), destinationList);
    }

    public DualListModel<ProjectionEntity> getListModel() {
        return listModel;
    }

    public void setListModel(DualListModel<ProjectionEntity> listModel) {
        this.listModel = listModel;
    }

    public void remove(PickListProjectionBean projection){
        List<ProjectionEntity> temp = projection.listModel.getTarget();
        for(ProjectionEntity k : temp){
            List<TicketEntity> ticketsToBeDeleted = ticketRepo.findByMovie(k.getMovieTitle());
            for(TicketEntity t: ticketsToBeDeleted){
                ticketRepo.remove(t.getId());
            }
            projectionRepo.remove(k.getId());
        }
        List<ProjectionEntity> sourceList = new ArrayList<>(projectionRepo.getAll());
        List<ProjectionEntity> destinationList = new ArrayList<>();
        listModel = new DualListModel<>(new ArrayList<>(sourceList), destinationList);
    }
}
