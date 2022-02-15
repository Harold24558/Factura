package com.example.factura.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.factura.entity.PRODUCTO;

public interface ProductoDAO extends JpaRepository<PRODUCTO, Long> {

}
