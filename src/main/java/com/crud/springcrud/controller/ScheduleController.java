package com.crud.springcrud.controller;

import com.crud.springcrud.entites.Schedule;
import com.crud.springcrud.exception.ResourceNotFoundException;
import com.crud.springcrud.services.ScheduleServices;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Schedule Post(@RequestBody Schedule params){
        return scheduleServices.Post(params);
    }

    @PutMapping("/schedule/{id}")
    public Schedule Put(@PathVariable Integer id,@RequestBody Schedule params)throws ResourceNotFoundException{
        return scheduleServices.Put(id,params);
    }



    @GetMapping("/schedule")
    public List<Schedule> Get(@RequestParam(value = "q",required = false) String filmName){
        if(filmName.isEmpty()){
            return scheduleServices.Get();
        }else{
            System.out.println(filmName);
            return scheduleServices.Get(filmName);
        }

    }

    @DeleteMapping("/schedule/{id}")
    public String Delete(@PathVariable Integer id){
        return scheduleServices.Delete(id);
    }


}
