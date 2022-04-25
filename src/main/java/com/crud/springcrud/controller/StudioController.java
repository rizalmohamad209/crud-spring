package com.crud.springcrud.controller;

import com.crud.springcrud.entites.Studio;
import com.crud.springcrud.exception.ResourceNotFoundException;
import com.crud.springcrud.services.StudioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudioController {

    @Autowired
    private final StudioServices studioServices;

    public StudioController(StudioServices studioServices) {
        this.studioServices = studioServices;
    }

    @PostMapping("/studio")
    public ResponseEntity<Studio> Post(@RequestBody Studio params){

        return new ResponseEntity<>(studioServices.Post(params), HttpStatus.CREATED) ;
    }

    @GetMapping("/studio")
    public ResponseEntity<List<Studio>> Get(){

        return new ResponseEntity<>(studioServices.Get(), HttpStatus.OK) ;
    }

    @GetMapping("/studio/{id}")
    public ResponseEntity<Studio> Get(@PathVariable Integer id) throws ResourceNotFoundException{
        return new ResponseEntity<>(studioServices.Get(id), HttpStatus.OK) ;
    }

    @PutMapping("/studio/{id}")
    public ResponseEntity<Studio>  Put(@PathVariable Integer id,@RequestBody Studio params)throws ResourceNotFoundException{
        return new ResponseEntity<>(studioServices.Put(params, id), HttpStatus.ACCEPTED) ;
    }

    @DeleteMapping("/studio/{id}")
    public ResponseEntity<String> Delete(@PathVariable Integer id){

        return new ResponseEntity<>(studioServices.Delete(id), HttpStatus.ACCEPTED) ;
    }



}
