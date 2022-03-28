package com.crud.springcrud.controller;

import com.crud.springcrud.entites.Users;
import com.crud.springcrud.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/users")
    public Users Post(@RequestBody Users params){
        return userServices.Post(params);
    }

    @GetMapping("/users")
    public Iterable<Users> Get(){
        return userServices.Get();
    }

    @GetMapping("/users/{id}")
    public Users Get(@PathVariable Integer id){
        return userServices.Get(id);
    }

    @PutMapping("/users/{id}")
    public Users Update(@PathVariable Integer id, @RequestBody Users params){
        return userServices.Update(params, id);
    }

    @DeleteMapping("/users/{id}")
    public String Delete(@PathVariable Integer id){
        return userServices.Delete(id);
    }

}
