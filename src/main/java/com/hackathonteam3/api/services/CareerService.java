package com.hackathonteam3.api.services;

import java.util.List;
import java.util.Optional;

import com.hackathonteam3.api.models.Career;

public interface CareerService {

	Career saveCareer(Career career);
	List<Career> getCareers();
	Optional<Career> getCareer(Long id);
	Career updateCareer(Long id, Career career);
	void deleteCareer(Long id);

}