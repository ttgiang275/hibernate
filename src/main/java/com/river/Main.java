package com.river;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        create();
//        get();
//        update();
//        delete();

//        createStudentClass();

//        createAlien();

//        AlienHelper.processGet();
//        AlienHelper.processOneToOne();
//        AlienHelper.processOneToMany();
//        AlienHelper.processManyToMany();
        AlienHelper.processEagerAndLazy();
    }

    private static void create() {
        Student s1 = new Student();
        s1.setSName("Garen");
        s1.setsAge(30);

//        Configuration configuration = new Configuration();
//        configuration.addAnnotatedClass(com.river.Student.class);
//        configuration.configure();
//
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
        SessionFactory sessionFactory =
                new Configuration()
                        .addAnnotatedClass(com.river.Student.class)
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(s1);

        transaction.commit();

        session.close();
        sessionFactory.close();


        System.out.println(s1);
    }

    private static void get() {
        Student student = null;

        SessionFactory sessionFactory =
                new Configuration()
                        .addAnnotatedClass(Student.class)
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        student = session.get(Student.class, 888);

        session.close();
        sessionFactory.close();

        System.out.println(Optional.ofNullable(student).map(Student::getSName).orElse("Student not found"));
    }

    private static void update() {
        Student student = new Student();
        student.setRollNo(1);
        student.setSName("Yasuo");
        student.setsAge(14);


        SessionFactory sessionFactory =
                new Configuration()
                        .addAnnotatedClass(com.river.Student.class)
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student newStudent =  session.merge(student);

        transaction.commit();

        session.close();
        sessionFactory.close();


        System.out.println(Optional.ofNullable(newStudent).map(Student::getSName).orElse("Student not found"));
    }
    
    private static void delete() {
        Student student = new Student();
        student.setRollNo(1);
//        student.setSName("Yasuo");
//        student.setsAge(14);


        SessionFactory sessionFactory =
                new Configuration()
                        .addAnnotatedClass(com.river.Student.class)
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.remove(student);

        transaction.commit();

        session.close();
        sessionFactory.close();


        System.out.println("----------Deleted!");
    }

    private static void createStudentClass() {
        StudentClass studentClass = new StudentClass();
//        studentClass.setId(1);
        studentClass.setClassName("Computer Science");
        studentClass.setClassSize(30);

        SessionFactory sessionFactory =
                new Configuration()
                        .addAnnotatedClass(com.river.StudentClass.class)
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(studentClass);

        transaction.commit();

        session.close();
        sessionFactory.close();


        System.out.println(studentClass);
    }

    private static void createAlien() {
        Laptop laptop = new Laptop();
        laptop.setLaptopId(1);
        laptop.setLaptopName("Macbook");
        laptop.setBrand("Apple");
        laptop.setPrice(1000);

        Alien alien = new Alien();
        alien.setId(1);
        alien.setName("Garen");
        alien.setLaptop(laptop);

        SessionFactory sessionFactory =
                new Configuration()
                        .addAnnotatedClass(Alien.class)
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(alien);

        transaction.commit();

        session.close();
        sessionFactory.close();


        System.out.println(alien);
    }

    private static void getAlien() {

        Laptop laptop = new Laptop();
        laptop.setLaptopId(1);
        laptop.setLaptopName("Macbook");
        laptop.setBrand("Apple");
        laptop.setPrice(1000);

        Alien alien = new Alien();
        alien.setId(1);
        alien.setName("Garen");
        alien.setLaptop(laptop);


        SessionFactory sessionFactory =
                new Configuration()
                        .addAnnotatedClass(Alien.class)
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(alien);

        transaction.commit();

        Alien newAlien = session.get(Alien.class, 1);
        System.out.println(newAlien);

        session.close();
        sessionFactory.close();
    }

}