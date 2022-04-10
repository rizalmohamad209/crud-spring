package com.crud.springcrud.controller;

import com.crud.springcrud.entites.Studio;
import com.crud.springcrud.exception.ResourceNotFoundException;
import com.crud.springcrud.services.StudioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudioController {

    @Autowired
    private final StudioServices studioServices;

    public StudioController(StudioServices studioServices) {
        this.studioServices = studioServices;
    }

    @PostMapping("/studio")
    public Studio Post(@RequestBody Studio params){
        return studioServices.Post(params);
    }

    @GetMapping("/studio")
    public Iterable<Studio> Get(){
        return studioServices.Get();
    }

    @GetMapping("/studio/{id}")
    public Studio Get(@PathVariable Integer id) throws ResourceNotFoundException{
        return studioServices.Get(id);
    }

    @PutMapping("/studio/{id}")
    public Studio Put(@PathVariable Integer id,@RequestBody Studio params)throws ResourceNotFoundException{
        return studioServices.Put(params, id);
    }

    @DeleteMapping("/studio/{id}")
    public String Delete(@PathVariable Integer id){
        return studioServices.Delete(id);
    }



}
