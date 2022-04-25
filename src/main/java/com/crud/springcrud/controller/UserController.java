package com.crud.springcrud.controller;

import com.crud.springcrud.entites.Users;
import com.crud.springcrud.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/users")
    public ResponseEntity<Users> Post(@RequestBody Users params){
        return new ResponseEntity<>(userServices.Post(params), HttpStatus.CREATED) ;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> Get(){

        return new ResponseEntity<>(userServices.Get(), HttpStatus.OK) ;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> Get(@PathVariable Integer id){

        return new ResponseEntity<>(userServices.Get(id), HttpStatus.OK) ;
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Users> Update(@PathVariable Integer id, @RequestBody Users params){
        return new ResponseEntity<>(userServices.Update(params, id), HttpStatus.ACCEPTED) ;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> Delete(@PathVariable Integer id){

        return new ResponseEntity<>(userServices.Delete(id), HttpStatus.ACCEPTED) ;
    }

}
