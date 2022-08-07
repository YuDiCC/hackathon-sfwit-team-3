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

import com.hackathonteam3.api.models.University;
import com.hackathonteam3.api.services.UniversityService;

@RestController
@RequestMapping("/universities")
public class UniversitiesController {

		@Autowired
		UniversityService uServ;

		//Endpoint para crear usuario
			@PostMapping("/")
			public University createUniversity( @RequestBody University university) {
				return uServ.saveUniversity(university);
			}
			
			//Endpoint para ver todos los usuarios
			@GetMapping("/")
			public List<University> readUniversitys() {
				return uServ.getUniversities();
			}
			
			//Endpoint para ver un usuario
			@GetMapping("/{id}")
			public Optional<University> readUniversity(@PathVariable Long id) {
				return uServ.getUniversity(id);
			}
			
			//Endpoint para actualizar un usuario por Id
			@PatchMapping("/{id}")
			public University updateUniversity(@PathVariable("id") Long id, @RequestBody University university) {
				return uServ.updateUniversity(id,university);
			}
			
			//Endpoint para eliminar un usuario por Id
			@DeleteMapping("/{id}")
			public void deleteUniversity(@PathVariable("id") Long id) {
				uServ.deleteUniversity(id);
			}
		

}
