package com.bledi.fletesm.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bledi.fletesm.exception.ResourceNotFoundException;
import com.bledi.fletesm.model.Flete;
import com.bledi.fletesm.repository.FleteRepository;

@RestController
@RequestMapping("/api")
public class FleteController {

    @Autowired
    FleteRepository fleteRepository;
    
    @GetMapping("/fletes")
    public List<Flete> getAllNotes() {
        return fleteRepository.findAll();
    }
    
 // Crear flete
    @PostMapping("/notes")
    public Flete createNote(@Valid @RequestBody Flete note) {
        return fleteRepository.save(note);
    }
    
 // Tomar un solo flete
    @GetMapping("/notes/{id}")
    public Flete getNoteById(@PathVariable(value = "id") Long fleteId) {
        return fleteRepository.findById(fleteId)
                .orElseThrow(() -> new ResourceNotFoundException("Flete", "id", fleteId));
    }
    
    @PutMapping("/notes/{id}")
    public Flete updateNote(@PathVariable(value = "id") Long fleteId,
                                            @Valid @RequestBody Flete noteDetails) {

    	Flete flete = fleteRepository.findById(fleteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", fleteId));

    	flete.setCategoria(noteDetails.getCategoria());
    	flete.setEstado(noteDetails.getEstado());

        Flete updatedNote = fleteRepository.save(flete);
        return updatedNote;
    }
}