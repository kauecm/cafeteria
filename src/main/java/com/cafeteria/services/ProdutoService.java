package com.cafeteria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.entities.Produto;
import com.cafeteria.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	
	public Produto findById(Long id) {
		return repo.findById(id).get();
	}

	
	public List<Produto> findAll(){
		return repo.findAll();
	}
	
	
	public Produto insert(Produto obj) {
		Produto prod = new Produto();
		prod.setDescricao(obj.getDescricao());
		prod.setCategoria(obj.getCategoria());
		prod.setValor(obj.getValor());
		prod.setNome(obj.getNome());
		repo.save(prod);
		return obj;
	}
	
	
	public Produto update(Produto obj) {
		Produto prod = repo.findById(obj.getId()).get();
		prod.setNome(obj.getNome());
		prod.setDescricao(obj.getDescricao());
		repo.save(prod);
		return prod;
	}
	
	public void delete(Long id) {
		Produto cli = repo.findById(id).get();
		repo.delete(cli);
	}
	
}
