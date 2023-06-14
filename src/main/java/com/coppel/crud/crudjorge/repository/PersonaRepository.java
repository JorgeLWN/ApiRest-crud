package com.coppel.crud.crudjorge.repository;

import com.coppel.crud.crudjorge.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
