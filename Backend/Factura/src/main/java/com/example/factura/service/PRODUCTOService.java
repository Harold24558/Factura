package com.example.factura.service;

import java.util.Optional;

import com.example.factura.entity.PRODUCTO;


public interface PRODUCTOService {

	public Iterable<PRODUCTO> findall();
	
	public Optional<PRODUCTO> findById(Long id);
	
	public PRODUCTO save(PRODUCTO producto);
	
	public void deleteById(Long id);
}
