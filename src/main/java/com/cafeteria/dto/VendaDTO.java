package com.cafeteria.dto;

import java.util.Date;

import com.cafeteria.entities.Venda;

public class VendaDTO {
	
	private Long id;

	private Long cliente;
	
	private ProdutoDTO produto;
	
	private Date dt_venda;

	public VendaDTO(Venda venda) {
		this.id = venda.getId();
		this.produto = new ProdutoDTO(venda.getProduto());
		this.cliente = venda.getCliente().getId();
		this.dt_venda = venda.getDt_venda();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public Date getDt_venda() {
		return dt_venda;
	}

	public void setDt_venda(Date dt_venda) {
		this.dt_venda = dt_venda;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}
}
