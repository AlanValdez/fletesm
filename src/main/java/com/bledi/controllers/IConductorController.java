package com.bledi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bledi.models.Conductor;

public interface IConductorController {

	ResponseEntity<List<Conductor>> getAllConductores();

	ResponseEntity<Integer> createConductor(Conductor conductor);

	ResponseEntity<Integer> updateConductor(Conductor conductor, int conductor_id);

	ResponseEntity<List<Conductor>> getAllConductores(List<Integer> id_list);

	ResponseEntity<Conductor> getConductorByID(int conductor_id);

}