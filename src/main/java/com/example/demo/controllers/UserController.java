package com.example.demo.controllers;

import com.example.demo.core.service.UserService;
import com.example.demo.model.User;
import com.example.demo.support.exceptions.BookAlreadyExistsException;
import com.example.demo.support.exceptions.BookNameFieldRequiredException;
import com.example.demo.support.exceptions.BookNotFoundException;
import com.example.demo.support.responses.CustomError;
import com.example.demo.support.responses.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v2/user")
@CrossOrigin
public class UserController {

    UserService userService;

    @Autowired
    public void setService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity getUsers(){
        List<User> users = userService.getUsers();
        return new ResponseEntity(new CustomResponse(users), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity createUser(@RequestBody User user){
        User newUser = null;
        try {
            newUser = userService.createUser(user.getName());
            return new ResponseEntity(new CustomResponse(newUser), HttpStatus.OK);

        } catch (BookAlreadyExistsException e){
            return new ResponseEntity(new CustomError(e.getMessage()),HttpStatus.BAD_REQUEST);
        } catch (BookNameFieldRequiredException e){
            return new ResponseEntity(new CustomError(e.getMessage()),HttpStatus.CONFLICT);
        } catch (Exception ex) {
            return new ResponseEntity(new CustomError(ex.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable String id, @RequestBody User user) throws Exception {
        try{
            User returnUser = userService.updateUser(id,user.getName());
            return new ResponseEntity(new CustomResponse(returnUser),HttpStatus.OK);
        }catch (BookAlreadyExistsException e){
            return new ResponseEntity(new CustomError(e.getMessage()),HttpStatus.BAD_REQUEST);
        } catch (BookNameFieldRequiredException e){
            return new ResponseEntity(new CustomError(e.getMessage()),HttpStatus.CONFLICT);
        } catch(BookNotFoundException e){
            return new ResponseEntity(new CustomError(e.getMessage()),HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable String id) throws Exception {
        try{
            User returnUser = userService.getUser(id);
            return new ResponseEntity(new CustomResponse(returnUser),HttpStatus.OK);
        } catch (BookNotFoundException e){
            return new ResponseEntity(new CustomError(e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable String id) throws Exception {
        try{
            userService.deleteUser(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (BookNotFoundException e){
            return new ResponseEntity(new CustomError(e.getMessage()), HttpStatus.NOT_FOUND);
        }


    }
}
