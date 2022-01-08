package com.example.Beans;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean(name = "RoomBean")
public class RoomBean {
    private int id;
    @NotNull
    @Min(value=5,message = "Rows should not be below 5")
    @Max(value=10,message = "Rows should not be above 10")
    private int no_of_rows;
    @NotNull
    @Min(value=5,message = "Columns should not be below 5")
    @Max(value=10,message = "Columns should not be above 10")
    private int no_of_columns;

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
}
