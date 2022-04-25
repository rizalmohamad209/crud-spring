package com.crud.springcrud.services;

import com.crud.springcrud.entites.Seats;
import com.crud.springcrud.entites.Studio;
import com.crud.springcrud.repository.SeatsRepository;
import com.crud.springcrud.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatsServiceImpl implements SeatsServices{

    @Autowired
    private  final SeatsRepository seatsRepo;
    private final StudioRepository studioRepo;

    public SeatsServiceImpl(SeatsRepository seatsRepo, StudioRepository studioRepo) {
        this.seatsRepo = seatsRepo;
        this.studioRepo = studioRepo;
    }

    @Override
    public Seats Post(Seats params) {
        Optional<Studio> optionalStudio = studioRepo.findById(params.getStudio().getId_studio());
        params.setStudio(optionalStudio.get());

        seatsRepo.save(params);
        return params;
    }

    @Override
    public List<Seats> Get() {
        return seatsRepo.findAll();
    }

    @Override
    public Seats Get(Integer id) {
        return null;
    }
}
