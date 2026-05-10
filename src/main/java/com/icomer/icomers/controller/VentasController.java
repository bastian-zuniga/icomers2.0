package com.icomer.icomers.controller;

import com.icomer.icomers.model.Ventas;
import com.icomer.icomers.service.VentasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class VentasController {

    @Autowired
    private VentasServices ventasService;

    @GetMapping
    public List<Ventas> obtenerTodas() {
        return ventasService.listarVentas();
    }

    @PostMapping
    public Ventas guardar(@RequestBody Ventas venta) {
        return ventasService.guardarVenta(venta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ventas> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ventasService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ventas> actualizar(@PathVariable Long id, @RequestBody Ventas ventaDetalles) {
        return ResponseEntity.ok(ventasService.actualizar(id, ventaDetalles));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        ventasService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}