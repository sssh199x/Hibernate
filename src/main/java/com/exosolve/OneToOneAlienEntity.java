package com.exosolve;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class OneToOneAlienEntity {
    @Id
    private int aid;
    private String aName;
    private String tech;
    @OneToOne
    private OneToOneLaptopEntity oneToOneLaptopEntity;

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

    public OneToOneLaptopEntity getOneToOneLaptopEntity() {
        return oneToOneLaptopEntity;
    }

    public void setOneToOneLaptopEntity(OneToOneLaptopEntity oneToOneLaptopEntity) {
        this.oneToOneLaptopEntity = oneToOneLaptopEntity;
    }

    @Override
    public String toString() {
        return "OneToOneAlienEntity{" +
                "aid=" + aid +
                ", aName='" + aName + '\'' +
                ", tech='" + tech + '\'' +
                ", oneToOneLaptopEntity=" + oneToOneLaptopEntity +
                '}';
    }
}
