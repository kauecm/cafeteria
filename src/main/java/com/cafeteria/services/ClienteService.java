package com.cafeteria.services;

import java.util.Date;
import java.util.ServiceConfigurationError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafeteria.dto.ClienteDTO;
import com.cafeteria.entities.Cliente;
import com.cafeteria.repositories.ClienteRepository;
import com.cafeteria.services.exceptions.ServiceException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private FidelidadeService fide;

	public ClienteDTO findById(Long id) {
			Cliente cli = repo.findById(id).get();
			ClienteDTO dto = new ClienteDTO(cli);
			return dto;
	}
	
	public Cliente findByIdCliente(Long id) {
		return repo.findById(id).get();
	}

//	public List<Cliente> findAll(){
//		return repo.findAll();
//	}
	@Transactional(readOnly = true)
	public Page<ClienteDTO> findAll(Pageable pageable) {
		Page<Cliente> obj = repo.findAll(pageable);
		Page<ClienteDTO> dto = obj.map(x -> new ClienteDTO(x));
		return dto;
	}
	
	public ClienteDTO findByClienteFiel(Cliente cli) {
		if(fide.clienteFiel(cli)) {
			return new ClienteDTO(cli);
		}else {
			throw new ServiceException("Nenhum cliente faz parte do programa de fidelidade");
		}
	}

	public Cliente insert(ClienteDTO obj) {
		Cliente clie = new Cliente();
		clie.setDocumento(obj.getDocumento());
		clie.setEmail(obj.getEmail());
		clie.setNome(obj.getNome());
		clie.setTelefone(obj.getTelefone());
		clie.setDt_cadastro(new Date());
		repo.save(clie);
		return clie;
	}

	public Cliente update(Cliente obj) {
		if (obj != null) {
			Cliente cli = repo.findById(obj.getId()).get();
			cli.setTelefone(obj.getTelefone());
			cli.setNome(obj.getNome());
			repo.save(cli);
			return cli;
		} else {
			throw new ServiceConfigurationError("Cliente não existe");
		}
	}

	public void delete(Long id) {
		Cliente cli = repo.findById(id).get();
		repo.delete(cli);
	}

}
