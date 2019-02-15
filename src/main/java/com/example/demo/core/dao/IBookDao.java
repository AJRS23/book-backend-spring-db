package com.example.demo.core.dao;

import com.example.demo.core.dto.dto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookDao extends JpaRepository<dto,Integer> {
    dto findByNameAndAuthor(String name,String author);
}
