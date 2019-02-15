package com.example.demo.model;

import com.example.demo.core.dto.dtoUser;

public class User {
    private String id;
    private String name;

    public User() {
    }

    public User(dtoUser dto){
        this.id = dto.getId();
        this.name = dto.getName();
    }

    public User(String name) {
        //this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
