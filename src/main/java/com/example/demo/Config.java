package com.example.demo;

import com.example.demo.core.dao.BookDao;
import com.example.demo.core.dao.BookDaoImpl;
import com.example.demo.core.service.BookService;
import com.example.demo.core.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.demo")
public class Config {

    @Bean
    public BookDao getBookDao(){ return new BookDaoImpl(); }

    @Bean
    public BookService getBookService(){return new BookServiceImpl();}

}
