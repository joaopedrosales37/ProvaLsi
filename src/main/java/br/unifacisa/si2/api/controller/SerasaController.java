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

import br.unifacisa.si2.api.entity.Serasa;
import br.unifacisa.si2.api.service.SerasaService;

@RestController
public class SerasaController {

	@Autowired
	private SerasaService serasaService;

	@RequestMapping(value = "/serasa", method = RequestMethod.GET)
	public ResponseEntity< List<Serasa> > listaInadimplentes() {

		List<Serasa> listarInadimplentes = serasaService.listarTodosInadimplentes();

		return new ResponseEntity< List<Serasa> >(listarInadimplentes, HttpStatus.OK);
	}

	@RequestMapping(value = "/serasa/{id}", method = RequestMethod.GET)
	public ResponseEntity<Serasa> obterInadimplente(@PathVariable String id) {

		Serasa serasa = serasaService.buscarPorId(id);

		if (serasa == null) {
			return new ResponseEntity<Serasa>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Serasa>(serasa, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/serasa", method = RequestMethod.POST)
	public ResponseEntity<Serasa> criarInadimplente(@RequestBody Serasa serasa) {

		try {
			Serasa inadimplenteInserido = serasaService.inserirInadimplente(serasa);
			return new ResponseEntity<Serasa>(inadimplenteInserido, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Serasa>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public SerasaService getSerasaService() {
		return serasaService;
	}

	public void setSerasaService(SerasaService serasaService) {
		this.serasaService = serasaService;
	}

}
