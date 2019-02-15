package com.example.demo.core.dto;

import javax.persistence.*;


@Entity
@Table(name = "book")
public class dto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String author;

    public dto() {
    }

    public dto(String name, String author) {
        //this.id = UUID.randomUUID().toString();
        this.name = name;
        this.author = author;
    }

    public int getId() {
        return this.id;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
