package com.crud.springcrud.controller;

import com.crud.springcrud.entites.Film;
import com.crud.springcrud.exception.ResourceNotFoundException;
import com.crud.springcrud.services.FilmServices;
import com.crud.springcrud.util.StatusFIlm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class FilmController {

    @Autowired
    private final FilmServices filmServices;


    public FilmController(FilmServices filmServices) {
        this.filmServices = filmServices;
    }

    @PostMapping("/film")
    public Film Post(@RequestBody Film params){
        return filmServices.Post(params);
    };

    @GetMapping("/film")
    public List<Film> Get(@RequestParam(value = "status",required = false)StatusFIlm status){
        if(status == null){
            return filmServices.Get();
        }else{
            return filmServices.GetStatus(status);
        }
//        return  filmServices.Get();
    }

//    @GetMapping("/filmsearch")
//    public List<Film> Get(@RequestParam(value = "status")StatusFIlm status){
//
//        return filmServices.GetStatus(status);};
    @GetMapping("/film/{id}")
    public Film Get(@PathVariable Integer id) throws ResourceNotFoundException {
        return filmServices.Get(id);
    };
    @PutMapping("/film/{id}")
    public Film Put(@PathVariable Integer id, @RequestBody Film params) throws ResourceNotFoundException{
        return filmServices.Put(params, id);
    };
    @DeleteMapping("/film/{id}")
    public String Delete(@PathVariable Integer id){
        return filmServices.Delete(id) ;
    }
}
