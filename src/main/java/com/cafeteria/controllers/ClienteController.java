package com.cafeteria.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cafeteria.controllers.exceptions.ControllerException;
import com.cafeteria.dto.ClienteDTO;
import com.cafeteria.entities.Cliente;
import com.cafeteria.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping(path = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
		ClienteDTO cli = service.findById(id);
		return ResponseEntity.ok().body(cli);
	}

	@GetMapping
	public ResponseEntity<Page<ClienteDTO>> findAll(Pageable pageable) {
		Page<ClienteDTO> dto = service.findAll(pageable);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@Validated @RequestBody ClienteDTO obj) {
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping(path ="/fidelidade/{id}")
	public ResponseEntity<ClienteDTO> findByClienteFiel(@PathVariable Long id){
			Cliente cli = service.findByIdCliente(id);
			ClienteDTO cliDTO = service.findByClienteFiel(cli);
			return ResponseEntity.ok().body(cliDTO);	
		
	}

}
