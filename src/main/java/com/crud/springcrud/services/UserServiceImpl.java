package com.crud.springcrud.services;

import com.crud.springcrud.entites.Users;
import com.crud.springcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Service
public class UserServiceImpl implements UserServices{

   @Autowired
   private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public Users Post(Users params) {
        repo.save(params);
        return params;
    }

    @Override
    public Iterable<Users> Get() {
       return repo.findAll();
    }

    @Override
    public Users Get(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public Users Update(Users params, Integer id) {
       Optional<Users> userById = repo.findById(id);
       Users user = userById.get();
       user.setFirstName(params.getFirstName());
       user.setLastName(params.getLastName());
       user.setPassword(params.getPassword());
       user.setUsername(params.getUsername());
       user.setEmail(params.getEmail());

       return repo.save(user);
    }

    @Override
    public String Delete(Integer id) {
        repo.deleteById(id);
        return "User("+id+")"+"Has Been Deleted!";



    }
}
