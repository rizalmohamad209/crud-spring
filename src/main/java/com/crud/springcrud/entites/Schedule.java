package com.crud.springcrud.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;



@Entity

@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_schedule;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date tanggal_tayang;

    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss")
    private Date jam_mulai;

    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss")
    private Date jam_selesai;

    @Column(nullable = false)
    private Integer harga_tiket;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "films_id")
    private Film films;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="studio_id")
    private Studio studio;

    public Integer getId_schedule() {
        return id_schedule;
    }

    public void setId_schedule(Integer id_schedule) {
        this.id_schedule = id_schedule;
    }

    public Date getTanggal_tayang() {
        return tanggal_tayang;
    }

    public void setTanggal_tayang(Date tanggal_tayang) {
        this.tanggal_tayang = tanggal_tayang;
    }

    public Date getJam_mulai() {
        return jam_mulai;
    }

    public void setJam_mulai(Date jam_mulai) {
        this.jam_mulai = jam_mulai;
    }

    public Date getJam_selesai() {
        return jam_selesai;
    }

    public void setJam_selesai(Date jam_selesai) {
        this.jam_selesai = jam_selesai;
    }

    public Integer getHarga_tiket() {
        return harga_tiket;
    }

    public void setHarga_tiket(Integer harga_tiket) {
        this.harga_tiket = harga_tiket;
    }

    public Film getFilms() {
        return films;
    }

    public void setFilms(Film films) {
        this.films = films;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}
