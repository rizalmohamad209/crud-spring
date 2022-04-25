package com.crud.springcrud.services;

import com.crud.springcrud.entites.Film;
import com.crud.springcrud.entites.Schedule;
import com.crud.springcrud.entites.Studio;
import com.crud.springcrud.exception.ResourceNotFoundException;
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
        Optional<Film> optionalFilm =filmRepository.findById(params.getFilm().getId_film());
       Optional<Studio> optionalStudio = studioRepository.findById(params.getStudio().getId_studio());
        params.setFilm(optionalFilm.get());
        params.setStudio(optionalStudio.get());

        System.out.println(optionalFilm);
        System.out.println(params+"ini request body");
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

    @Override
    public Schedule Get(Integer id) throws ResourceNotFoundException {
        return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Schedule with id: "+id+" not found"));
    }

    @Override
    public Schedule Put(Integer id, Schedule params)  throws ResourceNotFoundException{

        Schedule scheduleOptional = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Couldn't find a film with id: "+ id));
        Optional<Film> optionalFilm =filmRepository.findById(params.getFilm().getId_film());
        Optional<Studio> optionalStudio = studioRepository.findById(params.getStudio().getId_studio());
//        params.setFilm(optionalFilm.get());
//        params.setStudio(optionalStudio.get());

        System.out.println(optionalFilm+" ini optional film");
        scheduleOptional.setFilm(optionalFilm.get());
        scheduleOptional.setStudio(optionalStudio.get());
        scheduleOptional.setHarga_tiket(params.getHarga_tiket());
        scheduleOptional.setJam_mulai(params.getJam_mulai());
        scheduleOptional.setJam_selesai(params.getJam_selesai());
        scheduleOptional.setTanggal_tayang(params.getTanggal_tayang());




        return repo.save(scheduleOptional);
    }

    @Override
    public String Delete(Integer id) {
        repo.deleteById(id);
        return "Schedule with id "+ id +" has been deleted";
    }
}
