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

import br.unifacisa.si2.api.entity.Professor;
import br.unifacisa.si2.api.service.ProfessorService;

@RestController
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	@RequestMapping(value = "/professor", method = RequestMethod.GET)
	public ResponseEntity< List<Professor> > listarProfessores() {

		List<Professor> listaProfessores = professorService.listarTodosProfessores();

		return new ResponseEntity< List<Professor> >(listaProfessores, HttpStatus.OK);
	}

	@RequestMapping(value = "/professor/{id}", method = RequestMethod.GET)
	public ResponseEntity<Professor> obterProfessor(@PathVariable String id) {

		Professor professor = professorService.buscarPorId(id);

		if (professor == null) {
			return new ResponseEntity<Professor>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Professor>(professor, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/professor", method = RequestMethod.POST)
	public ResponseEntity<Professor> criarProfessor(@RequestBody Professor professor) {

		try {
			Professor professorInserido = professorService.inserirProfessor(professor);
			return new ResponseEntity<Professor>(professorInserido, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Professor>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/professor/{id}", method = RequestMethod.POST)
	public ResponseEntity<Professor> removerProfessor(@RequestBody Professor professor) {

		try {
			Professor professorRemovido = professorService.removerProfessor(professor);
			return new ResponseEntity<Professor>(professorRemovido, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Professor>(HttpStatus.BAD_REQUEST);
		}
	}

	public ProfessorService getProfessorService() {
		return professorService;
	}

	public void setProfessorService(ProfessorService professorService) {
		this.professorService = professorService;
	}

}
