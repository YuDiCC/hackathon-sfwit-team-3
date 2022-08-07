package com.hackathonteam3.api.services;

import java.util.List;
import java.util.Optional;

import com.hackathonteam3.api.models.University;

public interface UniversityService {
	
	University saveUniversity(University university);
	List<University> getUniversities();
	Optional<University> getUniversity(Long id);
	University updateUniversity(Long id, University university);
	void deleteUniversity(Long id);

}
