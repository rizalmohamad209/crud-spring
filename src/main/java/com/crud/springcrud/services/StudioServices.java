package com.crud.springcrud.services;



import com.crud.springcrud.entites.Studio;
import com.crud.springcrud.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public interface StudioServices {
    Studio Post(Studio params);
    Iterable<Studio> Get();
    Studio Get(Integer id) throws ResourceNotFoundException;
    Studio Put(Studio params, Integer id) throws ResourceNotFoundException;
    String Delete(Integer id) ;
}
