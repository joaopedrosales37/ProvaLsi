package br.unifacisa.si2.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unifacisa.si2.api.entity.Serasa;

public interface SerasaRepository extends JpaRepository<Serasa, String> {

	Serasa findCpf(long cpf);

	
}
