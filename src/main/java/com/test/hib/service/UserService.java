package com.test.hib.service;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserService {
    public static void CreateuserTable(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        t.commit();
        System.out.println("successfully created user table");
        factory.close();
        session.close();
    }

    // Method to insert User into the database
    public static void CreateUser() {
        // TODO Auto-generated method stub
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        User uone = new User();
        uone.setEmail("haseeb@gmail.com");
        uone.setFullname("Moh Haseeb");
        uone.setPassword("has123");
        uone.setSalary(2000.69);
        uone.setAge(20);
        uone.setCity("NYC");
        User uTwo = new User();
        uTwo.setEmail("James@gmail.com");
        uTwo.setFullname("James Santana");
        uTwo.setPassword("James123");
        uTwo.setSalary(2060.69);
        uTwo.setAge(25);
        uTwo.setCity("Dallas");
        User uThree = new User();
        uThree.setEmail("Shahparan@gmail.com");
        uThree.setFullname("AH Shahparan");
        uThree.setPassword("Shahparan123");
        uThree.setSalary(3060.69);
        uThree.setAge(30);
        uThree.setCity("Chicago");
        /*========= We can pass value/data by using constructor =========*/
        User ufour = new User( "Christ", "christ@gmail.com", "147852", 35,
                35000.3,"NJ");
        User ufive = new User("Sid", "Sid", "s258", 29, 4000.36, "LA");
//Integer userid = null;
        session.persist(uone);
        session.persist(uTwo);
        session.persist(uThree);
        session.persist(ufour);
        session.persist(ufive);
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }
    public static void FindingUser(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        int USER_ID = 2;
        User u = session.load(User.class, USER_ID);
        System.out.println("Fullname: " + u.getFullname());
        System.out.println("Email: " + u.getEmail());
        System.out.println("password: " + u.getPassword());
//Close resources
        tx.commit();
        factory.close();
        session.close();
    }
    // Method to update user details
    public static void UpdatingUser() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User u = new User();
        u.setId(3);
        u.setEmail("mhaseeb@perscholas");
        u.setFullname("M haseeb");
        u.setPassword("123456");
        session.merge(u);
        session.getTransaction().commit();
        session.close();
        System.out.println("User updated successfully.");
    }
    public static void DeletingUser() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User u = new User();
        u.setId(3);
        session.remove(u);
        tx.commit();
        session.close();
        sessionFactory.close();

    }
}