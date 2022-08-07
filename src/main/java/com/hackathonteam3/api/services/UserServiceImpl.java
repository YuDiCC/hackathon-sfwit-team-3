package com.hackathonteam3.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonteam3.api.models.UserModel;
import com.hackathonteam3.api.repositories.UserJpaRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserJpaRepository repositorio;

	@Override
	public UserModel createUserService(UserModel user) {
		return repositorio.save(user);
	}

	@Override
	public List<UserModel> getUsersService() {
		return repositorio.findAll();
	}
	
	@Override
	public Optional<UserModel> getUserService(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public UserModel updateUserService(Long id, UserModel user) {
		return repositorio.findById(id)
				.map(userfound -> {
					userfound.setEmail(user.getEmail());
					userfound.setPassword(user.getPassword());
					userfound.setStatus(user.getStatus());
					userfound.setIs_student(user.getIs_student());
				return repositorio.save(userfound);
				})
			      .orElseGet(() -> {
			        user.setId(id);
			        return repositorio.save(user);
			      });
		}

	@Override
	public void deleteUserService(Long id) {
		repositorio.deleteById(id);
		
	}

}
