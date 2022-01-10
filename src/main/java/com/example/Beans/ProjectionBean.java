package com.example.Beans;

import com.example.entities.ProjectionEntity;
import com.example.entities.RoomEntity;
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
    private RoomEntity id_room;
    @NotNull
    @Size(min = 1, max = 255)
    private String movie_title;
    @NotNull
    @Size(min = 1, max = 10)
    private String start_time;
    @NotNull
    @Size(min = 1, max = 10)
    private String duration;
    @NotNull
    private int available_places;
    @NotNull
    @Size(min=1,max=10)
    private String poster_url;
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

    public RoomEntity getId_room() {
        return id_room;
    }

    public void setId_room(RoomEntity id_room) {
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getAvailable_places() {
        return available_places;
    }

    public void setAvailable_places(int available_places) {
        this.available_places = available_places;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }

    public void add(ProjectionBean projection){
        ProjectionEntity projectionEntity = null;
        projectionEntity.setIdRoom(projection.getId_room());
        projectionEntity.setMovieTitle(projection.getMovie_title());
        projectionEntity.setStartTime(projection.getStart_time());
        projectionEntity.setDuration(projection.getDuration());
        projectionEntity.setAvailablePlaces(projection.getAvailable_places());
        projectionEntity.setPosterUrl(projection.getPoster_url());
        projectRepo.save(projectionEntity);
    }
}
