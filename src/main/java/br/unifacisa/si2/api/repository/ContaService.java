package com.danielabella.rest.exemplo3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.danielabella.rest.exemplo3.domain.Conta;
import com.danielabella.rest.exemplo3.exceptions.CpfFoundInSerasaException;
import com.danielabella.rest.exemplo3.repository.ContaRepository;

@Service
@Validated
public class ContaService {

	@Autowired
	private ContaRepository repository;

	public Conta buscarClientePorId(int conta) {
		return repository.findOne(conta);
	}

	public List<Conta> listarTodosUsuarios() {
		return repository.findAll();
	}

	@Transactional
	public Conta novaConta(Conta conta) throws CpfFoundInSerasaException {
		return repository.save(conta);
	}

	public ContaRepository getRepository() {
		return repository;
	}

	public void setRepository(ContaRepository repository) {
		this.repository = repository;
	}

}
