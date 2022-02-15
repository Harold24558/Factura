package com.example.factura.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.factura.DAO.DetalleDAO;
import com.example.factura.entity.DETALLE;

@Service
public class DETALLEServiceImp implements DETALLEService{
	
	@Autowired
	private DetalleDAO detalleDAO;

	@Override
	@Transactional(readOnly=true)
	public Iterable<DETALLE> findall() {
		return detalleDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<DETALLE> findById(Long id) {
		return detalleDAO.findById(id);
	}

	@Override
	@Transactional
	public DETALLE save(DETALLE detalle) {
		return detalleDAO.save(detalle);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		detalleDAO.deleteById(id);
	}

}
