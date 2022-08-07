package com.hackathonteam3.api.services;

import java.util.List;
import java.util.Optional;

import com.hackathonteam3.api.models.Student;
import com.hackathonteam3.api.request.StudentRequest;

public interface StudentService {
	Optional<Student> createStudentService(StudentRequest student);
	List<Student> getStudentsService();
	Optional<Student> getStudentService(Long id);
	Student updateStudentService(Long id, Student student);
	void deleteStudentService(Long id);	

}
