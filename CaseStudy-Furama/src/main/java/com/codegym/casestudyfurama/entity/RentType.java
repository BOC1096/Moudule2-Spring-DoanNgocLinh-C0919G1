package com.codegym.casestudyfurama.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kieuthue")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idkieuthue")
    private long id;

    @Column(name = "tenkieuthue")
    private String nameRent;

    @Column(name = "gia")
    private double price;

    @OneToMany(targetEntity = Service.class)
    private List<Service> services;

    public RentType() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameRent() {
        return nameRent;
    }

    public void setNameRent(String nameRent) {
        this.nameRent = nameRent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
