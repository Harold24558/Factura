package com.example.factura.service;

import java.util.Optional;


import com.example.factura.entity.DETALLE;


public interface DETALLEService {

	public Iterable<DETALLE> findall();
	
	public Optional<DETALLE> findById(Long id);
	
	public DETALLE save(DETALLE detalle);
	
	public void deleteById(Long id);
}
