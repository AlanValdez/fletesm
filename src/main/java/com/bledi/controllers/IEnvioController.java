package com.bledi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bledi.models.Envio;

public interface IEnvioController {

	ResponseEntity<List<Envio>> getAllEnvio();

	ResponseEntity<List<Envio>> getAllEnviosTerminados();

	ResponseEntity<Integer> createEnvio(Envio envio);

	ResponseEntity<Envio> getEnviosByConductorId(int conductor_id);
	
	ResponseEntity<Envio> getEnviosByTrailerId(int trailer_id);

	ResponseEntity<Integer> cerrarEnvio(int conductor_id, int trailer_id);
	
}
