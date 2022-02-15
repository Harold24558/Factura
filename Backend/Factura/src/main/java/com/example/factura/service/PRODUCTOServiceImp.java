package com.example.factura.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.factura.DAO.ProductoDAO;
import com.example.factura.entity.PRODUCTO;

public class PRODUCTOServiceImp implements PRODUCTOService {
	
	@Autowired
	private ProductoDAO productoDAO;

	@Override
	@Transactional(readOnly=true)
	public Iterable<PRODUCTO> findall() {
		
		return productoDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<PRODUCTO> findById(Long id) {

		return productoDAO.findById(id);
	}

	@Override
	@Transactional
	public PRODUCTO save(PRODUCTO producto) {
		
		return productoDAO.save(producto);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		productoDAO.deleteById(id);
		
	}

}
