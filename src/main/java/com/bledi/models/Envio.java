package com.bledi.models;

import java.util.Date;

public class Envio {
	
	private int conductor_id;
	private int trailer_id;
	private String tipo_carga;
	private Date fecha_salida;
	private String cliente;
	private String estado;
	private String ciudad;
	private String direccion;
	public String getNombreCompleto() {
		return NombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		NombreCompleto = nombreCompleto;
	}

	public String getPlacas() {
		return placas;
	}

	public void setPlacas(String placas) {
		this.placas = placas;
	}
	private String estado_actual;
	private String NombreCompleto;
	private String placas;

	
	public Envio() { }
	

	public Envio(int conductor_id, int trailer_id, String tipo_carga, Date fecha_salida, String cliente, String estado,
			String ciudad, String direccion, String estado_actual, String nombreCompleto, String placas) {
		super();
		this.conductor_id = conductor_id;
		this.trailer_id = trailer_id;
		this.tipo_carga = tipo_carga;
		this.fecha_salida = fecha_salida;
		this.cliente = cliente;
		this.estado = estado;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.estado_actual = estado_actual;
		NombreCompleto = nombreCompleto;
		this.placas = placas;
	}

	public int getConductor_id() {
		return conductor_id;
	}
	public void setConductor_id(int conductor_id) {
		this.conductor_id = conductor_id;
	}
	public int getTrailer_id() {
		return trailer_id;
	}
	public void setTrailer_id(int trailer_id) {
		this.trailer_id = trailer_id;
	}
	public String getTipo_carga() {
		return tipo_carga;
	}
	public void setTipo_carga(String tipo_carga) {
		this.tipo_carga = tipo_carga;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getEstado_actual() {
		return estado_actual;
	}
	public void setEstado_actual(String estado_actual) {
		this.estado_actual = estado_actual;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFecha_salida() {
		return fecha_salida;
	}
	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	
}
