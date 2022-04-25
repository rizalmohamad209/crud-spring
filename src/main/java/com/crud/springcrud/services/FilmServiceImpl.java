package com.crud.springcrud.services;

import com.crud.springcrud.entites.Film;
import com.crud.springcrud.exception.ResourceNotFoundException;
import com.crud.springcrud.repository.FilmRepository;
import com.crud.springcrud.util.StatusFIlm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;
import java.util.Set;

@Service
public class FilmServiceImpl implements FilmServices{

    @Autowired
    private final FilmRepository repo;





    public FilmServiceImpl(FilmRepository repo) {
        this.repo = repo;
    }

    @Override
    public Film Post(Film params) {

         repo.save(params);
        return params;
    }

    @Override
    public List<Film> Get() {
        return repo.findAll();
    }

    @Override
    public Film Get(Integer id) throws ResourceNotFoundException {
        return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Couldn't find a film with id: "+ id));
    }

    @Override
    public Film Put(Film params, Integer id) throws ResourceNotFoundException{
        Film filmOptional = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Couldn't find a film with id: "+ id));


        filmOptional.setNama_film(params.getNama_film());
        filmOptional.setDurasi(params.getDurasi());
        filmOptional.setStatus(params.getStatus());

        return repo.save(filmOptional);
    }

    @Override
    public String Delete(Integer id) {
        repo.deleteById(id);
        return "Film "+id+" sukses dihapusv";
    }

    @Override
    public List<Film> GetStatus(StatusFIlm status) {
        return repo.getFilmByStatus(status);
    }


}
