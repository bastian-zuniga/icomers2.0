package com.icomer.icomers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icomer.icomers.model.Categoria;
import com.icomer.icomers.repository.CategoriaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //metodo para listar todas las categorias
    public List<Categoria> obtenerTodos() {
        return categoriaRepository.findAll();
    }
    
    //metodo para guardar una categoria
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    //metodo para actualizar una categoria id
    public Categoria actualizarCategoria(Integer id, Categoria categoria) {
        Categoria categoriaExistente = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Error, La categoria con ID " + id + " no existe."));
        if(categoria.getNombreCategoria() != null){
            categoriaExistente.setNombreCategoria(categoria.getNombreCategoria());
        }
        return categoriaRepository.save(categoriaExistente);
    }

    //metodo para eliminar una categoria
    public String eliminarPorId(Integer id) {
        try {
            Categoria categoria = categoriaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("La categoria con id " + id + " no existe."));
            categoriaRepository.delete(categoria);
            return "La categoria " + categoria.getNombreCategoria() + " ha sido eliminada exitosamente.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

}
