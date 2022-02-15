package com.example.factura.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.factura.DAO.ClienteDAO;
import com.example.factura.entity.CLIENTE;

@Service
public class CLIENTEServiceImp implements CLIENTEService{
	
	@Autowired
	private ClienteDAO clienteDAO;

	@Override
	@Transactional(readOnly=true)
	public Iterable<CLIENTE> findall() {
		
		return clienteDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<CLIENTE> findById(Long id) {
		
		return clienteDAO.findById(id);
	}

	@Override
	@Transactional
	public CLIENTE save(CLIENTE cliente) {
		
		return clienteDAO.save(cliente);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		clienteDAO.deleteById(id);
		
	}

}
