package com.hackathonteam3.api.services;

import java.util.List;
import java.util.Optional;

import com.hackathonteam3.api.models.User;

public interface UserService {
	
	User saveUser(User user);
	List<User> getUsers();
	Optional<User> getUser(Long id);
	User updateUser(Long id, User user);
	void deleteUser(Long id);
}
