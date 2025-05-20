package com.exosolve;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDataFromDatabase {


    public static void main(String[] args) {
        System.out.println("FetchDataFromDatabase");


        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(com.exosolve.Student.class)
                .configure()
                .buildSessionFactory();


        Session session = sessionFactory.openSession();

        Student studentWithGivenPK = session.get(Student.class, 3);

        session.close();
        sessionFactory.close();

        System.out.println("FetchDataFromDatabase: studentWithGivenPK = " + studentWithGivenPK);
        System.out.println("FetchDataFromDatabase" + studentWithGivenPK.getClass());
    }
}
