package org.generation.BeeLearn.controller;

import java.util.List;

import org.generation.BeeLearn.modelsbee.Grupo;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/grupo")
public class GrupoController {
	
	@Autowired
	private GrupoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Grupo>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idGrupo}")
	public ResponseEntity<Grupo> getById(@PathVariable long idGrupo){
		return repository.findById(idGrupo).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nomeGrupo}")
	public ResponseEntity<List<Grupo>> getByName(@PathVariable String nomeGrupo){
		return ResponseEntity.ok(repository.findAllByNomeGrupoContainingIgnoreCase(nomeGrupo));
	}
	
	@PostMapping
	public ResponseEntity<Grupo> post (@RequestBody Grupo grupo){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(grupo));
	}

	@PutMapping
	public ResponseEntity<Grupo> put (@RequestBody Grupo grupo){
		return ResponseEntity.ok(repository.save(grupo));				
	}
	
	@DeleteMapping("/{idGrupo}")
	public void delete(@PathVariable long idGrupo) {
		repository.deleteById(idGrupo);
	}
	
}
