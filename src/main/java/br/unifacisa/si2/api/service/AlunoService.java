package br.unifacisa.si2.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.unifacisa.si2.api.entity.Aluno;
import br.unifacisa.si2.api.entity.Serasa;
import br.unifacisa.si2.api.repository.AlunoRepository;

@Service
@Validated
public class AlunoService {
	
	@Autowired
	private SerasaService serasaService;

	@Autowired
	private AlunoRepository repository;

	public Aluno buscarPorId(String id) {
		return repository.findOne(id);
	}

	public Aluno buscarPorCpf(long cpf) {
		return repository.findByCpf(cpf);
	}

	public Aluno buscarPorNome(String nome) {
		return repository.findByNome(nome);
	}

	public List<Aluno> buscarPorCurso(String curso) {
		return repository.findAllByCurso(curso);
	}

	public List<Aluno> buscarPorFaculdade(String faculdade) {
		return repository.findAllByFaculdade(faculdade);
	}

	public List<Aluno> listarTodosAlunos() {
		return repository.findAll();
	}

	@Transactional
	public Aluno inserirAluno(Aluno aluno) {
		
		Serasa consta = serasaService.buscarPorCPF(aluno.getCpf());
		Serasa consta2 = serasaService.buscarPorNome(aluno.getNome());
		Aluno inserido = null;
		
		if(consta == null || consta2 == null) {
			inserido = repository.save(aluno);
		}
		return inserido;
	}
	
	@Transactional
	public Aluno removerAluno(Aluno aluno) {
		return repository.remove(aluno);
	}

	public AlunoRepository getRepository() {
		return repository;
	}

	public void setRepository(AlunoRepository repository) {
		this.repository = repository;
	}
}
