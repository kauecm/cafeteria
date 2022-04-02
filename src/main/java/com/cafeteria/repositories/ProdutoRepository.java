package com.cafeteria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafeteria.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
 
}
