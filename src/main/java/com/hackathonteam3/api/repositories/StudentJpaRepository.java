package com.hackathonteam3.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathonteam3.api.models.StudentModel;

public interface StudentJpaRepository extends JpaRepository<StudentModel, Long>{

}
