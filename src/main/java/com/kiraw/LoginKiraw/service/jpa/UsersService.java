package com.kiraw.LoginKiraw.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiraw.LoginKiraw.entity.Users;
import com.kiraw.LoginKiraw.repository.UsersRepository;
import com.kiraw.LoginKiraw.service.IUsersService;

@Service
public class UsersService implements IUsersService {
	
	
	  @Autowired public UsersRepository repoUsers;
	  
	  public Optional<Users> listUser(int idUser) { return
	  repoUsers.findById(idUser); }
	  
	  
	 
}
