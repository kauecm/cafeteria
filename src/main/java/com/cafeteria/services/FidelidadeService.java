package com.cafeteria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.entities.Cliente;
import com.cafeteria.entities.Venda;
import com.cafeteria.repositories.ClienteRepository;

@Service
public class FidelidadeService {

	
	@Autowired
	private ClienteRepository cliente;
	
	@Autowired
	private VendaService vendaService;
	
	private List<Venda> vendas = new ArrayList<>();
		
	public boolean clienteFiel(Cliente cli) {
	int count = 0;	
		for(Venda venda:vendaService.findAll()) {
			if(venda.getCliente() == cli) {
				vendas.add(venda);
				count++;
			}
		}
		if(count >= 10) {
			return true;
		}
		return false;
		
	}
	
	
}
