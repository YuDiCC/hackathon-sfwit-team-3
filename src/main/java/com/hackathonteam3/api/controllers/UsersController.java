package com.hackathonteam3.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathonteam3.api.models.User;
import com.hackathonteam3.api.services.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UserService uServ;

	//Endpoint para crear usuario
		@PostMapping("/")
		public User createUser( @RequestBody User user) {
			return uServ.saveUser(user);
		}
		
		//Endpoint para ver todos los usuarios
		@GetMapping("/")
		public List<User> readUsers() {
			return uServ.getUsers();
		}
		
		//Endpoint para ver un usuario
		@GetMapping("/{id}")
		public Optional<User> readUser(@PathVariable Long id) {
			return uServ.getUser(id);
		}
		
		//Endpoint para actualizar un usuario por Id
		@PatchMapping("/{id}")
		public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
			return uServ.updateUser(id,user);
		}
		
		//Endpoint para eliminar un usuario por Id
		@DeleteMapping("/{id}")
		public void deleteUser(@PathVariable("id") Long id) {
			uServ.deleteUser(id);
		}
	

}
