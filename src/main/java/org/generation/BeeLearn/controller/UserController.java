package org.generation.BeeLearn.controller;


import java.util.Optional;

import javax.validation.Valid;

import org.generation.BeeLearn.modelsbee.UserLogin;
import org.generation.BeeLearn.modelsbee.UserModel;
import org.generation.BeeLearn.modelsbee.dtos.UserCredentialsDTO;
import org.generation.BeeLearn.modelsbee.dtos.UserLoginDTO;
import org.generation.BeeLearn.modelsbee.dtos.UserRegisterDTO;
import org.generation.BeeLearn.repository.UserRepository;
import org.generation.BeeLearn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

	private @Autowired UserService services;
	private @Autowired UserRepository repository;


    @PostMapping("/register")
    public ResponseEntity<UserModel> save(@Valid @RequestBody UserRegisterDTO newUser){
    	return services.registerUser(newUser);
    }
    
    @DeleteMapping("delete/{idUsuario}")
	public void delete(@PathVariable(value = "idUsuario") Long id) {
		repository.deleteById(id);
	}
    
    @PutMapping("/credentials")
    public ResponseEntity<UserLogin> credentials(@Valid @RequestBody UserLogin user){
    	return services.getCredentials(user);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getProfile(@RequestHeader("Authorization") String auth){
        return ResponseEntity.status(200).body(repository.findByToken(auth.replace("Basic ","")));
    }
    
	@PostMapping("/logar") 
	public ResponseEntity<UserLoginDTO> Autentication(@RequestBody Optional<UserLoginDTO> user){
		return services.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
				
	}
    

}
