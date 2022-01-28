package org.generation.BeeLearn.repository;

import java.util.List;
import java.util.Optional;

import org.generation.BeeLearn.modelsbee.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends JpaRepository<UserModel, Long>{
	public List<UserModel> findAllByNomeUsuarioContainingIgnoreCase(String nomeUsuario);
	
	public Optional<UserModel> findByEmail(String email);
	
	public Optional<UserModel> findByToken(String token);
	
	public Optional<UserModel> findByIdUsuario(Long idUsuario);
	
	public Optional<UserModel> findByNomeUsuario(String nomeUsuario);

}
