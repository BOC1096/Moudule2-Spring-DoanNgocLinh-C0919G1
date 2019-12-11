package com.codegym.casestudyfurama.entity;

import javax.persistence.*;

@Entity
@Table(name = "appuser")
public class AppUser {
    @Id
    @GeneratedValue
    @Column(name = "iduser")
    private Long id;


    @Column(name = "username")
    private String userName;

    @Column(name = "encrytedpassword")
    private String encrytedPassword;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "idkhachhang")
    private Customer customer;

    public AppUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
