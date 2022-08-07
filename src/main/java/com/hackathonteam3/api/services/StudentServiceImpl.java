package com.hackathonteam3.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonteam3.api.models.Student;
import com.hackathonteam3.api.repositories.StudentJpaRepository;
import com.hackathonteam3.api.repositories.UserJpaRepository;
import com.hackathonteam3.api.request.StudentRequest;


@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentJpaRepository repositorio;
	
	@Autowired
	UserJpaRepository userRepo;

	@Override
	public Optional<Student> createStudentService(StudentRequest request) {
		return userRepo.findById(request.getUser_id())
				.map(userfound ->{
				Student student =	new Student(request.getName(),request.getLastname(),request.getTuition(),request.getCountry(),request.getAddress(),userfound);
				return repositorio.save(student);
				});
	}

	@Override
	public List<Student> getStudentsService() {
		return repositorio.findAll();
	}
	
	@Override
	public Optional<Student> getStudentService(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public Student updateStudentService(Long id, Student student) {
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
