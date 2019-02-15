package com.example.demo.core.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    public User createUser(String name) throws Exception;

    public User updateUser(String id, String name) throws Exception;

    public List<User> getUsers();

    public User getUser(String id) throws Exception;

    public void deleteUser(String id) throws Exception;
}
