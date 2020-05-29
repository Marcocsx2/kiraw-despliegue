package com.kiraw.LoginKiraw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiraw.LoginKiraw.entity.Users;
import com.kiraw.LoginKiraw.service.IUsersService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UsersController {
	
	@Autowired
	private IUsersService serviceUsers;
	@Secured({"ROLE_CLIENT"})
	@GetMapping("/users/{id}")
	public Optional<Users> listUsers(@PathVariable("id") int idUser){
		return serviceUsers.listUser(idUser);
	}
	
}
