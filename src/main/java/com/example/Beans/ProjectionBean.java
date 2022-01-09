package com.example.Beans;

import com.example.entities.ProjectionEntity;
import com.example.repositories.ProjectionRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@ManagedBean(name = "ProjectionBean")
public class ProjectionBean {
    @NotNull
    public int id;
    @NotNull
    private int id_room;
    @NotNull
    @Size(min = 1, max = 255)
    private String movie_title;
    @NotNull
    @Size(min = 1, max = 10)
    private String start_time;
    @NotNull
    @Size(min = 1, max = 10)
    private String duration;

    @EJB
    private ProjectionRepository projectRepo;

    public List<ProjectionEntity> allProjections;

    public List<ProjectionEntity> getAll() {
        System.out.println("getAll");
        return projectRepo.getAll();
    }

    public List<ProjectionEntity> getAllProjections() {
        return allProjections;
    }

    public void setAllProjections(List<ProjectionEntity> allProjections) {
        this.allProjections = allProjections;
    }

    public ProjectionBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getLength() {
        return duration;
    }

    public void setLength(String length) {
        this.duration = length;
    }
}
