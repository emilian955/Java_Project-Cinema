package com.example.Beans;

import com.example.entities.RoomEntity;
import com.example.repositories.RoomRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name = "RoomBean")
public class RoomBean {
    private int id;
    @NotNull
    @Min(value = 5, message = "Rows should not be below 5")
    @Max(value = 10, message = "Rows should not be above 10")
    private int no_of_rows;
    @NotNull
    @Min(value = 5, message = "Columns should not be below 5")
    @Max(value = 10, message = "Columns should not be above 10")
    private int no_of_columns;
    @EJB
    private RoomRepository roomRepo;

    public RoomBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo_of_rows() {
        return no_of_rows;
    }

    public void setNo_of_rows(int no_of_rows) {
        this.no_of_rows = no_of_rows;
    }

    public int getNo_of_columns() {
        return no_of_columns;
    }

    public void setNo_of_columns(int no_of_columns) {
        this.no_of_columns = no_of_columns;
    }
    public List<Integer> return_ids(){
        List<Integer> ids = new ArrayList<Integer>();
        List<RoomEntity> roomEntities=roomRepo.getAll();
        for(RoomEntity i:roomEntities){
            System.out.println("Aici");
            System.out.println(i.getId());
                ids.add(i.getId());
        }
        return ids;
    }

    public void add(RoomBean room){
        RoomEntity roomEntity=new RoomEntity();
        roomEntity.setNoOfRows(room.getNo_of_rows());
        roomEntity.setNoOfColumns(room.getNo_of_columns());
        roomRepo.save(roomEntity);
        System.out.println("The room was added");
    }
}
