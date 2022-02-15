package com.example.factura.service;

import java.util.Optional;

import com.example.factura.entity.FACTURA;

public interface FACTURAService {

	public Iterable<FACTURA> findall();
	
	public Optional<FACTURA> findById(Long id);
	
	public FACTURA save(FACTURA factura);
	
	public void deleteById(Long id);
}
