package com.danielabella.rest.exemplo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danielabella.rest.exemplo3.domain.Conta;
import com.danielabella.rest.exemplo3.exceptions.CpfFoundInSerasaException;
import com.danielabella.rest.exemplo3.service.ContaService;

@RestController
public class ContaController {

	@Autowired
	private ContaService contaService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity< List<Conta> > listarUsuarios() {

		List<Conta> listaUsuarios = contaService.listarTodosUsuarios();

		return new ResponseEntity<List<Conta>>(listaUsuarios, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<Conta> obterUsuario(@PathVariable int id) {

		Conta user = contaService.buscarClientePorId(id);

		if (user == null) {
			return new ResponseEntity<Conta>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Conta>(user, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<Conta> criarUsuario(@RequestBody Conta user) {

		try {
			Conta usuarioInserido = contaService.novaConta(user);
			
			return new ResponseEntity<Conta>(usuarioInserido, HttpStatus.CREATED);

		} catch(CpfFoundInSerasaException e) {
			e.printStackTrace();
			return new ResponseEntity<Conta>(HttpStatus.CONFLICT);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Conta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ContaService getContaService() {
		return contaService;
	}

	public void setContaService(ContaService contaService) {
		this.contaService = contaService;
	}

}
