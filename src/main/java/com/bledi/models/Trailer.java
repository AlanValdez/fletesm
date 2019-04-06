package com.bledi.models;

public class Trailer {

	private int trailer_id;
	private String placas;
	private float capacidad;
	
	public Trailer(int trailer_id, String placas, float capacidad) {
		super();
		this.trailer_id = trailer_id;
		this.placas = placas;
		this.capacidad = capacidad;
	}

	public int getTrailer_id() {
		return trailer_id;
	}

	public void setTrailer_id(int trailer_id) {
		this.trailer_id = trailer_id;
	}

	public String getPlacas() {
		return placas;
	}

	public void setPlacas(String placas) {
		this.placas = placas;
	}

	public float getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}
	
	
}
