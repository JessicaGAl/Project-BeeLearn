package org.generation.BeeLearn.services;

import java.nio.charset.Charset;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.generation.BeeLearn.modelsbee.UserLogin;
import org.generation.BeeLearn.modelsbee.UserModel;
import org.generation.BeeLearn.modelsbee.dtos.UserCredentialsDTO;
import org.generation.BeeLearn.modelsbee.dtos.UserLoginDTO;
import org.generation.BeeLearn.modelsbee.dtos.UserRegisterDTO;
import org.generation.BeeLearn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

	private @Autowired UserRepository repository;
	private UserLogin credentials;
	private UserModel user;

	private static String criptoPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

	private static String generatorToken(String email, String password) {
		String structure = email + ":" + password;
		byte[] structureBase64 = Base64.encodeBase64(structure.getBytes(Charset.forName("US-ASCII")));
		return new String(structureBase64);
	}

	private static String generatorTokenBasic(String email, String password) {
		String structure = email + ":" + password;
		byte[] structureBase64 = Base64.encodeBase64(structure.getBytes(Charset.forName("US-ASCII")));
		return "Basic" + new String(structureBase64);

	}

	public ResponseEntity<UserModel> registerUser(@Valid UserRegisterDTO newUser) {

		Optional<UserModel> optional = repository.findByEmail(newUser.getEmail());

		if (optional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Este email já se encontra cadastrado, favor realizar o login");
		} else {
			UserModel user = new UserModel();
			user.setNomeUsuario(newUser.getNomeUsuario());
			user.setEmail(newUser.getEmail());
			user.setToken(generatorToken(newUser.getEmail(), newUser.getSenha()));
			user.setTokenBasic(generatorTokenBasic(newUser.getEmail(), newUser.getSenha()));
			user.setSenha(criptoPassword(newUser.getSenha()));
			return ResponseEntity.status(201).body(repository.save(user));
		}
	}

	public ResponseEntity<UserLogin> getCredentials(@Valid UserLogin userDto) {
		return repository.findByEmail(userDto.getEmail()).map(resp -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			if (encoder.matches(userDto.getSenha(), resp.getSenha())) {

				credentials = new UserLogin();
				credentials.setIdUsuario(resp.getIdUsuario());
				credentials.setEmail(resp.getEmail());
				credentials.setToken(resp.getToken());
				credentials.setTokenBasic(generatorTokenBasic(userDto.getEmail(), userDto.getSenha()));

				return ResponseEntity.status(200).body(credentials);
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha incorreta!");
			}

		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email incorreto!"));

	}
	
	public Optional<UserLoginDTO> Logar(Optional<UserLoginDTO> user){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UserModel> usuario = repository.findByEmail(user.get().getEmail());
		
		if(usuario.isPresent()) {
			if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				
				String auth = user.get().getNomeUsuario() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "basic " + new String(encodedAuth);
				
				user.get().setToken(authHeader);
				user.get().setId(usuario.get().getIdUsuario());
				user.get().setNomeUsuario(usuario.get().getNomeUsuario());
				user.get().setUrlAvatar(usuario.get().getUrlAvatar());
				user.get().setNivel(usuario.get().getNivel());
				user.get().setXp(usuario.get().getXp());
				
				
				
				return user;
			}
		}
		return null;
				
		
		
	}

}
