package com.kiraw.LoginKiraw.service;

import java.util.Optional;

import com.kiraw.LoginKiraw.entity.Users;

public interface IUsersService {
	
	Optional<Users> listUser(int idUser);
	
}
