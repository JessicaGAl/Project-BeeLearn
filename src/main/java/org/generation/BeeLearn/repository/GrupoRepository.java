package org.generation.BeeLearn.repository;

import java.util.List;

import org.generation.BeeLearn.modelsbee.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
	public List<Grupo> findAllByNomeGrupoContainingIgnoreCase( String nomeGrupo);
}
