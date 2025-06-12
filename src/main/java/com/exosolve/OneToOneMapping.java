package com.exosolve;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMapping {

    public static void main(String[] args) {


        OneToOneLaptopEntity oneToOneLaptopEntity1 = new OneToOneLaptopEntity();
        oneToOneLaptopEntity1.setLid(1);
        oneToOneLaptopEntity1.setBrand("Asus");
        oneToOneLaptopEntity1.setModel("Rog");
        oneToOneLaptopEntity1.setRam(16);


        OneToOneAlienEntity oneToOneAlienEntity1 = new OneToOneAlienEntity();
        oneToOneAlienEntity1.setAid(101);
        oneToOneAlienEntity1.setaName("Navin");
        oneToOneAlienEntity1.setTech("Java");
        oneToOneAlienEntity1.setOneToOneLaptopEntity(oneToOneLaptopEntity1);


        try (SessionFactory sessionFactory = new Configuration().addAnnotatedClass(com.exosolve.OneToOneAlienEntity.class)
                .addAnnotatedClass(com.exosolve.OneToOneLaptopEntity.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()) {
            Session session = sessionFactory.openSession();

           Transaction transaction =  session.beginTransaction();


           session.persist(oneToOneLaptopEntity1);
           session.persist(oneToOneAlienEntity1);
           transaction.commit();

           OneToOneAlienEntity getTheSavedEntity = session.get(OneToOneAlienEntity.class,101);
           System.out.println(getTheSavedEntity);

            session.close();

        }



    }
}
