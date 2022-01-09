package com.example.entities;

import javax.persistence.*;

@Table(name = "rooms")
@Entity
@NamedQueries({
        @NamedQuery(name = "Rooms.getAll",
                query = "SELECT r FROM RoomEntity r"),
        @NamedQuery(name = "Rooms.findByID",
                query = "SELECT r FROM RoomEntity r WHERE r.id = :id")
})
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_room", nullable = false)
    private Integer id;

    @Column(name = "no_of_rows", nullable = false)
    private Integer noOfRows;

    @Column(name = "no_of_columns", nullable = false)
    private Integer noOfColumns;

    public Integer getNoOfColumns() {
        return noOfColumns;
    }

    public void setNoOfColumns(Integer noOfColumns) {
        this.noOfColumns = noOfColumns;
    }

    public Integer getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(Integer noOfRows) {
        this.noOfRows = noOfRows;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}