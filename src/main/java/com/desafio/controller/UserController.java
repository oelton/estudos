package com.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.entity.User;
import com.desafio.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void user(@RequestBody User user) {
		userService.add(user);
	}

	@GetMapping("{login}")
	public User user(@PathVariable String login) {
		return userService.get(login)
				.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado - " + login));
	}

	@GetMapping("/list/{name}")
	public List<User> userName(@PathVariable String name) {
		return userService.getList(name)
				.orElseThrow(() -> new IllegalArgumentException("Nome não encontrado - " + name));
	}

}
