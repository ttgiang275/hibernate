package com.river;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "alien")
public class Alien {
    @Id
    private int id;

    private String name;

    private Laptop laptop;

    @OneToOne
    private Chair chair;

    @OneToMany(mappedBy = "alien")
    private List<Book> books;

    @ManyToMany()
    private List<Friend> friends;

    @OneToMany(mappedBy = "alien", fetch = FetchType.EAGER)
    private List<Pen> pens;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public List<Pen> getPens() {
        return pens;
    }

    public void setPens(List<Pen> pens) {
        this.pens = pens;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", laptop=" + laptop +
                ", chair=" + chair +
                ", books=" + books +
                ", friends=" + friends +
                ", pens=" + pens +
                '}';
    }
}
