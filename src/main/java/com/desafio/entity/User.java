package com.desafio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
public class User {

	@Id
	@GeneratedValue	(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	@NotBlank
	String name;
	
	@NotBlank
	@Column(unique=true)
	String login;
	
	@NotBlank
	@Email(message = "Email inválido!")
	String email;
	
	@NotBlank(message = "A senha não pode ser vazia")	
	String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
