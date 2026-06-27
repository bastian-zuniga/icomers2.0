package com.icomer.icomers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icomer.icomers.DTO.FigurasDTO;
import com.icomer.icomers.model.Figuras;
import com.icomer.icomers.service.FigurasService;

@RestController
@RequestMapping("/api/v1/figuras")
public class FigurasController {

    @Autowired
    private FigurasService figurasService;
    
    //metodo para listar todas las figuras
    @GetMapping
    public ResponseEntity<List<FigurasDTO>> obtenerTodos() {
        List<FigurasDTO> figuras = figurasService.obtenerTodos();
        if (figuras.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(figuras, HttpStatus.OK);
    }

    //metodo para buscar una figura por id  
    @GetMapping("/{id}")
    public ResponseEntity<FigurasDTO> buscarPorId(@PathVariable Integer id) {
        try {
            FigurasDTO figura = figurasService.buscarPorId(id);
            return new ResponseEntity<>(figura, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //buscar una figura por categoria
    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<List<FigurasDTO>> buscarPorCategoria(@PathVariable Integer idCategoria) {
        List<FigurasDTO> figuras = figurasService.buscarPorCategoria(idCategoria);
        if (figuras.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(figuras, HttpStatus.OK);
    }

    //actualizar una figura por id
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<FigurasDTO> actualizarFigura(@PathVariable Integer id, @RequestBody FigurasDTO figura) {
        try {
            FigurasDTO figuraActualizada = figurasService.actualizarFiguras(id, figura);
            return new ResponseEntity<>(figuraActualizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //eliminar una figura por id
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarFigura(@PathVariable Integer id) {
        String resultado = figurasService.eliminarFigura(id);
        if (resultado.contains("exitosamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }

    }

    //guardar una figura
    @PostMapping
    public ResponseEntity<Figuras> guardarFigura(@RequestBody Figuras figura) {
        try {
            Figuras guardado = figurasService.guardarFiguras(figura);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}