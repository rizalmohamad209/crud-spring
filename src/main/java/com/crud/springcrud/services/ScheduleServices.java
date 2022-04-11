package com.crud.springcrud.services;

import com.crud.springcrud.entites.Schedule;
import com.crud.springcrud.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface ScheduleServices {

    Schedule Post(Schedule params) ;
    List<Schedule> Get(String filmName);
    List<Schedule>Get();
    Schedule Put(Integer id, Schedule params) throws ResourceNotFoundException;
    String Delete(Integer id);
}
