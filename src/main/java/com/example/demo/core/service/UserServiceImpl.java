package com.example.demo.core.service;

import com.example.demo.core.dao.IUserMongoDAO;
import com.example.demo.core.dto.dtoUser;
import com.example.demo.model.User;
import com.example.demo.support.exceptions.BookAlreadyExistsException;
import com.example.demo.support.exceptions.BookNameFieldRequiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserMongoDAO iUserMongoDAO;

    @Transactional
    @Override
    public User createUser(String name) throws Exception {
        if (name == null) {
            throw new BookNameFieldRequiredException();
        }
        dtoUser user = this.iUserMongoDAO.findByName(name);
        if (user != null) {
            throw new BookAlreadyExistsException();
        }
        user = new dtoUser();
        user.setName(name);
        user = this.iUserMongoDAO.save(user);
        User newUser = new User(user);
        return newUser;
    }

    @Transactional
    @Override
    public User updateUser(String id, String name) throws Exception {
        return null;
    }

    @Transactional
    @Override
    public List<User> getUsers() {

        return this.iUserMongoDAO.findAll().stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public User getUser(String id) throws Exception {
        return null;
    }

    @Transactional
    @Override
    public void deleteUser(String id) throws Exception {

    }
}
