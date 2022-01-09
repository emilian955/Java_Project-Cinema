package com.example.entities;

import javax.persistence.*;

@Table(name = "admins")
@Entity
@NamedQueries({
        @NamedQuery(name = "Admins.getAll",
                query = "SELECT a FROM AdminEntity a"),
        @NamedQuery(name = "Admins.findByID",
                query = "SELECT a FROM AdminEntity a WHERE a.id = :id")
})
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin", nullable = false)
    private Integer id;

    @Column(name = "admin_name", nullable = false)
    private String adminName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}