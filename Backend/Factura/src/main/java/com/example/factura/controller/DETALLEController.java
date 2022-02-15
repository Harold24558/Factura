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


import com.example.factura.entity.DETALLE;
import com.example.factura.service.DETALLEService;

@RestController
@RequestMapping("/api/detalle")
public class DETALLEController {
	
	@Autowired
	private DETALLEService detalleService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody DETALLE detalle){
		return ResponseEntity.status(HttpStatus.CREATED).body(detalleService.save(detalle));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long Detalleid){
		Optional<DETALLE> oDETALLE = detalleService.findById(Detalleid);
		
		if(!oDETALLE.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oDETALLE);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody DETALLE detalleDetails, @PathVariable(value = "id") Long Detalleid){
		Optional<DETALLE> detalle = detalleService.findById(Detalleid);
		
		if(!detalle.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		detalle.get().setCantidad(detalleDetails.getCantidad());
		detalle.get().setPrecio(detalleDetails.getPrecio());

		
		return ResponseEntity.status(HttpStatus.CREATED).body(detalleService.save(detalle.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long Detalleid){
		if(!detalleService.findById(Detalleid).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		detalleService.deleteById(Detalleid);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<DETALLE> readAll(){
		List<DETALLE> detalles = StreamSupport
				.stream(detalleService.findall().spliterator(), false)
				.collect(Collectors.toList());
		
		return detalles;
	}

}
