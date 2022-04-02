package com.cafeteria.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.entities.Venda;
import com.cafeteria.repositories.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repo;
	
	
	public Venda findById(Long id) {
		return repo.findById(id).get();
	}

	
	public List<Venda> findAll(){
		return repo.findAll();
	}
	
	
	public Venda insert(Venda obj) {
		Venda venda= new Venda();
		venda.setCliente(obj.getCliente());
		venda.setProduto(obj.getProduto());
		venda.setDt_venda(new Date());
		repo.save(venda);
		return obj;
	}
	
	
	public Venda update(Venda obj) {
		Venda prod = repo.findById(obj.getId()).get();
		repo.save(prod);
		return prod;
	}
	
	public void delete(Long id) {
		Venda cli = repo.findById(id).get();
		repo.delete(cli);
	}
	
}
