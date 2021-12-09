package org.generation.BeeLearn.controller;

import java.util.List;

import org.generation.BeeLearn.modelsbee.AlunoModel;
import org.generation.BeeLearn.repository.AlunoRepository;
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
@RequestMapping("/aluno")
@CrossOrigin("*")

public class AlunoController {
	@Autowired
	private AlunoRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity<List<AlunoModel>>GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <AlunoModel> GetById (@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<AlunoModel>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllBytituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping("/save")
	public ResponseEntity<AlunoModel> post (@RequestBody AlunoModel postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping("/update")
	public ResponseEntity<AlunoModel> put (@RequestBody AlunoModel postagem){
		return ResponseEntity.status (HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
}
