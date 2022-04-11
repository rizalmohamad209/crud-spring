package com.crud.springcrud.services;

import com.crud.springcrud.entites.Seats;
import org.springframework.stereotype.Component;

@Component
public interface SeatsServices {
    Seats Post(Seats params);
    Iterable<Seats> Get();
    Seats Get(Integer id);
//    Seats Put(Seats params, Integer id);
//    String Delete(Integer id);

}
