package com.icomer.icomers.controller;

import com.icomer.icomers.model.Personaje;
import com.icomer.icomers.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/personajes")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping
    public List<Personaje> obtenerTodos() {
        return personajeService.listarTodos();
    }

    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<Personaje> buscarPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(personajeService.buscarPorNombre(nombre));
    }


    @PostMapping
    public Personaje guardar(@RequestBody Personaje personaje) {
        return personajeService.guardar(personaje);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Personaje> actualizar(@PathVariable Long id, @RequestBody Personaje personajeDetalles) {
        return ResponseEntity.ok(personajeService.actualizar(id, personajeDetalles));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        personajeService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}