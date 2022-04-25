package com.crud.springcrud.controller;


import com.crud.springcrud.entites.Seats;
import com.crud.springcrud.services.SeatsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.expression.Sets;

import java.util.List;

@RestController
public class SeatsController {
    @Autowired
    private final SeatsServices seatsServices;


    public SeatsController(SeatsServices seatsServices) {
        this.seatsServices = seatsServices;
    }


    @PostMapping("/seats")
    public ResponseEntity<Seats> Post(@RequestBody Seats params){

        return new ResponseEntity<>(seatsServices.Post(params), HttpStatus.CREATED) ;
    }
    @GetMapping("/seats")
    public ResponseEntity<List<Seats>>  Get(){

        return new ResponseEntity<>(seatsServices.Get(), HttpStatus.OK);
    };

}
