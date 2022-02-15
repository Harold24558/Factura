package com.example.factura.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DETALLE")
public class DETALLE {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num_detalle;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_factura;
	
	@Column(nullable = false)
	private int id_producto;
	
	@Column(nullable = false)
	private int cantidad;
	
	@Column(nullable = false)
	private long precio;

	public Long getNum_detalle() {
		return num_detalle;
	}

	public void setNum_detalle(Long num_detalle) {
		this.num_detalle = num_detalle;
	}

	public int getId_factura() {
		return id_factura;
	}

	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public long getPrecio() {
		return precio;
	}

	public void setPrecio(long precio) {
		this.precio = precio;
	}
	
	

}
