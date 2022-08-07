package com.hackathonteam3.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonteam3.api.models.University;
import com.hackathonteam3.api.repositories.UniversityJpaRepository;

@Service
public class UniversityServiceImpl implements UniversityService {
	
	@Autowired
	UniversityJpaRepository repositorio;

	@Override
	public University saveUniversity(University university) {
		return repositorio.save(university);
	}

	@Override
	public List<University> getUniversities() {
		return repositorio.findAll();
	}
	
	@Override
	public Optional<University> getUniversity(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public University updateUniversity(Long id, University university) {
		return repositorio.findById(id)
				.map(unifound -> {
					unifound.setName(university.getName());
					unifound.setDescription(university.getDescription());
					unifound.setContact(university.getContact());
					unifound.setCountry(university.getCountry());
					unifound.setAddress(university.getAddress());
				return repositorio.save(unifound);
				})
			      .orElseGet(() -> {
			        university.setId(id);
			        return repositorio.save(university);
			      });
		}

	@Override
	public void deleteUniversity(Long id) {
		repositorio.deleteById(id);
		
	}

}
