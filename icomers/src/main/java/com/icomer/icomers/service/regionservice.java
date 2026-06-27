package com.icomer.icomers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icomer.icomers.model.region;
import com.icomer.icomers.repository.regionrepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class regionservice {

    @Autowired
    private regionrepository regionrepository;

    public List<region> listartodos(){
        log.info("SERVICE: Listando todas las regiones");
        return regionrepository.findAll();
    }

    public region buscarporid(Integer id){
        log.info("SERVICE: Buscando region ID: {}", id);
        return regionrepository.findById(id).orElseThrow(() -> {
            log.error("SERVICE: No se encontro la region ID: {}", id);
            return new RuntimeException("no encontrado");
        });
    }

    public region guardarregion(region nueva){
        log.info("SERVICE: Guardando nueva region: {}", nueva.getNombre());
        return regionrepository.save(nueva);
    }

    public region actualizarregion(Integer id, region datosNuevos){
        log.info("SERVICE: Actualizando region ID: {}", id);
        region existente = buscarporid(id);
        existente.setNombre(datosNuevos.getNombre());
        existente.setActivo(datosNuevos.getActivo());
        return regionrepository.save(existente);
    }

    public void eliminarregion(Integer id){
        log.info("SERVICE: Eliminando region ID: {}", id);
        region existente = buscarporid(id);
        regionrepository.delete(existente);
    }
}