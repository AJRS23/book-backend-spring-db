package com.example.demo;

import com.example.demo.core.service.BookService;
import com.example.demo.core.service.BookServiceImpl;
import com.example.demo.core.service.UserService;
import com.example.demo.core.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.demo")
public class Config {
}
