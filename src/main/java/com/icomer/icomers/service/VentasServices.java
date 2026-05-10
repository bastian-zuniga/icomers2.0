package com.icomer.icomers.service;

import com.icomer.icomers.model.Ventas;
import com.icomer.icomers.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentasServices {

    @Autowired
    private VentasRepository ventasRepository;

    //historial ventas
    public List<Ventas> listarVentas() {
        return ventasRepository.findAll();
    }

    // Registrar ventas
    public Ventas guardarVenta(Ventas venta) {
        if (venta.getFechaVenta() == null) {
            venta.setFechaVenta(LocalDateTime.now());
        }
        return ventasRepository.save(venta);
    }
    
    // Buscar venta por id
    public Ventas buscarPorId(Long id) {
        return ventasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id));
    }

    public void eliminar(Long id) {
        ventasRepository.deleteById(id);
    }

    public Ventas actualizar(Long id, Ventas nuevosDatos) {
        Ventas ventaExistente = ventasRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id));
        
        ventaExistente.setTipoEnvio(nuevosDatos.getTipoEnvio());
        ventaExistente.setTotal(nuevosDatos.getTotal());
        
        if(nuevosDatos.getFechaVenta() != null) {
            ventaExistente.setFechaVenta(nuevosDatos.getFechaVenta());
        }

        return ventasRepository.save(ventaExistente);
    }

}