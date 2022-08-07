package com.hackathonteam3.api.services;

import java.util.List;
import java.util.Optional;

import com.hackathonteam3.api.models.UserModel;

public interface UserService {
	
	UserModel createUserService(UserModel user);
	List<UserModel> getUsersService();
	Optional<UserModel> getUserService(Long id);
	UserModel updateUserService(Long id, UserModel user);
	void deleteUserService(Long id);
}
