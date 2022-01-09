package com.example.entities;

import javax.persistence.*;

@Table(name = "tickets")
@Entity
@NamedQueries({
        @NamedQuery(name="Tickets.getAll",
                query="SELECT t FROM TicketEntity t"),
        @NamedQuery(name="Tickets.findByID",
                query="SELECT t FROM TicketEntity t WHERE t.id = :id"),
        @NamedQuery(name="Tickets.findByEmail",
                query="SELECT t FROM TicketEntity t WHERE t.email = :email"),
        @NamedQuery(name="Tickets.findByMovie",
                query="SELECT t FROM TicketEntity t WHERE t.idProjection = :id")

})
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_projection", nullable = false)
    private ProjectionEntity idProjection;

    @Column(name = "no_of_row", nullable = false)
    private Integer noOfRow;

    @Column(name = "no_of_column", nullable = false)
    private Integer noOfColumn;

    @Column(name = "name_buyer", nullable = false)
    private String nameBuyer;

    @Column(name = "email", nullable = false)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameBuyer() {
        return nameBuyer;
    }

    public void setNameBuyer(String nameBuyer) {
        this.nameBuyer = nameBuyer;
    }

    public Integer getNoOfColumn() {
        return noOfColumn;
    }

    public void setNoOfColumn(Integer noOfColumn) {
        this.noOfColumn = noOfColumn;
    }

    public Integer getNoOfRow() {
        return noOfRow;
    }

    public void setNoOfRow(Integer noOfRow) {
        this.noOfRow = noOfRow;
    }

    public ProjectionEntity getIdProjection() {
        return idProjection;
    }

    public void setIdProjection(ProjectionEntity idProjection) {
        this.idProjection = idProjection;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}