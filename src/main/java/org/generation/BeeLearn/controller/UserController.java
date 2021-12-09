package org.generation.BeeLearn.controller;

import java.util.List;
import javax.validation.Valid;

import org.generation.BeeLearn.modelsbee.UserModel;
import org.generation.BeeLearn.repository.UserRepository;
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
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public ResponseEntity<List<UserModel>>GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id_usuario}")
	public ResponseEntity <UserModel> GetById (@PathVariable Long id_usuario){
		return repository.findById(id_usuario)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<UserModel> post (@Valid @RequestBody UserModel newuser){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(newuser));
	}
	
	@PutMapping
	public ResponseEntity<UserModel> put (@Valid @RequestBody UserModel edituser){
		return ResponseEntity.status (HttpStatus.OK).body(repository.save(edituser));
	}
	
	@DeleteMapping("/{id_usuario}")
	public void delete (@PathVariable long id_usuario) {
		repository.deleteById(id_usuario);
	}

	public UserRepository getRepository() {
		return repository;
	}


}
