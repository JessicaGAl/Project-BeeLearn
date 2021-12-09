package org.generation.BeeLearn.repository;

import java.util.List;

import org.generation.BeeLearn.modelsbee.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {

	public List<AlunoModel> findAllBytituloContainingIgnoreCase (String titulo);
	
}
