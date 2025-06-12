package com.exosolve;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class WorkingWithEmbeddable {

    public static void main(String[] args) {

        Laptop laptop = new Laptop();
        laptop.setBrand("Samsung");
        laptop.setModel("Vivo");
        laptop.setRam(4);

        Alien alien = new Alien();
        alien.setaId(101);
        alien.setaName("Sanjeev");
        alien.setAlienType("Very Weak");
        alien.setLaptop(laptop);


        try (SessionFactory sessionFactory = new Configuration().addAnnotatedClass(com.exosolve.Alien.class).configure().buildSessionFactory()) {

            Session session = sessionFactory.openSession();
           Transaction transaction = session.beginTransaction();
           session.persist(alien);
           Alien alien2 = session.get(Alien.class, 101);
           transaction.commit();
           session.close();

            System.out.println(alien2.getLaptop());

        }



    }
}
