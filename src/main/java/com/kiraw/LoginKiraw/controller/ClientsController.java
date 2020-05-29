package com.kiraw.LoginKiraw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.stream.Collectors;

import com.kiraw.LoginKiraw.entity.Clients;
import com.kiraw.LoginKiraw.service.IClientsService;
import com.kiraw.LoginKiraw.service.IUsersService;
import com.mysql.jdbc.Field;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ClientsController {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private IClientsService clientsService;
	
//	@PostMapping("/clientes")
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public Clients create(@Valid @RequestBody Clients cliente ) {
//		//Clients clients=new Clients();
//		
//		//cliente.setUsers(passwordEncoder.encode(cliente.getUsers().getPassword()));
//		return clientsService.save(cliente);		

//	}

	@PostMapping("/cliente")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Clients cliente,BindingResult result ) {
		
		Clients clienteNew=null;
		Map<String, Object> response=new HashMap<>();
		if(result.hasErrors()) {
					
			List<String> errors=result.getFieldErrors()
									.stream()
									.map(err->"el campo"+err.getField()+" "+err.getDefaultMessage()
									).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);

		
		}
		try {
			 clienteNew=clientsService.save(cliente);
			 
		} catch (DataAccessException e) {
			response.put("mensaje","error al realizar el insert en la base de datos");
			response.put("error",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "el cliente ha sido registrado con exito");
		response.put("cliente", clienteNew);
	return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
}
