package com.bledi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bledi.dao.TrailerDAO;
import com.bledi.models.Trailer;
@Controller
public class TrailerController implements ITrailerController {

	@Autowired
  	private TrailerDAO trailerDao;
	
  @Override
  @GetMapping("/trailers")
  @ResponseBody
  public ResponseEntity<List<Trailer>> getAllTrailers() {
		return new ResponseEntity<List<Trailer>>(trailerDao.getAllTrailers(), HttpStatus.OK);   
  }
	
  @Override
  @PostMapping("/trailers/create")
  @ResponseBody
  public ResponseEntity<Integer> createTrailer(@RequestBody Trailer trailer) {
	  
		if(trailerIsValid(trailer)) return new ResponseEntity<Integer>(trailerDao.createTrailer(trailer), HttpStatus.OK);
		else return new ResponseEntity<Integer>( HttpStatus.BAD_REQUEST);
  }
	
  @Override
  @PostMapping("/trailers/update")
  @ResponseBody
  public ResponseEntity<Integer> updateTrailer(@RequestBody Trailer trailer, @RequestParam(name="id", required=true) int trailer_id) {
		return new ResponseEntity<Integer>(trailerDao.updateTrailer(trailer, trailer_id), HttpStatus.OK);   
  }
	
  @Override
  @GetMapping("/trailers_list")
  @ResponseBody
  public ResponseEntity<List<Trailer>> getAllTrailers(@RequestParam(name="ids",required = false) List<Integer> id_list) {
	  	
		if(id_list != null && !id_list.isEmpty()) return new ResponseEntity<List<Trailer>>(trailerDao.getAllTrailers(id_list), HttpStatus.OK);
		else return new ResponseEntity<List<Trailer>>(HttpStatus.BAD_REQUEST);
  }

  @Override
  @GetMapping("/trailers/by")
  @ResponseBody
  public ResponseEntity<Trailer> getTrailerByID(@RequestParam(name="id", required=true) int trailer_id) {    
  	if(trailer_id != 0) {
  		return new ResponseEntity<Trailer>(trailerDao.getTrailerById(trailer_id), HttpStatus.OK);   
  	}
		return new ResponseEntity<Trailer>(HttpStatus.BAD_REQUEST);   
  }
  
  private boolean trailerIsValid(Trailer trailer) {
	  if(trailer.getPlacas() != "" && trailer.getcapacidad_toneladas() != 0.0) return true;
	  else return false;
  }

}
