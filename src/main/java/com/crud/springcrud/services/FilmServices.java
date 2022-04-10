package com.crud.springcrud.services;


import com.crud.springcrud.entites.Film;
import com.crud.springcrud.exception.ResourceNotFoundException;
import com.crud.springcrud.util.StatusFIlm;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Component
public interface FilmServices {
    Film Post(Film params);
    List<Film> Get();
    Film Get(Integer id) throws ResourceNotFoundException;
    Film Put(Film params, Integer id) throws ResourceNotFoundException;
    String Delete(Integer id) ;
    List<Film>GetStatus(StatusFIlm status);


}
