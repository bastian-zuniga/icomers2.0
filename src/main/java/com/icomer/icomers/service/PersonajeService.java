package com.icomer.icomers.service;

import com.icomer.icomers.model.Personaje;
import com.icomer.icomers.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonajeService {
    @Autowired
    private PersonajeRepository personajeRepository;

    public List<Personaje> listarTodos() {
        return personajeRepository.findAll();
    }
    public Personaje buscarPorNombre(String nombre) {
    return personajeRepository.findByNombre(nombre)
            .orElseThrow(() -> new RuntimeException("No se encontró el personaje: " + nombre));
    }

    public Personaje guardar(Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    public void eliminar(Long id) {
        personajeRepository.deleteById(id);
    }

    public Personaje actualizar(Long id, Personaje nuevosDatos) {
        Personaje personajeExistente = personajeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Personaje no encontrado con ID: " + id));
        
        personajeExistente.setNombre(nuevosDatos.getNombre());
        return personajeRepository.save(personajeExistente);
    }

 }