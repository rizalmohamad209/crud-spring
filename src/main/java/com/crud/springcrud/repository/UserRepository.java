package com.crud.springcrud.repository;

import com.crud.springcrud.entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
