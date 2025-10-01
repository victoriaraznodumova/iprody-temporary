package io;

import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    private String name;
//    private transient String description;
    static final long serialVersionUID = -5062650704919150858L;
    private Book book;

    public Person(int id, String name, Book book) {
        this.id = id;
        this.name = name;
        this.book = book;
    }

//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", book=" + book.getTitle() +
                '}';
    }
}
