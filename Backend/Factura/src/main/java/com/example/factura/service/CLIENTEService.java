package com.example.factura.service;

import java.util.Optional;


import com.example.factura.entity.CLIENTE;


public interface CLIENTEService {

	public Iterable<CLIENTE> findall();
	
	public Optional<CLIENTE> findById(Long id);
	
	public CLIENTE save(CLIENTE cliente);
	
	public void deleteById(Long id);
}
