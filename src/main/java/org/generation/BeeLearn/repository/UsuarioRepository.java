package org.generation.BeeLearn.repository;

import java.util.List;
import java.util.Optional;

import org.generation.BeeLearn.modelsbee.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

	public Optional<Usuario> findByEmailAndSenha(String email, String senha);

	public Optional<Usuario> findByEmail(String email);
}
