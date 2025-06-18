package com.exosolve;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class OneToManyAlienEntity {
    @Id
    private int aid;
    private String aName;
    private String tech;
    // oneToManyAlienEntity is the name of instance variable in OneToManyLaptopEntity class, and it is telling let the OneToManyLaptopEntity class handle it and not create the 3 tables.
    @OneToMany(mappedBy = "oneToManyAlienEntity")
    private List<OneToManyLaptopEntity> oneToManyLaptopEntities;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public List<OneToManyLaptopEntity> getOneToManyLaptopEntities() {
        return oneToManyLaptopEntities;
    }

    public void setOneToManyLaptopEntities(List<OneToManyLaptopEntity> oneToManyLaptopEntities) {
        this.oneToManyLaptopEntities = oneToManyLaptopEntities;
    }

    @Override
    public String toString() {
        return "OneToManyAlienEntity{" +
                "aid=" + aid +
                ", aName='" + aName + '\'' +
                ", tech='" + tech + '\'' +
                ", oneToManyLaptopEntities=" + oneToManyLaptopEntities +
                '}';
    }
}
