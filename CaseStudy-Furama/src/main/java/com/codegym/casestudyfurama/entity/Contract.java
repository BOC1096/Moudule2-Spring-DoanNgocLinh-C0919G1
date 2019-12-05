package com.codegym.casestudyfurama.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "hopdong")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhopdong")
    private long id;

    @Column(name = "ngaylamhopdong")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dayStart;

    @Column(name = "ngayketthuc")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dayEnd;

    @Column(name = "tiendatcoc")
    private double deposit;

    @Column(name = "tongtien")
    private double total;

//    @Column(name = "idnhanvien")
//    private int employeeId;
//
//    @Column(name = "idkhachhang")
//    private int customerId;

    @ManyToOne
    @JoinColumn(name = "iddichvu")
    private Service service;

    public Contract() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDayStart() {
        return dayStart;
    }

    public void setDayStart(Date dayStart) {
        this.dayStart = dayStart;
    }

    public Date getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(Date dayEnd) {
        this.dayEnd = dayEnd;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

//    public int getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(int employeeId) {
//        this.employeeId = employeeId;
//    }
//
//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
