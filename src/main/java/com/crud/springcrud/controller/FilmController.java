package com.crud.springcrud.controller;

import com.crud.springcrud.entites.Film;
import com.crud.springcrud.exception.ResourceNotFoundException;
import com.crud.springcrud.services.FilmServices;
import com.crud.springcrud.util.StatusFIlm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {

    @Autowired
    private final FilmServices filmServices;


    public FilmController(FilmServices filmServices) {
        this.filmServices = filmServices;
    }

    @PostMapping("/film")
    public ResponseEntity<Film>  Post(@RequestBody Film params){
           return new ResponseEntity<>(filmServices.Post(params), HttpStatus.CREATED);
    };

    @GetMapping("/film")
    public ResponseEntity<List<Film>>  Get(@RequestParam(value = "status",required = false)StatusFIlm status){
        if(status == null){
            return new ResponseEntity<>(filmServices.Get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(filmServices.GetStatus(status), HttpStatus.OK);
        }
    }

    @GetMapping("/film/{id}")
    public ResponseEntity<Film>  Get(@PathVariable Integer id) throws ResourceNotFoundException {
        return new ResponseEntity<>(filmServices.Get(id), HttpStatus.OK) ;
    };
    @PutMapping("/film/{id}")
    public ResponseEntity<Film>  Put(@PathVariable Integer id, @RequestBody Film params) throws ResourceNotFoundException{
        return new ResponseEntity<>(filmServices.Put(params, id), HttpStatus.ACCEPTED) ;
    };
    @DeleteMapping("/film/{id}")
    public ResponseEntity<String>  Delete(@PathVariable Integer id){

        return new ResponseEntity<>(filmServices.Delete(id), HttpStatus.ACCEPTED) ;
    }
}
