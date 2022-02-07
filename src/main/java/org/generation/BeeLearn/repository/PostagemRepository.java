package org.generation.BeeLearn.repository;

import java.util.List;

import org.generation.BeeLearn.modelsbee.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {	
	public List<Postagem> findAllByTituloPostContainingIgnoreCase (String tituloPost); 
	public List<Postagem> findAllByMateriaContainingIgnoreCase (String materia);

}

