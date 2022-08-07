package com.hackathonteam3.api.services;

import java.util.List;
import java.util.Optional;

import com.hackathonteam3.api.models.StudentModel;

public interface StudentService {
	StudentModel createStudentService(StudentModel student);
	List<StudentModel> getStudentsService();
	Optional<StudentModel> getStudentService(Long id);
	StudentModel updateStudentService(Long id, StudentModel student);
	void deleteStudentService(Long id);	

}
