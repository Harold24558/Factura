package com.example.factura.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.factura.DAO.FacturaDAO;
import com.example.factura.entity.FACTURA;

public class FACTURAServiceImp  implements FACTURAService{

	@Autowired
	private FacturaDAO facturaDAO;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<FACTURA> findall() {
	
		return facturaDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<FACTURA> findById(Long id) {

		return facturaDAO.findById(id);
	}

	@Override
	@Transactional
	public FACTURA save(FACTURA factura) {
		
		return facturaDAO.save(factura);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		facturaDAO.deleteById(id);
		
	}

}
