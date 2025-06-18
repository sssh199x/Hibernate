package com.exosolve;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OneToManyLaptopEntity {
    @Id
    private int lid;
    private String brand;
    private String model;
    private int ram;
    @ManyToOne
    private OneToManyAlienEntity oneToManyAlienEntity;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public OneToManyAlienEntity getOneToManyAlienEntity() {
        return oneToManyAlienEntity;
    }

    public void setOneToManyAlienEntity(OneToManyAlienEntity oneToManyAlienEntity) {
        this.oneToManyAlienEntity = oneToManyAlienEntity;
    }

    @Override
    public String toString() {
        return "OneToManyLaptopEntity{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
