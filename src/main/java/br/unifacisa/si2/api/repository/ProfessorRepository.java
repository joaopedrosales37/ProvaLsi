package br.unifacisa.si2.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unifacisa.si2.api.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, String> {

	Professor findByCpf(long cpf);

	Professor findByArea(String area);

	Professor findByNome(long nome);

	Professor remove(Professor professor);

	
}
