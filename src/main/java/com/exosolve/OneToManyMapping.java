package com.exosolve;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class OneToManyMapping {
    public static void main(String[] args) {


        OneToManyLaptopEntity oneToManyLaptopEntity1 = new OneToManyLaptopEntity();
        oneToManyLaptopEntity1.setLid(1);
        oneToManyLaptopEntity1.setBrand("ASUS");
        oneToManyLaptopEntity1.setModel("ROG");
        oneToManyLaptopEntity1.setRam(16);

        OneToManyLaptopEntity oneToManyLaptopEntity2 = new OneToManyLaptopEntity();
        oneToManyLaptopEntity2.setLid(2);
        oneToManyLaptopEntity2.setBrand("DELL");
        oneToManyLaptopEntity2.setModel("XPS");
        oneToManyLaptopEntity2.setRam(32);


        OneToManyAlienEntity oneToManyAlienEntity1 = new OneToManyAlienEntity();
        oneToManyAlienEntity1.setAid(101);
        oneToManyAlienEntity1.setaName("NAVIN");
        oneToManyAlienEntity1.setTech("JAVA");

        // one alien can have multiple laptops.
        oneToManyAlienEntity1.setOneToManyLaptopEntities(Arrays.asList(oneToManyLaptopEntity1, oneToManyLaptopEntity2));
        // multiple laptops can belong to one alien
        oneToManyLaptopEntity1.setOneToManyAlienEntity(oneToManyAlienEntity1);
        oneToManyLaptopEntity2.setOneToManyAlienEntity(oneToManyAlienEntity1);


        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(com.exosolve.OneToManyAlienEntity.class)
                .addAnnotatedClass(com.exosolve.OneToManyLaptopEntity.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            session.persist(oneToManyLaptopEntity1);
            session.persist(oneToManyLaptopEntity2);
            session.persist(oneToManyAlienEntity1);
            transaction.commit();

            OneToManyAlienEntity getTheSavedEntity = session.get(OneToManyAlienEntity.class, oneToManyAlienEntity1.getAid());
            System.out.println(getTheSavedEntity);

            session.close();
        }
    }
}
