package org.generation.BeeLearn.repository;

import java.util.List;

import org.generation.BeeLearn.modelsbee.PostagensModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagensRepository extends JpaRepository<PostagensModel, Long> {
	public List<PostagensModel> findAllByPostagemContainingIgnoreCase(String postagem);

}
