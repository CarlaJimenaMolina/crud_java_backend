package com.example.crud.Controller;

import com.example.crud.Entity.Persona;
import com.example.crud.Service.PersonaServiceImpl.PersonaServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CRUD")
public class Controlador {

    @Autowired
    private PersonaServiceIMPL personaServiceIMPL;

    @GetMapping
    @RequestMapping(value = "ConsultarPersonas", method= RequestMethod.GET)
    public ResponseEntity<?> ConsultarPersonas(){
        List<Persona> listarPersona = this.personaServiceIMPL.consultarPersona();
        return ResponseEntity.ok(listarPersona);
    }

    @PostMapping
    @RequestMapping(value = "CrearPersonas", method= RequestMethod.POST)
    public ResponseEntity<?> CrearPersonas(@RequestBody Persona persona){
        Persona personaCreada = this.personaServiceIMPL.crearPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(personaCreada);
    }

    @PutMapping
    @RequestMapping(value = "ModificarPersonas", method= RequestMethod.PUT)
    public ResponseEntity<?> ModificarPersonas(@RequestBody Persona persona){
        Persona personaModificada = this.personaServiceIMPL.modificarPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(personaModificada);
    }

    @GetMapping
    @RequestMapping(value = "BuscarPersona", method= RequestMethod.GET)
    public ResponseEntity<?> BuscarPersona(@PathVariable int id){
        Persona persona = this.personaServiceIMPL.buscarPersona(id);
        return ResponseEntity.ok(persona);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarPersonas", method= RequestMethod.DELETE)
    public ResponseEntity<?> EliminarPersonas(@PathVariable int id){
        this.personaServiceIMPL.eliminarPersona(id);
        return ResponseEntity.ok().build();
    }
}
