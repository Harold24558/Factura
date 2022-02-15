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


import com.example.factura.entity.FACTURA;
import com.example.factura.service.FACTURAService;

@RestController
@RequestMapping("/api/factura")
public class FACTURAController {

	@Autowired
	private FACTURAService facturaService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody FACTURA factura){
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(factura));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long Facturaid){
		Optional<FACTURA> oFACTURA = facturaService.findById(Facturaid);
		
		if(!oFACTURA.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oFACTURA);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody FACTURA facturaDetails, @PathVariable(value = "id") Long Facturaid){
		Optional<FACTURA> factura = facturaService.findById(Facturaid);
		
		if(!factura.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		factura.get().setFecha(facturaDetails.getFecha());

		
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(factura.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long Facturaid){
		if(!facturaService.findById(Facturaid).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		facturaService.deleteById(Facturaid);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<FACTURA> readAll(){
		List<FACTURA> facturas = StreamSupport
				.stream(facturaService.findall().spliterator(), false)
				.collect(Collectors.toList());
		
		return facturas;
	}

}
