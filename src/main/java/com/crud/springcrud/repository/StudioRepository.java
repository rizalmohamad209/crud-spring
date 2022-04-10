package com.crud.springcrud.repository;

import com.crud.springcrud.entites.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudioRepository extends JpaRepository<Studio, Integer> {

}
