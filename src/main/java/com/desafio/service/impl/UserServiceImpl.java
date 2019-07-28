package com.desafio.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.desafio.dao.UserRepository;
import com.desafio.entity.User;
import com.desafio.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByName(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), getAuthority());
	}
	
	private List getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

}
