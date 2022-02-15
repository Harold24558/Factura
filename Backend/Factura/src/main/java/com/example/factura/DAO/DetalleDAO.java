package com.example.factura.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.factura.entity.DETALLE;

public interface DetalleDAO extends JpaRepository<DETALLE, Long>{

}
