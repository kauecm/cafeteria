package com.cafeteria.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cafeteria.entities.Cliente;
import com.cafeteria.entities.Venda;

public class ClienteDTO {

	
	private Long id;
	
	private String nome;
	
	private String documento;
	
	private String email;
	
	private String telefone;
	
	private Date dt_cadastro;
	
	private List<VendaDTO> venda = new ArrayList<>();

	
	public ClienteDTO(Cliente cli) {
		this.id = cli.getId();
		this.nome = cli.getNome();
		this.documento = cli.getDocumento();
		this.email = cli.getEmail();
		this.telefone = cli.getTelefone();
		this.dt_cadastro = cli.getDt_cadastro();
		for(Venda ve: cli.getVendas()) {
			VendaDTO vendaDTO = new VendaDTO(ve);
			this.venda.add(vendaDTO);
		}
	}
	
	public ClienteDTO() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDt_cadastro() {
		return dt_cadastro;
	}

	public void setDt_cadastro(Date dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}

	public List<VendaDTO> getVenda() {
		return venda;
	}

	public void setVenda(List<VendaDTO> venda) {
		this.venda = venda;
	}
	
	
	
}
