package com.example.crud.Service.PersonaServiceImpl;

import com.example.crud.Entity.Persona;
import com.example.crud.Repository.PersonaRepository;
import com.example.crud.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceIMPL implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> consultarPersona() {
        return (List<Persona>) this.personaRepository.findAll();
    }

    @Override
    public Persona crearPersona(Persona persona) {

        return this.personaRepository.save(persona);
    }

    @Override
    public Persona modificarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona buscarPersona(int id) {
        return this.personaRepository.findById(id).get();
    }

    @Override
    public void eliminarPersona(int id) {
        this.personaRepository.deleteById(id);
    }
}
