package org.generation.BeeLearn.repository;

import java.util.List;

import org.generation.BeeLearn.modelsbee.GrupoModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GrupoRepository extends JpaRepository <GrupoModels, Long>{
	 public List<GrupoModels> findAllByNomeGrupoContainingIgnoreCase(String nomeGrupo);

}