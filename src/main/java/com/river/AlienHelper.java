package com.river;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AlienHelper {

    /*
    By default, hibernate fetch type is LAZY
     */
    public static void processEagerAndLazy() {
        Pen pen = new Pen();
        pen.setId(1);
        pen.setName("Anker");

        Pen pen2 = new Pen();
        pen2.setId(2);
        pen2.setName("Xiaomi");

        Alien alien = new Alien();
        alien.setId(1);
        alien.setName("Ekko");
        alien.setPens(List.of(pen, pen2));

        pen.setAlien(alien);
        pen2.setAlien(alien);

        SessionFactory sessionFactory =
                new Configuration()
                        .addAnnotatedClass(Alien.class)
                        .addAnnotatedClass(Chair.class)
                        .addAnnotatedClass(Book.class)
                        .addAnnotatedClass(Pen.class)
                        .addAnnotatedClass(Friend.class)
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(pen);
        session.persist(pen2);
        session.persist(alien);

        transaction.commit();

//        Alien newAlien = session.get(Alien.class, 1);
//        System.out.println(newAlien);

        session.close();

        Session session2 = sessionFactory.openSession();
        Alien newAlien2 = session2.get(Alien.class, 1);
//        System.out.println(newAlien2);
        session2.close();

        sessionFactory.close();
    }

    public static void processOneToOne() {
        Chair chair = new Chair();
        chair.setId(1);
        chair.setName("Chair");

        Alien alien = new Alien();
        alien.setId(1);
        alien.setName("Garen");
        alien.setChair(chair);

        SessionFactory sessionFactory =
                new Configuration()
                        .addAnnotatedClass(Alien.class)
                        .addAnnotatedClass(Chair.class)
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(chair);
        session.persist(alien);

        transaction.commit();

        Alien newAlien = session.get(Alien.class, 1);
        System.out.println(newAlien);

        session.close();
        sessionFactory.close();
    }

    public static void processOneToMany() {
        Book book = new Book();
        book.setBookId(1);
        book.setName("Java");
        Book book2 = new Book();
        book2.setBookId(2);
        book2.setName("Python");

        Alien alien = new Alien();
        alien.setId(1);
        alien.setName("Garen");
        List<Book> books = List.of(book, book2);
        alien.setBooks(books);

        book.setAlien(alien);
        book2.setAlien(alien);

        SessionFactory sessionFactory =
                new Configuration()
                        .addAnnotatedClass(Alien.class)
                        .addAnnotatedClass(Chair.class)
                        .addAnnotatedClass(Book.class)
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(book);
        session.persist(book2);
        session.persist(alien);

        transaction.commit();

        Alien newAlien = session.get(Alien.class, 1);
        System.out.println(newAlien);

        session.close();
        sessionFactory.close();
    }

    public static void processManyToMany() {
        Friend friend = new Friend();
        friend.setId(1);
        friend.setName("Akali");

        Friend friend2 = new Friend();
        friend2.setId(2);
        friend2.setName("Lux");

        Friend friend3 = new Friend();
        friend3.setId(3);
        friend3.setName("Zed");

        Alien alien = new Alien();
        alien.setId(1);
        alien.setName("Garen");
        List<Friend> friends = List.of(friend, friend2);
        alien.setFriends(friends);

        Alien alien2 = new Alien();
        alien2.setId(2);
        alien2.setName("Yasuo");
        List<Friend> friends2 = List.of(friend, friend2, friend3);
        alien2.setFriends(friends2);

        friend.setAliens(List.of(alien, alien2));
        friend2.setAliens(List.of(alien, alien2));
        friend3.setAliens(List.of(alien2));

        SessionFactory sessionFactory =
                new Configuration()
                        .addAnnotatedClass(Alien.class)
                        .addAnnotatedClass(Chair.class)
                        .addAnnotatedClass(Book.class)
                        .addAnnotatedClass(Friend.class)
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(friend);
        session.persist(friend2);
        session.persist(friend3);
        session.persist(alien);
        session.persist(alien2);

        transaction.commit();

        Alien newAlien1 = session.get(Alien.class, 1);
        Alien newAlien2 = session.get(Alien.class, 2);
        System.out.println(newAlien1);
        System.out.println(newAlien2);

        session.close();
        sessionFactory.close();
    }

    public static void processGet() {
        SessionFactory sessionFactory =
                new Configuration()
                        .addAnnotatedClass(Alien.class)
                        .addAnnotatedClass(Chair.class)
                        .addAnnotatedClass(Book.class)
                        .configure()
                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        Alien newAlien = session.get(Alien.class, 1);
        System.out.println(newAlien);

        session.close();
        sessionFactory.close();
    }
}
