package com.hackathonteam3.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonteam3.api.models.StudentModel;
import com.hackathonteam3.api.repositories.StudentJpaRepository;
import com.hackathonteam3.api.repositories.UserJpaRepository;


@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentJpaRepository repositorio;
	
	@Autowired
	UserJpaRepository repo;

	@Override
	public StudentModel createStudentService(StudentModel student) {		
		return repositorio.save(student);
	}
	
	@Override
	public List<StudentModel> getStudentsService() {
		return repositorio.findAll();
	}
	
	@Override
	public Optional<StudentModel> getStudentService(Long id) {
		return repositorio.findById(id);
	}
	

	@Override
	public StudentModel updateStudentService(Long id, StudentModel student) {
		return repositorio.findById(id)
			      .map(studentfound -> {
			    	  studentfound.setName(student.getName());
			    	  studentfound.setLastname(student.getLastname());
			    	  studentfound.setTuition(student.getTuition());
			    	  studentfound.setCountry(student.getCountry());
			    	  studentfound.setAddress(student.getAddress());
			    	  studentfound.setUser(student.getUser());
			        return repositorio.save(studentfound);
			      })
			      .orElseGet(() -> {
			        student.setId(id);
			        return repositorio.save(student);
			      });
		
	}

	@Override
	public void deleteStudentService(Long id) {
		repositorio.deleteById(id);
	}

}
