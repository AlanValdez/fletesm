package com.bledi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bledi.models.Trailer;

public interface ITrailerController {

	ResponseEntity<List<Trailer>> getAllTrailers();

	ResponseEntity<Integer> createTrailer(Trailer conductor);

	ResponseEntity<Integer> updateTrailer(Trailer conductor, int conductor_id);

	ResponseEntity<List<Trailer>> getAllTrailers(List<Integer> id_list);

	ResponseEntity<Trailer> getTrailerByID(int trailer_id);
}
