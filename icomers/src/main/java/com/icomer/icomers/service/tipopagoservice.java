package com.icomer.icomers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icomer.icomers.model.tipopago;
import com.icomer.icomers.repository.tipopagorepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class tipopagoservice {

    @Autowired
    private tipopagorepository tipopagorepository;

    public List<tipopago> listartodos(){
        log.info("SERVICE: Listando todos los tipos de pago");
        return tipopagorepository.findAll();
    }

    public tipopago buscarporid(Integer id){
        log.info("SERVICE: Buscando tipo de pago ID: {}", id);
        return tipopagorepository.findById(id).orElseThrow(() -> {
            log.error("SERVICE: No se encontro el ID: {}", id);
            return new RuntimeException("no encontrado");
        });
    }

    public tipopago guardartipopago(tipopago nuevo){
        log.info("SERVICE: Guardando nuevo pago: {}", nuevo.getNombre());
        return tipopagorepository.save(nuevo);
    }

    
    public tipopago actualizartipopago(Integer id, tipopago datosNuevos){
        log.info("SERVICE: Actualizando tipo de pago ID: {}", id);
        tipopago existente = buscarporid(id);
        existente.setNombre(datosNuevos.getNombre());
        existente.setActivo(datosNuevos.getActivo()); 
        return tipopagorepository.save(existente);
    }

    public void eliminartipopago(Integer id){
        log.info("SERVICE: Eliminando tipo de pago ID: {}", id);
        tipopago existente = buscarporid(id);
        tipopagorepository.delete(existente);
    }
}