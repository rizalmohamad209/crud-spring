package com.crud.springcrud.services;



import com.crud.springcrud.entites.Studio;
import com.crud.springcrud.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudioServices {
    Studio Post(Studio params);
    List<Studio> Get();
    Studio Get(Integer id) throws ResourceNotFoundException;
    Studio Put(Studio params, Integer id) throws ResourceNotFoundException;
    String Delete(Integer id) ;
}
