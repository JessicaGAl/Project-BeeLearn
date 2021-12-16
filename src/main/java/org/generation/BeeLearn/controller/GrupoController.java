package org.generation.BeeLearn.controller;

import java.util.List;


import javax.validation.Valid;

import org.generation.BeeLearn.modelsbee.GrupoModels;
import org.generation.BeeLearn.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*" )
@RequestMapping("/grup")

public class GrupoController {

	@Autowired
	private GrupoRepository repository;

	
	@GetMapping
	public ResponseEntity<List<GrupoModels>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{idGrupo}")
	ResponseEntity<GrupoModels> GetById(@PathVariable Long idGrupo) {
		return repository.findById(idGrupo).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nomeGrupo/{nomeGrupo}")
	public ResponseEntity<List<GrupoModels>> GetByName(@PathVariable(value = "nomeGrupo") String nomeGrupo) {
		return ResponseEntity.ok(repository.findAllByNomeGrupoContainingIgnoreCase(nomeGrupo));
	}

	@PostMapping
	public ResponseEntity<GrupoModels> post(@Valid @RequestBody GrupoModels nomeGrupoModels) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nomeGrupoModels));
	}

	@PutMapping
	public ResponseEntity<GrupoModels> put(@Valid @RequestBody GrupoModels nomeGrupoModels) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(nomeGrupoModels));
	}

	@DeleteMapping("/{idGrupo}")
	public void delete(@PathVariable Long idGrupo) {
		repository.deleteById(idGrupo);
	}

}
