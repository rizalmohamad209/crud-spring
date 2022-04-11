package com.crud.springcrud.entites;

import com.crud.springcrud.util.StatusSeats;
import lombok.*;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;


@Entity

@Getter
@Setter
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

    @Override
    public SeatsPkId getId() {
        return new SeatsPkId(studio, seats_number);
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
