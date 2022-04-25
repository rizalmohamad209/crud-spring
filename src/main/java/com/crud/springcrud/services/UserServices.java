package com.crud.springcrud.services;

import com.crud.springcrud.entites.Users;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface UserServices {

    Users Post(Users params);
    List<Users> Get();
    Users Get(Integer id);
    Users Update(Users params, Integer id);
    String Delete(Integer id);


}
