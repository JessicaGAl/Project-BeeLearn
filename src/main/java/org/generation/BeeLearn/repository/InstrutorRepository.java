package org.generation.BeeLearn.repository;

import java.util.List;

import org.generation.BeeLearn.modelsbee.InstrutorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrutorRepository extends JpaRepository<InstrutorModel, Long> {
	
	public List<InstrutorModel> findAllByTituloInstrutorContainingIgnoreCase(String tituloInstrutor);
	
}
