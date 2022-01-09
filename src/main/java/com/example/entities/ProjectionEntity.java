package com.example.entities;

import javax.persistence.*;

@Table(name = "projections")
@Entity
@NamedQueries({
        @NamedQuery(name="Projections.getAll",
                query="SELECT p FROM ProjectionEntity p"),
        @NamedQuery(name="Projections.findByID",
                query="SELECT p FROM ProjectionEntity p WHERE p.id = :id"),
        @NamedQuery(name="Projections.findByName",
                query="SELECT p FROM ProjectionEntity p WHERE p.movieTitle = :name"),
        @NamedQuery(name="Projections.findByRoom",
                query="SELECT p FROM ProjectionEntity p WHERE p.idRoom = :id")

})
public class ProjectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projection", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_room", nullable = false)
    private RoomEntity idRoom;

    @Column(name = "movie_title", nullable = false)
    private String movieTitle;

    @Column(name = "start_time", nullable = false, length = 10)
    private String startTime;

    @Column(name = "duration", nullable = false, length = 10)
    private String duration;

    @Column(name = "available_places", nullable = false)
    private Integer availablePlaces;

    @Column(name = "poster_url", nullable = false)
    private String posterUrl;

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public Integer getAvailablePlaces() {
        return availablePlaces;
    }

    public void setAvailablePlaces(Integer availablePlaces) {
        this.availablePlaces = availablePlaces;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public RoomEntity getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(RoomEntity idRoom) {
        this.idRoom = idRoom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}