package com.codegym.demospringjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public long id;

    @Column(name = "name")
    public String name;

    @Column(name = "age")
    public long age;

    @Column(name = "email")
    String email;

    @Column(name = "departmentid")
    public long departmentid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(long departmentid) {
        this.departmentid = departmentid;
    }

    public Employee() {
    }
}
