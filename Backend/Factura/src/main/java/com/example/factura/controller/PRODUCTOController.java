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

import com.example.factura.entity.PRODUCTO;
import com.example.factura.service.PRODUCTOService;

@RestController
@RequestMapping("/api/producto")
public class PRODUCTOController {

	@Autowired
	private PRODUCTOService productoService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody PRODUCTO factura){
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(factura));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long Productoid){
		Optional<PRODUCTO> oPRODUCTO = productoService.findById(Productoid);
		
		if(!oPRODUCTO.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oPRODUCTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody PRODUCTO productoDetails, @PathVariable(value = "id") Long Productoid){
		Optional<PRODUCTO> producto = productoService.findById(Productoid);
		
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		producto.get().setPrecio(productoDetails.getPrecio());
		producto.get().setNombre(productoDetails.getNombre());

		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long Productoid){
		if(!productoService.findById(Productoid).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		productoService.deleteById(Productoid);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<PRODUCTO> readAll(){
		List<PRODUCTO> facturas = StreamSupport
				.stream(productoService.findall().spliterator(), false)
				.collect(Collectors.toList());
		
		return facturas;
	}
}
