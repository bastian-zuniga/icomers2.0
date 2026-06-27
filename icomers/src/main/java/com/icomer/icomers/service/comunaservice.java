package com.icomer.icomers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icomer.icomers.model.comuna;
import com.icomer.icomers.repository.comunarepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class comunaservice {

    @Autowired
    private comunarepository comunarepository;

    public List<comuna> listartodos(){
        log.info("SERVICE: Listando todas las comunas");
        return comunarepository.findAll();
    }

    public comuna buscarporid(Integer id){
        log.info("SERVICE: Buscando comuna ID: {}", id);
        return comunarepository.findById(id).orElseThrow(() -> {
            log.error("SERVICE: No se encontro la comuna ID: {}", id);
            return new RuntimeException("no encontrado");
        });
    }

    public comuna guardarcomuna(comuna nueva){
        log.info("SERVICE: Guardando nueva comuna: {}", nueva.getNombre());
        return comunarepository.save(nueva);
    }

    public comuna actualizarcomuna(Integer id, comuna datosNuevos){
        log.info("SERVICE: Actualizando comuna ID: {}", id);
        comuna existente = buscarporid(id);
        existente.setNombre(datosNuevos.getNombre());
        existente.setActivo(datosNuevos.getActivo());
        existente.setRegionid(datosNuevos.getRegionid());
        return comunarepository.save(existente);
    }

    public void eliminarcomuna(Integer id){
        log.info("SERVICE: Eliminando comuna ID: {}", id);
        comuna existente = buscarporid(id);
        comunarepository.delete(existente);
    }
}