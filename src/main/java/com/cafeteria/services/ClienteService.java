package com.cafeteria.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.entities.Cliente;
import com.cafeteria.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	
	public Cliente findById(Long id) {
		return repo.findById(id).get();
	}

	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	
	public Cliente insert(Cliente obj) {
		Cliente clie= new Cliente();
		clie.setDocumento(obj.getDocumento());
		clie.setEmail(obj.getEmail());
		clie.setNome(obj.getNome());
		clie.setTelefone(obj.getTelefone());
		clie.setDt_cadastro(new Date());
		repo.save(clie);
		return obj;
	}
	
	
	public Cliente update(Cliente obj) {
		Cliente cli = repo.findById(obj.getId()).get();
		cli.setTelefone(obj.getTelefone());
		cli.setNome(obj.getNome());
		repo.save(cli);
		return cli;
	}
	
	public void delete(Long id) {
		Cliente cli = repo.findById(id).get();
		repo.delete(cli);
	}
	
}
