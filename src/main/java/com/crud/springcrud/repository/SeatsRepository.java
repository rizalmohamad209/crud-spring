package com.crud.springcrud.repository;

import com.crud.springcrud.entites.Seats;
import com.crud.springcrud.entites.SeatsPkId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatsRepository extends JpaRepository<Seats, SeatsPkId> {
}
