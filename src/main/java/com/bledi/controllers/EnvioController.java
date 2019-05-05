package com.bledi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bledi.dao.EnvioDAO;
import com.bledi.models.Envio;

@Controller
@RequestMapping("/api")
public class EnvioController implements IEnvioController {

	@Autowired
	EnvioDAO envioDAO;
	
	@Override
	@GetMapping("/envios")
	@ResponseBody
	public ResponseEntity<List<Envio>> getAllEnvio() {
		// TODO Auto-generated method stub
		return new ResponseEntity<List<Envio>>(envioDAO.getAllEnvios(), HttpStatus.OK);
	}
	
	@Override
	@GetMapping("/envios_terminados")
	@ResponseBody
	public ResponseEntity<List<Envio>> getAllEnviosTerminados() {
		// TODO Auto-generated method stub
		return new ResponseEntity<List<Envio>>(envioDAO.getAllEnviosTerminados(), HttpStatus.OK);
	}

	@Override
	@PostMapping("/envios")
	@ResponseBody
	public ResponseEntity<Integer> createEnvio(@RequestBody Envio envio) {
		// TODO Auto-generated method stub
		
		return new ResponseEntity<Integer>(envioDAO.createEnvio(envio), HttpStatus.OK);
	}

	@Override
	@PutMapping("/envios")
	@ResponseBody
	public ResponseEntity<Integer> cerrarEnvio(@RequestParam(name="cond", required=true) int conductor_id, @RequestParam(name="trai", required=true) int trailer_id) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Integer>(envioDAO.cerrarEnvio(conductor_id, trailer_id), HttpStatus.OK);
	}

	@Override
	@GetMapping("/envios/byConductor")
	@ResponseBody
	public ResponseEntity<Envio> getEnviosByConductorId(@RequestParam(name="id", required=true) int conductor_id) {
		// TODO Auto-generated method stub
		if(conductor_id != 0) return new ResponseEntity<Envio>(envioDAO.getEnviosByConductorId(conductor_id), HttpStatus.OK);
		else return new ResponseEntity<Envio>(HttpStatus.BAD_REQUEST);
	}

	@Override
	@GetMapping("/envios/byTrailer")
	@ResponseBody
	public ResponseEntity<Envio> getEnviosByTrailerId(@RequestParam(name="id", required=true) int trailer_id) {
		// TODO Auto-generated method stub
		if(trailer_id != 0) return new ResponseEntity<Envio>(envioDAO.getEnviosByConductorId(trailer_id), HttpStatus.OK);
		else return new ResponseEntity<Envio>(HttpStatus.BAD_REQUEST);
	}

	

}
