package com.exosolve;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class ManyToManyAlienEntity {
    @Id
    private Integer id;
    private String aName;
    private String tech;
    @ManyToMany
    private List<ManyToManyLaptopEntity> manyToManyLaptopEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<ManyToManyLaptopEntity> getManyToManyLaptopEntities() {
        return manyToManyLaptopEntities;
    }

    public void setManyToManyLaptopEntities(List<ManyToManyLaptopEntity> manyToManyLaptopEntities) {
        this.manyToManyLaptopEntities = manyToManyLaptopEntities;
    }

    @Override
    public String toString() {
        return "ManyToManyAlienEntity{" +
                "id=" + id +
                ", aName='" + aName + '\'' +
                ", tech='" + tech + '\'' +
                ", manyToManyLaptopEntities=" + manyToManyLaptopEntities +
                '}';
    }
}
