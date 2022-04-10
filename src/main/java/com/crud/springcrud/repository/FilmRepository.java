package com.crud.springcrud.repository;

import com.crud.springcrud.entites.Film;
import com.crud.springcrud.util.StatusFIlm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface FilmRepository  extends JpaRepository<Film,Integer> {
 @Query("SELECT f FROM Film f WHERE f.status = :status")
 List<Film> getFilmByStatus(StatusFIlm status);

}
