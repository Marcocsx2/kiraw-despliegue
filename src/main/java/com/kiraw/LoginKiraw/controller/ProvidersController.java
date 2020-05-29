package com.kiraw.LoginKiraw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kiraw.LoginKiraw.entity.Provider;
import com.kiraw.LoginKiraw.service.IProviderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProvidersController {
	@Autowired
	private IProviderService providerService;
	@PostMapping("/proovedor")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Provider create(@RequestBody Provider provider) {
		return providerService.save(provider);
	}

}
