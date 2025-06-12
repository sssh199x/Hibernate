package com.exosolve;


import jakarta.persistence.*;
// Class Name ----> Entity Name ----> Table Name
@Entity
// if you want to change the table name, below is the syntax
//@Table(name="alien_table")
public class Alien {

    @Id
    private int aId;

    //     if you want to change the column name below is the syntax
    //     @Column(name = "alien_name")
    private String aName;

    // if you want to store it only in the object reference but not in the database
    //    @Transient
    private String alienType;

    private Laptop laptop;

    public String getaName() {
        return aName;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", alienType='" + alienType + '\'' +
                ", laptop=" + laptop +
                '}';
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getAlienName() {
        return aName;
    }

    public void setAlienName(String aName) {
        this.aName = aName;
    }

    public String getAlienType() {
        return alienType;
    }

    public void setAlienType(String alienType) {
        this.alienType = alienType;
    }

}
