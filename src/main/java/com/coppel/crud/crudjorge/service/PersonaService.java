package com.coppel.crud.crudjorge.service;


import com.coppel.crud.crudjorge.model.Persona;
import com.coppel.crud.crudjorge.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository repository;

    public List<Persona> listarPersonas(){
        return repository.findAll();
    }

    public void guardarPersona(Persona persona){
        repository.save(persona);
    }

    public Persona obtenerPersonaPorId(Integer id){
        return repository.findById(id).get();
    }
    public void eliminarPersona(Integer id){
        repository.deleteById(id);
    }

}
