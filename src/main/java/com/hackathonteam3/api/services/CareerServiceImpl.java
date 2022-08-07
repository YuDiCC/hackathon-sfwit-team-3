package com.hackathonteam3.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonteam3.api.models.Career;
import com.hackathonteam3.api.repositories.CareerJpaRepository;

@Service
public class CareerServiceImpl implements CareerService {
	
	@Autowired
	CareerJpaRepository repositorio;

	@Override
	public Career saveCareer(Career career) {
		return repositorio.save(career);
	}

	@Override
	public List<Career> getCareers() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Career> getCareer(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public Career updateCareer(Long id, Career career) {
		return repositorio.findById(id)
				.map(careerfound -> {
					careerfound.setName(career.getName());
					careerfound.setDescription(career.getDescription());
					careerfound.setLevel(career.getLevel());
					careerfound.setRequirements(career.getRequirements());
					return repositorio.save(careerfound);
				})
				.orElseGet(() -> {
					career.setId(id);
					return repositorio.save(career);
				});
	}

	@Override
	public void deleteCareer(Long id) {
		repositorio.deleteById(id);
	}
	
	

}
