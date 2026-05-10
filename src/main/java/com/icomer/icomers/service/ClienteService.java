package com.icomer.icomers.service;

import com.icomer.icomers.model.Cliente;
import com.icomer.icomers.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminar(Integer id) {
        clienteRepository.deleteById(id);
    }

    public Cliente actualizar(Integer id, Cliente nuevosDatos) {
    Cliente clienteExistente = clienteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No encontrado"));
    
    clienteExistente.setNombre(nuevosDatos.getNombre());
    clienteExistente.setEmail(nuevosDatos.getEmail());
    
    return clienteRepository.save(clienteExistente);
}
}