package org.generation.BeeLearn.controller;

import java.util.List;
import javax.validation.Valid;

import org.generation.BeeLearn.modelsbee.UserModel;
import org.generation.BeeLearn.repository.UserRepository;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

	private @Autowired UserServices services;

    @PostMapping
    public ResponseEntity<UserModel> save(@Valid @RequestBody UserRegisterDTO newUser){
    	return services.registerUser(newUser);
    }
    
    @PutMapping("/credentials")
    public ResponseEntity<UserCredentialsDTO> credentials(@Valid @RequestBody UserLoginDTO user){
    	return services.getCredentials(user);
    }

    @GetMapping
    public ResponseEntity<?> getProfile(@RequestHeader("Authorization") String auth){
        return ResponseEntity.status(200).body(repository.findByToken(auth.replace("Basic ","")));
    }
    

}
