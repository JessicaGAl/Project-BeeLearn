package org.generation.BeeLearn.controller;

import java.util.List;
import java.util.Optional;

import org.generation.BeeLearn.modelsbee.PostagensModel;
import org.generation.BeeLearn.repository.PostagensRepository;
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
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/postagem")
public class PostagensController {

	@Autowired
	private PostagensRepository repository;

	/** findAllPostagem */
	@GetMapping("/all")
	public ResponseEntity<List<PostagensModel>> getAll() {
		List<PostagensModel> list = repository.findAll();
		if (list.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(list);
		}
	}

	/** postPostagem */
	@PostMapping("/save")
	public ResponseEntity<PostagensModel> save(@RequestBody PostagensModel postagem) {
		return ResponseEntity.status(201).body(repository.save(postagem));
	}

	/** findByIDPostagem */
	@GetMapping("/{idPostagem}")
	public ResponseEntity<PostagensModel> findById(@PathVariable(value = "idPostagem") Long id) {
		Optional<PostagensModel> optional = repository.findById(id);

		if (optional.isPresent()) {
			return ResponseEntity.status(200).body(optional.get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não existe!");
		}
	}

	/** findByPostagem */
	@GetMapping("/postagem/{postagem}")
	public ResponseEntity<List<PostagensModel>> GetByPostagem(@PathVariable String postagem) {
		return ResponseEntity.ok(repository.findAllByPostagemContainingIgnoreCase(postagem));
	}

	/** putPostagem */
	@PutMapping("/update")
	public PostagensModel update(@RequestBody PostagensModel newPostagem) {
		return repository.save(newPostagem);
	}

	/** deletePostagem */
	@DeleteMapping("delete/{idPostagem}")
	public void delete(@PathVariable(value = "idPostagem") Long id) {
		repository.deleteById(id);
	}

}
