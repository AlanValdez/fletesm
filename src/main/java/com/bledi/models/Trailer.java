package com.bledi.models;

public class Trailer {

	private int trailer_id;
	private String placas;
	private float capacidad_toneladas;
	public Trailer() { }
	public Trailer(String placas, float capacidad_toneladas) {
		super();
		this.placas = placas;
		this.capacidad_toneladas = capacidad_toneladas;
	}
	
	public Trailer(int trailer_id, String placas, float capacidad_toneladas) {
		super();
		this.trailer_id = trailer_id;
		this.placas = placas;
		this.capacidad_toneladas = capacidad_toneladas;
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

	public float getcapacidad_toneladas() {
		return capacidad_toneladas;
	}

	public void setcapacidad_toneladas(float capacidad_toneladas) {
		this.capacidad_toneladas = capacidad_toneladas;
	}
	
	
}
