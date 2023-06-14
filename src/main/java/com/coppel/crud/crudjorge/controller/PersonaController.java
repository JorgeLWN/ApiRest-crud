package com.coppel.crud.crudjorge.controller;


import com.coppel.crud.crudjorge.model.Persona;
import com.coppel.crud.crudjorge.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping("/personas")
    public List<Persona> listarPersonas() {

        return service.listarPersonas();
    }
    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona> obtenerPersona(@PathVariable Integer id){
      try{
          Persona persona= service.obtenerPersonaPorId(id);
          return new ResponseEntity<Persona>(persona, HttpStatus.OK);
      }catch(Exception exception){
          return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
      }
    }
    @PostMapping("/personas")
    public void guardarPersona(@RequestBody Persona persona){
       service.guardarPersona(persona);
    }
    @PutMapping("/personas/{id}")
    public ResponseEntity<?> actualizarPersona(@RequestBody Persona persona,@PathVariable Integer id){
         try{
            Persona personaActual = service.obtenerPersonaPorId(id);
            personaActual.setNombre(persona.getNombre());
            personaActual.setTelefono(persona.getTelefono());

            service.guardarPersona(personaActual);
             return new ResponseEntity<Persona>(HttpStatus.OK);
         }catch(Exception exception){
             return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
         }
    }

    @DeleteMapping("/personas/{id}")
    public void eliminarPersona(@PathVariable Integer id){
        service.eliminarPersona(id);
    }
}
