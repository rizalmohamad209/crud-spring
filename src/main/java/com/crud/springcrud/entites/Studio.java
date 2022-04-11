package com.crud.springcrud.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Set;

@Entity

@Table(name = "studio")
public class Studio  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_studio;

    @Column(nullable = false, length = 10)
    private String nama_studio;



//    @OneToMany(mappedBy = "studios", cascade = CascadeType.ALL,orphanRemoval = true)
//    private Set<SeatsPkId> seatsPkId;

    @OneToMany(mappedBy = "studio",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Schedule> schedule;

//
    @OneToMany( cascade = CascadeType.ALL,mappedBy = "studio",orphanRemoval = true)
    private Set<Seats> seats;




    public Integer getId_studio() {
        return id_studio;
    }

    public void setId_studio(Integer id_studio) {
        this.id_studio = id_studio;
    }

    public String getNama_studio() {
        return nama_studio;
    }

    public void setNama_studio(String nama_studio) {
        this.nama_studio = nama_studio;
    }


}
