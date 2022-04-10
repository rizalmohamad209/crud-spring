package com.crud.springcrud.entites;

import com.crud.springcrud.util.StatusSeats;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;


@Entity
@Table(name = "seats")
@IdClass(SeatsPkId.class)
public class Seats implements Persistable<SeatsPkId> {
    @Transient
    private boolean isNew = true;

    @Id
    @ManyToOne
    @JoinColumn(name = "studio_id", referencedColumnName = "id_studio")
    private Studio studio;
    @Id
    private Integer seats_number;



    @Enumerated(EnumType.STRING)
    private StatusSeats status_seats;


    public Studio getStudio() {

        return studio;
    }

    public void setStudio(Studio studio) {

        this.studio = studio;
    }

    public Integer getSeats_number() {
        return seats_number;
    }

    public void setSeats_number(Integer seats_number) {
        this.seats_number = seats_number;
    }

    public StatusSeats getStatus_seats() {
        return status_seats;
    }

    public void setStatus_seats(StatusSeats status_seats) {
        this.status_seats = status_seats;
    }

    @Override
    public SeatsPkId getId() {
        return new SeatsPkId(studio, seats_number);
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
