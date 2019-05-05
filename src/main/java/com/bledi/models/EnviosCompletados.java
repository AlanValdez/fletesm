package com.bledi.models;

import java.util.Date;

public class EnviosCompletados {

	private int envio_id ;
	private Date fecha_salida;
	private Date fecha_entrada;
	private String cliente;
	public EnviosCompletados(int envio_id, Date fecha_salida, Date fecha_entrada, String cliente) {
		super();
		this.envio_id = envio_id;
		this.fecha_salida = fecha_salida;
		this.fecha_entrada = fecha_entrada;
		this.cliente = cliente;
	}
	public int getEnvio_id() {
		return envio_id;
	}
	public void setEnvio_id(int envio_id) {
		this.envio_id = envio_id;
	}
	public Date getFecha_salida() {
		return fecha_salida;
	}
	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	public Date getFecha_entrada() {
		return fecha_entrada;
	}
	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	
}
