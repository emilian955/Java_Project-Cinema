package com.example.Beans;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean(name = "UserBean")
public class UserBean {
    @NotNull
    @Size(min=1, max=100)
    private String user_name;
    @NotNull
    @Size(min=1, max=100)
    private String password;

    public UserBean() {
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
