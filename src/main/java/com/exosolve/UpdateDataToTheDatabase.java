package com.exosolve;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateDataToTheDatabase {

    public static void main(String[] args) {
        System.out.println("Running UpdateDataToTheDatabase...");

        // Create the object which you want to update...
        Student updatedStudent = new Student();
        updatedStudent.setsName("Yogesh");
        updatedStudent.setsAge(25); // Currently age  is 25, updating it to  24
        updatedStudent.setRollNo(3);

        try (SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Student.class).configure().buildSessionFactory()) {
            Session session = sessionFactory.openSession();


            Student studentToBeDeleted = session.get(Student.class, 6);
            Transaction transaction = session.beginTransaction();
            // Updating the data to the database of student entity, we can use merge to update or create the record(if its not already there)
            session.merge(updatedStudent);
            // Deleting the data from the database of student entity
            session.remove(studentToBeDeleted);
            System.out.println("Student " + studentToBeDeleted.getsName() + " has been deleted.");

            transaction.commit();

            System.out.println("Updated student successfully.");
            // Getting the updated student object with its primary key
            System.out.println(session.get(Student.class, 3));

            session.close();
        }
    }
}
