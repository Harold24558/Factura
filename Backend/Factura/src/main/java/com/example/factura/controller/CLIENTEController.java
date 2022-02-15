package com.example.factura.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.factura.entity.CLIENTE;
import com.example.factura.service.CLIENTEService;


@RestController
@RequestMapping("/api/clientes")
public class CLIENTEController {
	
	@Autowired
	private CLIENTEService clienteService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody CLIENTE cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long Clienteid){
		Optional<CLIENTE> oCLIENTE = clienteService.findById(Clienteid);
		
		if(!oCLIENTE.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oCLIENTE);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody CLIENTE clienteDetails, @PathVariable(value = "id") Long Clienteid){
		Optional<CLIENTE> cliente = clienteService.findById(Clienteid);
		
		if(!cliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.get().setNombre(clienteDetails.getNombre());
		cliente.get().setApellido(clienteDetails.getApellido());
		cliente.get().setDireccion(clienteDetails.getDireccion());
		cliente.get().setEmail(clienteDetails.getEmail());
		cliente.get().setFecha_nacimiento(clienteDetails.getFecha_nacimiento());
		cliente.get().setTelefono(clienteDetails.getTelefono());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long Clienteid){
		if(!clienteService.findById(Clienteid).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		clienteService.deleteById(Clienteid);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<CLIENTE> readAll(){
		List<CLIENTE> clientes = StreamSupport
				.stream(clienteService.findall().spliterator(), false)
				.collect(Collectors.toList());
		
		return clientes;
	}
	

}
