package com.codegym.casestudyfurama.entity;

import javax.persistence.*;

@Entity
@Table(name = "approle")
public class AppRole {
    @Id
    @GeneratedValue
    @Column(name = "roleid")
    private Long id;

    @Column(name = "rolename")
    private String nameRole;

    public AppRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
