package br.unifacisa.si2.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.unifacisa.si2.api.entity.Professor;
import br.unifacisa.si2.api.repository.ProfessorRepository;

@Service
@Validated
public class ProfessorService {

	@Autowired
	private ProfessorRepository repository;

	public Professor buscarPorId(String id) {
		return repository.findOne(id);
	}
	
	public Professor buscarPorNome(long nome) {
		return repository.findByNome(nome);
	}
	
	public Professor buscarPorCpf(long cpf) {
		return repository.findByCpf(cpf);
	}
	
	public Professor buscarPorArea(String area) {
		return repository.findByArea(area);
	}

	public List<Professor> listarTodosProfessores() {
		return repository.findAll();
	}

	@Transactional
	public Professor inserirProfessor(Professor professor) {
		return repository.save(professor);
	}

	@Transactional
	public Professor removerProfessor(Professor professor) {
		return repository.remove(professor);
	}

	public ProfessorRepository getRepository() {
		return repository;
	}

	public void setRepository(ProfessorRepository repository) {
		this.repository = repository;
	}
}
