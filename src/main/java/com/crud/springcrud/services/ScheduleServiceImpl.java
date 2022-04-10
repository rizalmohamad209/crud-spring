package com.crud.springcrud.services;

import com.crud.springcrud.entites.Film;
import com.crud.springcrud.entites.Schedule;
import com.crud.springcrud.entites.Studio;
import com.crud.springcrud.repository.FilmRepository;
import com.crud.springcrud.repository.ScheduleRepository;
import com.crud.springcrud.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ScheduleServiceImpl implements ScheduleServices{

    @Autowired
    private final ScheduleRepository repo;
    private final FilmRepository filmRepository;
    private final StudioRepository studioRepository;

    public ScheduleServiceImpl(ScheduleRepository repo, FilmRepository filmRepository, StudioRepository studioRepository) {
        this.repo = repo;
        this.filmRepository = filmRepository;
        this.studioRepository = studioRepository;
    }

    @Override
    public Schedule Post(Schedule params) {
        System.out.println(params);
       Optional<Film> optionalFilm =filmRepository.findById(params.getFilms().getId_film());
       Optional<Studio> optionalStudio = studioRepository.findById(params.getStudio().getId_studio());
        params.setFilms(optionalFilm.get());
        params.setStudio(optionalStudio.get());


        return repo.save(params);
    }

    @Override
    public List<Schedule> Get(String filmName ) {
        return repo.findScheduleFilm(filmName);
    }

    @Override
    public List<Schedule> Get() {
        return repo.findAll();
    }
}
