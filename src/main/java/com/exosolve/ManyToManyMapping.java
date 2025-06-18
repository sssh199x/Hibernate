package com.exosolve;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class ManyToManyMapping {


    public static void main(String[] args) {
        ManyToManyLaptopEntity manyToManyLaptopEntity1 = new ManyToManyLaptopEntity();
        manyToManyLaptopEntity1.setLid(1);
        manyToManyLaptopEntity1.setBrand("ASUS");
        manyToManyLaptopEntity1.setModel("ROG");
        manyToManyLaptopEntity1.setRam(16);

        ManyToManyLaptopEntity manyToManyLaptopEntity2 = new ManyToManyLaptopEntity();
        manyToManyLaptopEntity2.setLid(2);
        manyToManyLaptopEntity2.setBrand("DELL");
        manyToManyLaptopEntity2.setModel("XPS");
        manyToManyLaptopEntity2.setRam(32);

        ManyToManyLaptopEntity manyToManyLaptopEntity3 = new ManyToManyLaptopEntity();
        manyToManyLaptopEntity3.setLid(3);
        manyToManyLaptopEntity3.setBrand("APPLE");
        manyToManyLaptopEntity3.setModel("MACBOOK AIR");
        manyToManyLaptopEntity3.setRam(64);


        ManyToManyAlienEntity manyToManyAlienEntity1 = new ManyToManyAlienEntity();
        manyToManyAlienEntity1.setId(101);
        manyToManyAlienEntity1.setaName("NAVIN");
        manyToManyAlienEntity1.setTech("JAVA");

        ManyToManyAlienEntity manyToManyAlienEntity2 = new ManyToManyAlienEntity();
        manyToManyAlienEntity2.setId(102);
        manyToManyAlienEntity2.setaName("SANDESH");
        manyToManyAlienEntity2.setTech("ANGULAR");

        ManyToManyAlienEntity manyToManyAlienEntity3 = new ManyToManyAlienEntity();
        manyToManyAlienEntity3.setId(103);
        manyToManyAlienEntity3.setaName("NISHAN");
        manyToManyAlienEntity3.setTech("FLUTTER");


        manyToManyAlienEntity1.setManyToManyLaptopEntities(Arrays.asList(manyToManyLaptopEntity1, manyToManyLaptopEntity2));
        manyToManyAlienEntity2.setManyToManyLaptopEntities(Arrays.asList(manyToManyLaptopEntity2, manyToManyLaptopEntity3));
        manyToManyAlienEntity3.setManyToManyLaptopEntities(Arrays.asList(manyToManyLaptopEntity1));

        manyToManyLaptopEntity1.setManyToManyAlienEntities(Arrays.asList(manyToManyAlienEntity1, manyToManyAlienEntity3));
        manyToManyLaptopEntity2.setManyToManyAlienEntities(Arrays.asList(manyToManyAlienEntity1, manyToManyAlienEntity2));
        manyToManyLaptopEntity3.setManyToManyAlienEntities(Arrays.asList(manyToManyAlienEntity2));


        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(com.exosolve.ManyToManyAlienEntity.class)
                .addAnnotatedClass(com.exosolve.ManyToManyLaptopEntity.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            session.persist(manyToManyAlienEntity1);
            session.persist(manyToManyAlienEntity2);
            session.persist(manyToManyAlienEntity3);

            session.persist(manyToManyLaptopEntity1);
            session.persist(manyToManyLaptopEntity2);
            session.persist(manyToManyLaptopEntity3);

            transaction.commit();


            ManyToManyAlienEntity getTheSavedEntity = session.get(ManyToManyAlienEntity.class, manyToManyAlienEntity2.getId());

            System.out.println(getTheSavedEntity);

            session.close();
        }
    }
}
