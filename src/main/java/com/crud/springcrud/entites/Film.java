package com.crud.springcrud.entites;

import com.crud.springcrud.util.StatusFIlm;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity


@Table(name = "film")
public class Film implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_film;

    @Column(nullable = false, length = 100)
    private String nama_film;

    @Column(nullable = false, length = 10)
    private Integer durasi;

    @Enumerated(EnumType.STRING)
    private StatusFIlm status;

    @OneToMany(mappedBy = "film",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Schedule> schedule;


    public Integer getId_film() {
        return id_film;
    }

    public void setId_film(Integer id_film) {
        this.id_film = id_film;
    }

    public String getNama_film() {
        return nama_film;
    }

    public void setNama_film(String nama_film) {
        this.nama_film = nama_film;
    }

    public Integer getDurasi() {
        return durasi;
    }

    public void setDurasi(Integer durasi) {
        this.durasi = durasi;
    }

    public StatusFIlm getStatus() {
        return status;
    }

    public void setStatus(StatusFIlm status) {
        this.status = status;
    }
}
