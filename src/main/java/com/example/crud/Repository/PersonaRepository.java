package com.example.crud.Repository;

import com.example.crud.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
