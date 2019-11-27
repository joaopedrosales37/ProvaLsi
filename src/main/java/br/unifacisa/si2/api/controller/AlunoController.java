package br.unifacisa.si2.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unifacisa.si2.api.entity.Aluno;
import br.unifacisa.si2.api.service.AlunoService;

@RestController
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@RequestMapping(value = "/aluno", method = RequestMethod.GET)
	public ResponseEntity< List<Aluno> > listarAlunos() {

		List<Aluno> listaAlunos = alunoService.listarTodosAlunos();

		return new ResponseEntity< List<Aluno> >(listaAlunos, HttpStatus.OK);
	}

	@RequestMapping(value = "/aluno/{id}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> obterAluno(@PathVariable String id) {

		Aluno aluno = alunoService.buscarPorId(id);

		if (aluno == null) {
			return new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/aluno", method = RequestMethod.POST)
	public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno) {

		try {
			Aluno alunoInserido = alunoService.inserirAluno(aluno);
			return new ResponseEntity<Aluno>(alunoInserido, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Aluno>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/aluno", method = RequestMethod.DELETE)
	public ResponseEntity<Aluno> removerAluno(@RequestBody Aluno aluno) {

		try {
			Aluno alunoRemovido = alunoService.removerAluno(aluno);
			return new ResponseEntity<Aluno>(alunoRemovido, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Aluno>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public AlunoService getAlunoService() {
		return alunoService;
	}

	public void setUserService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

}
