package com.crud.springcrud.services;

import com.crud.springcrud.entites.Studio;
import com.crud.springcrud.exception.ResourceNotFoundException;
import com.crud.springcrud.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudioServiceImpl implements  StudioServices{

    @Autowired
    private final StudioRepository repo;

    public StudioServiceImpl(StudioRepository repo) {
        this.repo = repo;
    }

    @Override
    public Studio Post(Studio params) {
        repo.save(params);
        return params;
    }

    @Override
    public List<Studio> Get() {
        return repo.findAll();
    }

    @Override
    public Studio Get(Integer id) throws ResourceNotFoundException {
       return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Couldn't find a studio with id: "+ id));
    }

    @Override
    public Studio Put(Studio params, Integer id) throws ResourceNotFoundException {
        Studio studioId = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Couldn't find a film with id: "+ id));
        studioId.setNama_studio(params.getNama_studio());
        return repo.save(studioId);
    }

    @Override
    public String Delete(Integer id) {
        repo.deleteById(id);
        return "Studio"+id+"has been deleted";
    }
}
