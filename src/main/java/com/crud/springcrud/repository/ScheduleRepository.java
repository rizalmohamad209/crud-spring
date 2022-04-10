package com.crud.springcrud.repository;

import com.crud.springcrud.entites.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    @Query("SELECT s FROM Schedule s INNER JOIN s.films f WHERE f.nama_film = :filmName")
    List<Schedule> findScheduleFilm(String filmName);


}
