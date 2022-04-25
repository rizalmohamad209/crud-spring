package com.crud.springcrud.services;

import com.crud.springcrud.entites.Seats;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SeatsServices {
    Seats Post(Seats params);
    List<Seats> Get();
    Seats Get(Integer id);
//    Seats Put(Seats params, Integer id);
//    String Delete(Integer id);

}
