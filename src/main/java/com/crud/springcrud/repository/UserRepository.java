package com.crud.springcrud.repository;

import com.crud.springcrud.entites.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer> {
}
