package com.exosolve;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();

        student.setRollNo(70);
        student.setsName("Bibek");
        student.setsAge(30);


       // The .configure() will load the hibernate.cfg.xml, where we have the details about our database.
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(com.exosolve.Student.class)
                .configure().buildSessionFactory();

        Session session = sessionFactory
                .openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(student);

        transaction.commit();
        sessionFactory.close(); // if u don't want to close manually use try-block with resource
        session.close();

        System.out.println("Student saved successfully!");
        System.out.println(student);
    }
}