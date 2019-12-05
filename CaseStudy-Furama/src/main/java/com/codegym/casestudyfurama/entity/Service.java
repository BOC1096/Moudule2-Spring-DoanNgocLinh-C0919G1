package com.codegym.casestudyfurama.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dichvu")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddichvu")
    private long id;

    @Column(name = "tendichvu")
    private String nameService;

    @Column(name = "dientich")
    private double area;

    @Column(name = "sotang")
    private int numberFloor;

    @Column(name = "songuoitoida")
    private int maxPeople;

    @Column(name = "chiphithue")
    private double rentPrice;

    @Column(name = "trangthai")
    private boolean status;

    @Column(name = "hinh")
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @OneToMany(targetEntity = Contract.class)
    private List<Contract> contracts;

    @ManyToOne
    @JoinColumn(name = "idkieuthue")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "idloaidichvu")
    private ServiceType serviceType;

    public Service() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
