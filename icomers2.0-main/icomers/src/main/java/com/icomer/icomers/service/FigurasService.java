package com.icomer.icomers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icomer.icomers.DTO.FigurasDTO;
import com.icomer.icomers.model.Figuras;
import com.icomer.icomers.repository.FigurasRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FigurasService {
    
    @Autowired
    private FigurasRepository figurasRepository;

    //metodo para listar todas las figuras
    public List<FigurasDTO> listartodos(){
        return figurasRepository.findAll().stream().map(figura -> {
            FigurasDTO dto = new FigurasDTO();
            dto.setIdFigura(figura.getIdFigura());
            dto.setNombre(figura.getNombre());
            dto.setPrecio(figura.getPrecio());
            dto.setNombreCategoria(figura.getCategoria().getNombreCategoria());
            return dto;
        }).toList();
    }

    //metodo para guardar una figura
    public Figuras guardarfFiguras(Figuras figura) {
        return figurasRepository.save(figura);
    }

    //metodo para eliminar una figura id
    public void eliminarporid(Integer idFigura) {
        if (!figurasRepository.existsById(idFigura)) {
            throw new RuntimeException("Error, La figura con ID " + idFigura + " no existe.");
        }
        figurasRepository.deleteById(idFigura);
    }

    //metodo para actualizar una figura id
    public Figuras actualizarFiguras(Integer id, Figuras figura) {
        Figuras figuraExistente = figurasRepository.findById(id).orElseThrow(() -> new RuntimeException("Error, La figura con ID " + id + " no existe."));
        if(figura.getNombre() != null){
            figuraExistente.setNombre(figura.getNombre());
        }
        if(figura.getPrecio() != null){
            figuraExistente.setPrecio(figura.getPrecio());
        }
        if(figura.getStock() != null){
            figuraExistente.setStock(figura.getStock());
        }
        if(figura.getCategoria() != null){
            figuraExistente.setCategoria(figura.getCategoria());
        }
        return figurasRepository.save(figuraExistente);
    }

    //metodo para convertir una figura a DTO
    public FigurasDTO convertirADTO(Figuras figura) {
        FigurasDTO dto = new FigurasDTO();
        dto.setIdFigura(figura.getIdFigura());
        dto.setNombre(figura.getNombre());
        dto.setPrecio(figura.getPrecio());
        dto.setNombreCategoria(figura.getCategoria().getNombreCategoria());
        dto.setDescripcion(figura.getDescripcion());
        return dto;
    }

    //metodo para buscar una figura por id
    public FigurasDTO buscarporid(Integer id) {
        Figuras figura = figurasRepository.findById(id).orElseThrow(() -> new RuntimeException("Error, La figura con ID " + id + " no existe."));
        return convertirADTO(figura);
    }

    //metodo para buscar figuras por categoria
    public List<FigurasDTO> buscarporcategoria(Integer idCategoria) {
        return figurasRepository.findByCategoria_IdCategoria(idCategoria).stream().map(this::convertirADTO).toList();
    }






}
