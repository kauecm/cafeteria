package com.cafeteria.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cafeteria.entities.Cliente;
import com.cafeteria.services.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	
	@Autowired
	private ClienteService service;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
		Cliente cli = service.findById(id);		
		return ResponseEntity.ok().body(cli);
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert(@Validated @RequestBody Cliente obj){
		Cliente cli = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	
	
}
