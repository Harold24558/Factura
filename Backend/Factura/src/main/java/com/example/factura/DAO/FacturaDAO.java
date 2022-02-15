package com.example.factura.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.factura.entity.FACTURA;

public interface FacturaDAO extends JpaRepository<FACTURA, Long> {

}
