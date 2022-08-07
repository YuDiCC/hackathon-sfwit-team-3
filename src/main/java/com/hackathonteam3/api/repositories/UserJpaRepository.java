package com.hackathonteam3.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathonteam3.api.models.UserModel;

public interface UserJpaRepository extends JpaRepository<UserModel, Long>{

}
