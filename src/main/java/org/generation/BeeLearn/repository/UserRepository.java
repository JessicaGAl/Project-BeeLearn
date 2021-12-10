package org.generation.BeeLearn.repository;

import java.util.List;

import org.generation.BeeLearn.modelsbee.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends JpaRepository<UserModel, Long>{
	public List<UserModel> findAllByNomeUsuarioContainingIgnoreCase(String nomeUsuario);

}
