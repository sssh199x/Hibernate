package com.exosolve;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class ManyToManyLaptopEntity {
    @Id
    private int lid;
    private  String brand;
    private  String model;
    private  int ram;
    // manyToManyLaptopEntities is the name of instance variable in ManyToManyAlienEntity class, and its telling let the ManyToManyAlienEntity class handle it and not create 4 tables.
    @ManyToMany(mappedBy = "manyToManyLaptopEntities")
    private List<ManyToManyAlienEntity> manyToManyAlienEntities;

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

    public List<ManyToManyAlienEntity> getManyToManyAlienEntities() {
        return manyToManyAlienEntities;
    }

    public void setManyToManyAlienEntities(List<ManyToManyAlienEntity> manyToManyAlienEntities) {
        this.manyToManyAlienEntities = manyToManyAlienEntities;
    }

    @Override
    public String toString() {
        return "ManyToManyLaptopEntity{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
