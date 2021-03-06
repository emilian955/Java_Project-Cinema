package com.example.Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.IOException;

@ManagedBean(name = "TicketBean")
public class TicketBean {
    @NotNull
    private int id_ticket;
    @NotNull
    private int id_projection;
    @NotNull
    private int no_of_row;
    @NotNull
    private int no_of_column;
    @NotNull
    @Size(min = 1, max = 100)
    private String name_buyer;
    @NotNull
    @Size(min = 1, max = 100)
    private String email;

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public int getId_projection() {
        return id_projection;
    }

    public void setId_projection(int id_projection) {
        this.id_projection = id_projection;
    }

    public int getNo_of_row() {
        return no_of_row;
    }

    public void setNo_of_row(int no_of_row) {
        this.no_of_row = no_of_row;
    }

    public int getNo_of_column() {
        return no_of_column;
    }

    public void setNo_of_column(int no_of_column) {
        this.no_of_column = no_of_column;
    }

    public String getName_buyer() {
        return name_buyer;
    }

    public void setName_buyer(String name_buyer) {
        this.name_buyer = name_buyer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void redirect_to_page() throws  IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/Reserve_ticket_page.html");
    }
}
