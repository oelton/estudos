package com.desafio.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.dao.UserRepository;
import com.desafio.entity.User;
import com.desafio.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void add(User user) {
		userRepository.save(user);
	}

	@Override
	public Optional<User> get(String login) {
		return userRepository.findByLogin(login);			
	}

	@Override
	public Optional<List<User>> getList(String name) {
		return userRepository.findByNameContainingIgnoreCase(name);
	}

	@Override
	public void save(User user) {
		userRepository.save(userRepository.findByLogin(user.getLogin())
				.orElseThrow(() -> new IllegalArgumentException("Login não encontrado - " + user.getLogin())));
	}

}
