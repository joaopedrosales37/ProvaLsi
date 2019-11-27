package br.unifacisa.si2.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.unifacisa.si2.api.entity.Serasa;
import br.unifacisa.si2.api.repository.SerasaRepository;

@Service
@Validated
public class SerasaService {

	@Autowired
	private SerasaRepository repository;

	public Serasa buscarPorId(String id) {
		return repository.findOne(id);
	}

	public List<Serasa> listarTodosInadimplentes() {
		return repository.findAll();
	}
	
	public Serasa buscarPorCPF(long cpf) {
		return repository.findCpf(cpf);
	}

	@Transactional
	public Serasa inserirInadimplente(Serasa serasa) {
		return repository.save(serasa);
	}

	public SerasaRepository getRepository() {
		return repository;
	}

	public void setRepository(SerasaRepository repository) {
		this.repository = repository;
	}

	public Serasa buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return repository.findOne(nome);
	}
}