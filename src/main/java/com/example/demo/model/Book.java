package com.example.demo.model;
import com.example.demo.core.dto.dto;

public class Book {

    private int id;
    private String name;
    private String author;

    public Book() {
    }

    public Book(dto dto){
        this.id = dto.getId();
        this.name = dto.getName();
        this.author = dto.getAuthor();
    }

    public Book(String name, String author) {
        //this.id = UUID.randomUUID().toString();
        this.name = name;
        this.author = author;
    }

    public String getId() {
        return Integer.toString(id);
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
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
