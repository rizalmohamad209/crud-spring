package com.crud.springcrud.controller;

import com.crud.springcrud.entites.Schedule;
import com.crud.springcrud.exception.ResourceNotFoundException;
import com.crud.springcrud.services.ScheduleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ScheduleController {

    @Autowired
    private final ScheduleServices scheduleServices;

    public ScheduleController(ScheduleServices scheduleServices) {
        this.scheduleServices = scheduleServices;
    }

    @PostMapping("/schedule")
    public ResponseEntity<Schedule>  Post(@RequestBody Schedule params){
        return new ResponseEntity<>(scheduleServices.Post(params), HttpStatus.CREATED) ;
    }

    @PutMapping("/schedule/{id}")
    public ResponseEntity<Schedule> Put(@PathVariable Integer id,@RequestBody Schedule params)throws ResourceNotFoundException{
        return new ResponseEntity<>(scheduleServices.Put(id,params), HttpStatus.ACCEPTED) ;
    }



    @GetMapping("/schedule")
    public ResponseEntity<List<Schedule>> Get(@RequestParam(value = "q",required = false) String filmName){
        if(filmName.isEmpty()){
            return new ResponseEntity<>(scheduleServices.Get(), HttpStatus.OK) ;
        }else{

            return new ResponseEntity<>(scheduleServices.Get(filmName), HttpStatus.OK);
        }

    }

    @DeleteMapping("/schedule/{id}")
    public ResponseEntity<String>  Delete(@PathVariable Integer id){
        return new ResponseEntity<>(scheduleServices.Delete(id),HttpStatus.ACCEPTED) ;
    }


}
