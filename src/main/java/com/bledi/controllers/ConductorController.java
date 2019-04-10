package com.bledi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bledi.dao.ConductorDAO;
import com.bledi.models.Conductor;
@Controller
@RequestMapping("/api")
public class ConductorController implements IConductorController {

	@Autowired
	  private ConductorDAO conductorDao;
	
	/* (non-Javadoc)
	 * @see com.bledi.controllers.IConductorController#getAllConductores()
	 */
	@Override
	@GetMapping("/conductores")
    @ResponseBody
    public ResponseEntity<List<Conductor>> getAllConductores() {
		return new ResponseEntity<List<Conductor>>(conductorDao.getAllConductors(), HttpStatus.OK);   
    }
	
	/* (non-Javadoc)
	 * @see com.bledi.controllers.IConductorController#createConductor(com.bledi.models.Conductor)
	 */
	@Override
	@PostMapping("/conductores/create")
    @ResponseBody
    public ResponseEntity<Integer> createConductor(@RequestBody Conductor conductor) {
		return new ResponseEntity<Integer>(conductorDao.createConductor(conductor), HttpStatus.OK);   
    }
	
	/* (non-Javadoc)
	 * @see com.bledi.controllers.IConductorController#updateConductor(com.bledi.models.Conductor, int)
	 */
	@Override
	@PostMapping("/conductores/update")
    @ResponseBody
    public ResponseEntity<Integer> updateConductor(@RequestBody Conductor conductor, @RequestParam(name="id", required=true) int conductor_id) {
		return new ResponseEntity<Integer>(conductorDao.updateConductor(conductor, conductor_id), HttpStatus.OK);   
    }
	
	/* (non-Javadoc)
	 * @see com.bledi.controllers.IConductorController#getAllConductores(java.util.List)
	 */
	@Override
	@GetMapping("/conductores_list")
    @ResponseBody
    public ResponseEntity<List<Conductor>> getAllConductores(@RequestParam(name="ids",required = false) List<Integer> id_list) {
		return new ResponseEntity<List<Conductor>>(conductorDao.getAllConductors(id_list), HttpStatus.OK);   
    }
    
    /* (non-Javadoc)
	 * @see com.bledi.controllers.IConductorController#getConductorByID(int)
	 */
    @Override
	@GetMapping("/conductores/by")
    @ResponseBody
    public ResponseEntity<Conductor> getConductorByID(@RequestParam(name="id", required=true) int conductor_id) {    
    	
    	if(conductor_id != 0) {
    		return new ResponseEntity<Conductor>(conductorDao.getConductorById(conductor_id), HttpStatus.OK);   
    	}
		return new ResponseEntity<Conductor>(HttpStatus.BAD_REQUEST);   
    }
}
