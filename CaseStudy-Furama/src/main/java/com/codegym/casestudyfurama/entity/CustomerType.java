package com.codegym.casestudyfurama.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loaikhach")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idloaikhach")
    private long id;

    @Column(name = "tenloaikhach")
    private String nameCustomerType;

    @OneToMany(targetEntity = Customer.class)
    private List<Customer> customers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameCustomerType() {
        return nameCustomerType;
    }

    public void setNameCustomerType(String nameCustomerType) {
        this.nameCustomerType = nameCustomerType;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public CustomerType() {
    }
}
