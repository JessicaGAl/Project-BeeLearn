package org.generation.BeeLearn.controller;

import java.util.List;

import org.generation.BeeLearn.modelsbee.InstrutorModel;
import org.generation.BeeLearn.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

	public @Autowired InstrutorRepository repo;

	public @GetMapping("/all") List<InstrutorModel> findall() {
		return repo.findAll();
	}

	public @PostMapping("/save") InstrutorModel save(@RequestBody InstrutorModel save) {
		return repo.save(save);
	}

	public @PutMapping("/alter") InstrutorModel alter(@RequestBody InstrutorModel alter) {
		return repo.save(alter);
	}

	public @DeleteMapping("/delete/{id}") void delete(@PathVariable(value = "id") Long id) {
		repo.deleteById(id);
	}

	public @GetMapping("/all/titulo/{tituloInstrutor}") List<InstrutorModel> findByTitulo(@PathVariable(value = "tituloInstrutor") String titulo) {
		return repo.findAllByTituloInstrutorContainingIgnoreCase(titulo);
	}	

}
