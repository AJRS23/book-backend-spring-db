package com.example.demo.core.dao;

import com.example.demo.core.dto.dtoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IUserMongoDAO extends MongoRepository<dtoUser,String> {

    dtoUser findByName(String name);
}
