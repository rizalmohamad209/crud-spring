package com.crud.springcrud.entites;


import java.util.Date;

//
//@Entity
//@Table(name = "transaksi")
public class Transaksi {
    private Integer id_transaksi;
    private Integer qty;
    private String user;
    private String film;
    private String Studio;
    private Date date;

    private Integer seats;

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    private Date jam;

    public Date getJam() {
        return jam;
    }

    public void setJam(Date jam) {
        this.jam = jam;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(Integer id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getStudio() {
        return Studio;
    }

    public void setStudio(String studio) {
        Studio = studio;
    }

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id_transaksi;
//
//    @Column(nullable = false, length = 11)
//    private Integer qty;
//
//    @Column(nullable = false, length = 11)
//    private Integer user_id;
//
//    @Column(nullable = false, length = 11)
//    private Integer film_id;
//
//    @Column(nullable = false, length = 11)
//    private Integer studio_id;
//
//    public Integer getId_transaksi() {
//        return id_transaksi;
//    }
//
//    public void setId_transaksi(Integer id_transaksi) {
//        this.id_transaksi = id_transaksi;
//    }
//
//    public Integer getQty() {
//        return qty;
//    }
//
//    public void setQty(Integer qty) {
//        this.qty = qty;
//    }
//
//    public Integer getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(Integer user_id) {
//        this.user_id = user_id;
//    }
//
//    public Integer getFilm_id() {
//        return film_id;
//    }
//
//    public void setFilm_id(Integer film_id) {
//        this.film_id = film_id;
//    }
//
//    public Integer getStudio_id() {
//        return studio_id;
//    }
//
//    public void setStudio_id(Integer studio_id) {
//        this.studio_id = studio_id;
//    }
}
