package com.river;

import jakarta.persistence.*;

@Entity
@Table(name="book")
public class Book {
    @Id
    private int bookId;

    private String name;

    @ManyToOne
    private Alien alien;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Alien getAlien() {
        return alien;
    }

    public void setAlien(Alien alien) {
        this.alien = alien;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                '}';
    }
}
