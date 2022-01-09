package com.example.Beans;

import com.example.entities.AdminEntity;
import com.example.entities.ProjectionEntity;
import com.example.repositories.AdminRepository;
import com.example.repositories.ProjectionRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@ManagedBean(name = "AdminBean")
public class AdminBean {
    @NotNull
    private int id_admin;
    @NotNull
    @Size(min=1, max=100)
    private String admin_name;
    @NotNull
    @Size(min=1, max=100)
    private String password;
    @NotNull
    @Size(min=1, max=100)
    private String email;
    @EJB
    private AdminRepository adminRepository;

    public List<AdminEntity> allAdmins;

    public AdminBean() {
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public boolean login(AdminBean user){
        allAdmins=adminRepository.getAll();
        for (AdminEntity i : allAdmins){
            if(Objects.equals(i.getAdminName(), user.getAdmin_name()) && Objects.equals(i.getPassword(), user.getPassword())){
                System.out.println("The login was successful");
                FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null,  "/After_login_page.xhtml");
                return true;
            }
        }
        return false;
    }
}
