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

import com.hackathonteam3.api.models.Career;
import com.hackathonteam3.api.services.CareerService;

@RestController
@RequestMapping("/careers")
public class CareersController {
	
	@Autowired
	CareerService caServ;
	
	@PostMapping("/")
	public Career createCareer(@RequestBody Career career) {
		return caServ.saveCareer(career);
	}
	
	@GetMapping("/")
	public List<Career> readCareers(){
		return caServ.getCareers();
	}
	
	@GetMapping("/{id}")
	public Optional<Career> readCareer(@PathVariable Long id){
		return caServ.getCareer(id);		
	}
	
	@PatchMapping("/{id}")
	public Career updateCareer(@PathVariable("id") Long id, @RequestBody Career career) {
		return caServ.updateCareer(id,career);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCareer(@PathVariable("id") Long id) {
		caServ.deleteCareer(id);
	}

}
