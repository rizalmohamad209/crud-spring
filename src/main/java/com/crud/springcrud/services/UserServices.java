package com.crud.springcrud.services;

import com.crud.springcrud.entites.Users;
import org.springframework.stereotype.Component;



@Component
public interface UserServices {

    Users Post(Users params);
    Iterable<Users> Get();
    Users Get(Integer id);
    Users Update(Users params, Integer id);
    String Delete(Integer id);


}
