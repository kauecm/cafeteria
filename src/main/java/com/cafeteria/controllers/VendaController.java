package com.cafeteria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafeteria.entities.Venda;
import com.cafeteria.services.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {

	@Autowired
	private VendaService service;

	@GetMapping
	public ResponseEntity<List<Venda>> findAll(){
		List<Venda> vendas = service.findAll();
		return ResponseEntity.ok().body(vendas);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Venda obj){
		service.insert(obj);
		return ResponseEntity.ok().build();
	}
	
}
