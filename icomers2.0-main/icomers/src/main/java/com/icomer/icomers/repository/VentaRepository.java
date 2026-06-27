package com.icomer.icomers.repository;

import com.icomer.icomers.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Ventas, Long> {
}