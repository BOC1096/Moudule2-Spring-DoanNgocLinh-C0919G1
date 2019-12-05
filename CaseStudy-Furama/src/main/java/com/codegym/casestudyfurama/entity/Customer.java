package com.codegym.casestudyfurama.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;

@Entity
@Table(name = "khachhang")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idkhachhanng")
    private long id;

    @NotBlank
    @Column(name = "hoten")
    private String fullName;


    @Column(name = "ngaysinh")
    private Date birthday;

    @NotNull
    @Column(name = "socmtnd")
    private String idCard;

    @NotNull
    @Column(name = "sdt")
    private String phoneNumber;

    @NotBlank
    @Email()
    @Column(name = "email")
    private String email;

    @NotBlank(message = "address is not null")
    @Column(name = "diachi")
    private String address;

    @ManyToOne
    @JoinColumn(name = "idloaikhach")
    private CustomerType customerType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Customer() {
    }
}
