package com.crud.springcrud.controller;


import com.crud.springcrud.entites.Seats;
import com.crud.springcrud.services.SeatsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.expression.Sets;

@RestController
public class SeatsController {
    @Autowired
    private final SeatsServices seatsServices;


    public SeatsController(SeatsServices seatsServices) {
        this.seatsServices = seatsServices;
    }


    @PostMapping("/seats")
    public Seats Post(@RequestBody Seats params){

        return seatsServices.Post(params);
    }
    @GetMapping("/seats")
    public Iterable<Seats> Get(){
        return seatsServices.Get();
    };

}
