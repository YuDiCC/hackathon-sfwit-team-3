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

import com.hackathonteam3.api.models.UserModel;
import com.hackathonteam3.api.services.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UserService userService;

	//Endpoint para crear usuario
		@PostMapping("/")
		public UserModel createUser( @RequestBody UserModel user) {
			return userService.createUserService(user);
		}
		
		//Endpoint para ver todos los usuarios
		@GetMapping("/")
		public List<UserModel> readUser() {
			return userService.getUsersService();
		}
		
		//Endpoint para ver un usuario
		@GetMapping("/{id}")
		public Optional<UserModel> readUser(@PathVariable Long id) {
			return userService.getUserService(id);
		}
		
		//Endpoint para actualizar un usuario por Id
		@PatchMapping("/{id}")
		public UserModel updateUser(@PathVariable("id") Long id, @RequestBody UserModel user) {
			return userService.updateUserService(id,user);
		}
		
		//Endpoint para eliminar un usuario por Id
		@DeleteMapping("/{id}")
		public void deleteUser(@PathVariable("id") Long id) {
			userService.deleteUserService(id);
		}
	

}
