package com.example.factura.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.factura.entity.CLIENTE;

@Repository
public interface ClienteDAO extends JpaRepository<CLIENTE, Long> {

	
}
