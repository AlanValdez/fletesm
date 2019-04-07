package com.bledi.models;

import java.util.Date;

public class Conductor {
	
	private int conductor_id;
	private String nombre;
	private String apellidos;
	private Date dia_nacimiento;
	private char sexo;
	
	public Conductor() {
		// TODO Auto-generated constructor stub
	}
	
	public Conductor(String nombre, String apellidos, Date dia_naciento, char sexo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dia_nacimiento = dia_naciento;
		this.sexo = sexo;
	}
	public Conductor(int conductor_id, String nombre, String apellidos, Date dia_naciento, char sexo) {
		super();
		this.conductor_id = conductor_id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dia_nacimiento = dia_naciento;
		this.sexo = sexo;
	}
	
	public int getConductor_id() {
		return conductor_id;
	}
	public void setConductor_id(int conductor_id) {
		this.conductor_id = conductor_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getDia_naciento() {
		return dia_nacimiento;
	}
	public void setDia_naciento(Date dia_naciento) {
		this.dia_nacimiento = dia_naciento;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

}
