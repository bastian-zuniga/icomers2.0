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
    public List<FigurasDTO> obtenerTodos() {
        return figurasRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    //metodo para guardar una figura
    public Figuras guardarFiguras(Figuras figura) {
        return figurasRepository.save(figura);
    }

    //metodo para eliminar una figura id
    public String eliminarFigura(Integer id) {
        try {
            Figuras figura = figurasRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("La figura con ID " + id + " no existe."));
            figurasRepository.delete(figura);
            return "La figura " + figura.getNombre() + " ha sido eliminada exitosamente.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
    //metodo para actualizar una figura id
    public FigurasDTO actualizarFiguras(Integer id, FigurasDTO figura) {
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
        return convertirADTO(figurasRepository.save(figuraExistente));  
    }

    //metodo para convertir una figura a DTO
    public FigurasDTO convertirADTO(Figuras figura) {
        FigurasDTO dto = new FigurasDTO();
        dto.setIdFigura(figura.getIdFigura());
        dto.setNombre(figura.getNombre());
        dto.setPrecio(figura.getPrecio());
        dto.setCategoria(figura.getCategoria());
        dto.setDescripcion(figura.getDescripcion());
        return dto;
    }

    //metodo para buscar una figura por id
    public FigurasDTO buscarPorId(Integer id) {
        Figuras figura = figurasRepository.findById(id).orElseThrow(() -> new RuntimeException("Error, La figura con ID " + id + " no existe."));
        return convertirADTO(figura);
    }

    //metodo para buscar figuras por categoria
    public List<FigurasDTO> buscarPorCategoria(Integer idCategoria) {
        return figurasRepository.findByCategoria_IdCategoria(idCategoria).stream().map(this::convertirADTO).toList();
    }

<<<<<<< HEAD





=======
>>>>>>> 69e597199b117d37f07e8c7bb9c39ff323663b1f
}
