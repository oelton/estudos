package com.desafio.service;

import java.util.List;
import java.util.Optional;

import com.desafio.entity.User;

public interface UserService {

	void add(User user);

	Optional<User> get(String login);
	
	Optional<List<User>> getList(String name);

}
