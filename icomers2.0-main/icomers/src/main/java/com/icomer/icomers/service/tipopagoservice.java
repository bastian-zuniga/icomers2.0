package com.icomer.icomers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icomer.icomers.model.tipopago;
import com.icomer.icomers.repository.tipopagorepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class tipopagoservice {

    @Autowired
    private tipopagorepository tipopagorepository; 

    public List<tipopago> listartodos(){
        return tipopagorepository.findAll(); 
    }

    public tipopago buscarporid(Integer id){
        return tipopagorepository.findById(id).orElseThrow(() -> new RuntimeException("no encontrado"));
    }

    public tipopago guardartipopago(tipopago nuevo){
        return tipopagorepository.save(nuevo);
    }
}
